package com.phuphuc.bai10datdoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ThucAnActivity extends AppCompatActivity implements IFoodItemClickListener {

    private ListView lvThucAn;
    private List<ThucAn> thucAnList;
    private ThucAnAdapter thucAnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_an);

        setControl();
        setEvent();
    }

    private void setEvent() {
        getData();
        thucAnAdapter = new ThucAnAdapter(this, R.layout.item_thuc_an, thucAnList);
        lvThucAn.setAdapter(thucAnAdapter);
    }

    private void getData() {
        thucAnList = new ArrayList<>();
        thucAnList.add(new ThucAn(R.drawable.banh_canh, "Bánh canh", 0));
        thucAnList.add(new ThucAn(R.drawable.bun_bo, "Bún bò", 0));
        thucAnList.add(new ThucAn(R.drawable.chao, "Cháo", 0));
        thucAnList.add(new ThucAn(R.drawable.pho, "Phở", 0));
    }

    private void setControl() {
        getSupportActionBar().setTitle("Thức ăn");
        lvThucAn = findViewById(R.id.lvThucAn);
    }

    @Override
    public void setFoodName(String foodName) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("food", foodName);
        setResult(RESULT_OK, intent);
        finish();
    }
}