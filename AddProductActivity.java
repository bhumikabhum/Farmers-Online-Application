package com.farmerapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.farmerapp.database.DBHelper;
import android.database.sqlite.SQLiteDatabase;

public class AddProductActivity extends AppCompatActivity {
    EditText nameInput, priceInput, qtyInput;
    Button saveButton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        nameInput = findViewById(R.id.product_name);
        priceInput = findViewById(R.id.product_price);
        qtyInput = findViewById(R.id.product_qty);
        saveButton = findViewById(R.id.save_product);
        dbHelper = new DBHelper(this);

        saveButton.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO products(name, price, quantity, farmer_id) VALUES(?, ?, ?, ?)",
                    new Object[]{nameInput.getText().toString(),
                            Double.parseDouble(priceInput.getText().toString()),
                            Integer.parseInt(qtyInput.getText().toString()), 1});
            Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
