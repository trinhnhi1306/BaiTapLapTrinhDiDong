package com.phuphuc.bai10datdoan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnChonThucAn, btnChonThucUong, btnThoat;
    private TextView tvThucAn;
    private String foodName = "", drinkName = "";

    ActivityResultLauncher<Intent> foodLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        foodName = intent.getStringExtra("food");
                        tvThucAn.setText(foodName + " - " + drinkName);
                    }
                }
            });

    ActivityResultLauncher<Intent> drinkLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        drinkName = intent.getStringExtra("drink");
                        tvThucAn.setText(foodName + " - " + drinkName);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
    }

    private void setEvent() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnChonThucAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThucAnActivity.class);
                foodLauncher.launch(intent);
            }
        });

        btnChonThucUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThucUongActivity.class);
                drinkLauncher.launch(intent);
            }
        });
    }

    private void setControl() {
        getSupportActionBar().setTitle("Thực hành chương 2");
        btnChonThucAn = findViewById(R.id.btnChonThucAn);
        btnChonThucUong = findViewById(R.id.btnChonThucUong);
        btnThoat = findViewById(R.id.btnThoat);
        tvThucAn = findViewById(R.id.tvThucAn);
    }
}