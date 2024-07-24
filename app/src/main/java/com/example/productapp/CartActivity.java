package com.example.productapp;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private List<CartItem> cartItemList;
    private TextView totalPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        totalPriceTextView = findViewById(R.id.totalPrice);

        // Fetch cart items from the database or shared preferences
        // For simplicity, using a placeholder list here
        cartItemList = new ArrayList<>();

        adapter = new CartAdapter(cartItemList, this::onQuantityChange);
        recyclerView.setAdapter(adapter);

        Button checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });

        updateTotalPrice();
    }

    private void onQuantityChange() {
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : cartItemList) {
            totalPrice += item.product.price * item.quantity;
        }
        totalPriceTextView.setText(String.format("$%.2f", totalPrice));
    }
}