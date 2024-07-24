package com.example.productapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch data from the database
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        productList = db.productDao().getAllProducts();

        adapter = new ProductAdapter(productList, this::onProductClick);
        recyclerView.setAdapter(adapter);
    }

    private void onProductClick(Product product) {
        Intent intent = new Intent(ProductActivity.this, ProductDetailActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}
