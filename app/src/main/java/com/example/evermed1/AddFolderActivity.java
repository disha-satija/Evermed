package com.example.evermed1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddFolderActivity extends AppCompatActivity {

    EditText etDiseaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_folder);

        etDiseaseName = findViewById(R.id.etDiseaseName);

        findViewById(R.id.btnSaveCategory).setOnClickListener(view -> {
            String name = etDiseaseName.getText().toString().trim();

            if (!name.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("diseaseName", name);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(this, "Please enter disease name", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCancel).setOnClickListener(view -> finish());
    }
}

