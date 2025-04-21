package com.example.evermed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login); // this refers to the XML layout

        // Apply insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Handle signup link click
        TextView signupLink = findViewById(R.id.signup_link);
        signupLink.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUp.class); // Replace with your actual signup activity class
            startActivity(intent);
        });

        ImageView doctorLogin = findViewById(R.id.login_doctor);
        doctorLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, DoctorProfile.class);
            startActivity(intent);
        });
    }
}
