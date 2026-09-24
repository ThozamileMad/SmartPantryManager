package com.example.smartpantrymanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PantryActivity extends AppCompatActivity {

    private RecyclerView foodRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        foodRecycleView = findViewById(R.id.pantryItems);

        FoodDataSource dataSource = new FoodDataSource(this);

        List<Food> foodList = dataSource.getAllFood();

        FoodAdapter foodAdapter = new FoodAdapter(foodList);

        foodRecycleView.setLayoutManager(new LinearLayoutManager(this));
        foodRecycleView.setAdapter(foodAdapter);
    }
}
