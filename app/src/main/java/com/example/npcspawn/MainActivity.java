package com.example.npcspawn;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_npc, button_merchant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_npc = findViewById(R.id.button_npc);
        button_merchant = findViewById(R.id.button_merchant);

        // Opens RandomNPC Activity
        button_npc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RandomNPC.class);
                startActivity(intent);
            }
        });
        // Opens RandomMerchant Activity
        button_merchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RandomMerchant.class);
                startActivity(intent);
            }
        });
    }
}