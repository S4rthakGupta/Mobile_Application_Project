package com.example.productapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Implement checkout logic here

        Button placeOrderButton = findViewById(R.id.placeOrderButton);
        placeOrderButton.setOnClickListener(v -> {
            Intent intent = new Intent(CheckoutActivity.this, ThankYouActivity.class);
            startActivity(intent);
        });
    }
}
