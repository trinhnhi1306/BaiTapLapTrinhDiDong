package com.phuphuc.bai10datdoan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThucUongActivity extends AppCompatActivity implements IDrinkItemClickListener {

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
        thucAnList.add(new ThucAn(R.drawable.cocacola, "Cô ca cô la", 1));
        thucAnList.add(new ThucAn(R.drawable.pepsi, "Pepsi", 1));
        thucAnList.add(new ThucAn(R.drawable.nuoc_loc, "Nước lọc", 1));
        thucAnList.add(new ThucAn(R.drawable.bia_heniken, "Bia Heniken", 1));
    }

    private void setControl() {
        getSupportActionBar().setTitle("Thức uống");
        lvThucAn = findViewById(R.id.lvThucAn);
    }

    @Override
    public void setDrinkName(String drinkName) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("drink", drinkName);
        setResult(RESULT_OK, intent);
        finish();
    }
}