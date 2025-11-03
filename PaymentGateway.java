package com.farmerapp.utils;

import android.content.Context;
import android.widget.Toast;

public class PaymentGateway {
    public static void processPayment(Context context, double amount) {
        // Simulated Payment Logic
        Toast.makeText(context, "Payment of ₹" + amount + " successful!", Toast.LENGTH_LONG).show();
    }
}
