package com.example.evermed1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FolderActivity extends AppCompatActivity {

    LinearLayout folderContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        folderContainer = findViewById(R.id.folderContainer);

        findViewById(R.id.btnAddFolder).setOnClickListener(view -> {
            Intent intent = new Intent(FolderActivity.this, AddFolderActivity.class);
            startActivityForResult(intent, 1);  // Request code is 1
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String diseaseName = data.getStringExtra("diseaseName");

            View folderView = LayoutInflater.from(this).inflate(R.layout.item_folder, folderContainer, false);
            TextView folderNameText = folderView.findViewById(R.id.tvFolderName);
            folderNameText.setText(diseaseName);
            folderContainer.addView(folderView);

            Toast.makeText(this, "✅ Your folder is added.", Toast.LENGTH_SHORT).show();
        }
    }
}
