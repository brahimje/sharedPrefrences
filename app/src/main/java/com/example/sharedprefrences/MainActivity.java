package com.example.sharedprefrences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView displayText;
    private Button saveButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        displayText = findViewById(R.id.displayText);
        saveButton = findViewById(R.id.saveButton);

        // Initialize SharedPreferences
        sharedPreferences = getPreferences(MODE_PRIVATE);

        String info = sharedPreferences.getString("text", "");
        // Load saved text on app launch
        displayText.setText(info);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the entered text to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("text", editText.getText().toString());
                editor.apply();

                // Display the saved text
                displayText.setText(editText.getText().toString());
            }
        });
    }
}
