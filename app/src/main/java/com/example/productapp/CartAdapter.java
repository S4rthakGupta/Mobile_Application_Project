package com.example.productapp;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<CartItem> cartItemList;
    private OnQuantityChangeListener onQuantityChangeListener;

    public interface OnQuantityChangeListener {
        void onQuantityChange();
    }

    public CartAdapter(List<CartItem> cartItemList, OnQuantityChangeListener onQuantityChangeListener) {
        this.cartItemList = cartItemList;
        this.onQuantityChangeListener = onQuantityChangeListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItemList.get(position);
        holder.bind(cartItem, onQuantityChangeListener);
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, priceTextView, quantityTextView;
        public Button increaseQuantityButton, decreaseQuantityButton, removeButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.productName);
            priceTextView = itemView.findViewById(R.id.productPrice);
            quantityTextView = itemView.findViewById(R.id.quantity);
            increaseQuantityButton = itemView.findViewById(R.id.increaseQuantity);
            decreaseQuantityButton = itemView.findViewById(R.id.decreaseQuantity);
            removeButton = itemView.findViewById(R.id.removeButton);
        }

        public void bind(CartItem cartItem, OnQuantityChangeListener onQuantityChangeListener) {
            nameTextView.setText(cartItem.product.name);
            priceTextView.setText(String.format("$%.2f", cartItem.product.price));
            quantityTextView.setText(String.valueOf(cartItem.quantity));

            increaseQuantityButton.setOnClickListener(v -> {
                cartItem.quantity++;
                quantityTextView.setText(String.valueOf(cartItem.quantity));
                onQuantityChangeListener.onQuantityChange();
            });

            decreaseQuantityButton.setOnClickListener(v -> {
                if (cartItem.quantity > 1) {
                    cartItem.quantity--;
                    quantityTextView.setText(String.valueOf(cartItem.quantity));
                    onQuantityChangeListener.onQuantityChange();
                }
            });

            removeButton.setOnClickListener(v -> {
                // Remove item from cart
                onQuantityChangeListener.onQuantityChange();
            });
        }
    }
}
