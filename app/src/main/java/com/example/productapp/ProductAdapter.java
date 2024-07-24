package com.example.productapp;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList;
    private OnProductClickListener onProductClickListener;

    public interface OnProductClickListener {
        void onProductClick(Product product);
    }

    public ProductAdapter(List<Product> productList, OnProductClickListener onProductClickListener) {
        this.productList = productList;
        this.onProductClickListener = onProductClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product, onProductClickListener);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView, descriptionTextView, priceTextView;
        public Button addToCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.productImage);
            nameTextView = itemView.findViewById(R.id.productName);
            descriptionTextView = itemView.findViewById(R.id.productDescription);
            priceTextView = itemView.findViewById(R.id.productPrice);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }

        public void bind(Product product, OnProductClickListener onProductClickListener) {
            nameTextView.setText(product.name);
            descriptionTextView.setText(product.description);
            priceTextView.setText(String.format("$%.2f", product.price));
            // Load image using your preferred image loading library

            itemView.setOnClickListener(v -> onProductClickListener.onProductClick(product));
        }
    }
}