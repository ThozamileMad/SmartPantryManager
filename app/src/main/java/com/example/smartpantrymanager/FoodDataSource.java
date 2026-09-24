package com.example.smartpantrymanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FoodDataSource {
    private final FoodDbHelper dbHelper;

    public FoodDataSource(Context context) {
        dbHelper = new FoodDbHelper(context);
    }

    public List<Food> getAllFood() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        List<Food> foodList = new ArrayList<>();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM food",
                null
        );

        while (cursor.moveToNext()) {
            int id = cursor.getInt(
                    cursor.getColumnIndexOrThrow("id")
            );

            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow("name")
            );

            int quantity = cursor.getInt(
                    cursor.getColumnIndexOrThrow("quantity")
            );

            String unit = cursor.getString(
                    cursor.getColumnIndexOrThrow("unit")
            );

            String expiryDate = cursor.getString(
                    cursor.getColumnIndexOrThrow("expiry_date")
            );

            Food food = new Food(
                    id,
                    name,
                    quantity,
                    unit,
                    expiryDate
            );

            foodList.add(food);
        }

        cursor.close();

        return foodList;
    }
}
