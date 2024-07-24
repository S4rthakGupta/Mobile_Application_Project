package com.example.productapp;

public class ProductDetailActivity extends AppCompatActivity {
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        product = (Product) getIntent().getSerializableExtra("product");

        ImageView productImageView = findViewById(R.id.productImage);
        TextView productNameTextView = findViewById(R.id.productName);
        TextView productDescriptionTextView = findViewById(R.id.productDescription);
        TextView productPriceTextView = findViewById(R.id.productPrice);
        EditText quantityEditText = findViewById(R.id.quantity);
        Button addToCartButton = findViewById(R.id.addToCartButton);
        Button goToCartButton = findViewById(R.id.goToCartButton);

        productNameTextView.setText(product.name);
        productDescriptionTextView.setText(product.description);
        productPriceTextView.setText(String.format("$%.2f", product.price));
        // Load image using your preferred image loading library

        addToCartButton.setOnClickListener(v -> {
            // Add product to cart logic
        });

        goToCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}