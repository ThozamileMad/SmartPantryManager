package com.example.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();

        int foodId = intent.getIntExtra("food_id", -1);
        String foodName = intent.getStringExtra("food_name");
        int foodQuantity = intent.getIntExtra("food_quantity", 0);
        String foodUnit = intent.getStringExtra("food_unit");
        String foodExpiryDate = intent.getStringExtra("food_expiry_date");

        EditText nameEdt = findViewById(R.id.nameEdt);
        nameEdt.setText(foodName);

        EditText qtyEdt = findViewById(R.id.qtyEdt);
        qtyEdt.setText(String.valueOf(foodQuantity));

        EditText unitEdt = findViewById(R.id.unitEdt);
        unitEdt.setText(foodUnit);

        EditText expDateEdt = findViewById(R.id.expDateEdt);
        expDateEdt.setText(foodExpiryDate);

    }
}
