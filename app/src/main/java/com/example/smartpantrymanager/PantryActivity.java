package com.example.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.internal.FlowLayout;

import java.util.List;

public class PantryActivity extends AppCompatActivity {
    // RecyclerView
    private RecyclerView foodRecycleView;

    // Data Source - Responsible for data retrieval and CRUD
    private FoodDataSource dataSource;

    // List for retrieved DB items (from FoodDataSource)
    private List<Food> foodList;

    // FoodAdapter
    private FoodAdapter foodAdapter;

    // Button
    Button addFoodBtn;

    // Clickable Navigation Fields
    private LinearLayout recipeNavField;
    private LinearLayout settingsNavField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        foodRecycleView = findViewById(R.id.ptryItems);

        dataSource = new FoodDataSource(this);

        foodList = dataSource.getAllFood();

        foodAdapter = new FoodAdapter(this, foodList);

        foodRecycleView.setLayoutManager(new LinearLayoutManager(this));
        foodRecycleView.setAdapter(foodAdapter);

        addFoodBtn = findViewById(R.id.ptryAddFoodBtn);
        addFoodBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddActivity.class);
            this.startActivity(intent);
        });

        recipeNavField = findViewById(R.id.ptryRecipesNavGroup);
        recipeNavField.setOnClickListener(v -> {
            //Intent intent = new Intent(this, RecipeActivity.class);
            //this.startActivity(intent);
        });

        settingsNavField = findViewById(R.id.ptrySettingsNavGroup);
        settingsNavField.setOnClickListener(v -> {
            //Intent intent = new Intent(this, SettingsActivity.class);
            //this.startActivity(intent);
        });
    }
}
