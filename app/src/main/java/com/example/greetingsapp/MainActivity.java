package com.example.greetingsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.greetingsapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView greeting = findViewById(R.id.greetingMessage);
        EditText nameInput = findViewById(R.id.nameInput);
        Button greetButton = findViewById(R.id.greetButton);
        ImageView smileEmoji = findViewById(R.id.smileEmoji);

        smileEmoji.setVisibility(View.GONE);
        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameInput.getText().toString();

                // Check if input is empty and update textview

                if(!name.isEmpty()){
                    greeting.setText("Hello, " + name + "!");

                    if (name.contains("happy") || name.contains("joyful") || name.contains("excited")) {
                        smileEmoji.setImageResource(R.drawable.smile_emoji);
                        smileEmoji.setVisibility(View.VISIBLE);
                    }

                } else {
                    greeting.setText("Please enter your name.");
                }
            }
        });


    }
}

