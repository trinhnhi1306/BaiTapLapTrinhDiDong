package com.phuphuc.bai10datdoan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ThucAnAdapter extends ArrayAdapter<ThucAn> {

    private Context context;
    private int resource;
    private List<ThucAn> thucAnList;

    public ThucAnAdapter(@NonNull Context context, int resource, @NonNull List<ThucAn> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.thucAnList = objects;
    }

    @Override
    public int getCount() {
        return thucAnList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivImage = convertView.findViewById(R.id.ivImage);
        TextView tvName = convertView.findViewById(R.id.tvName);
        ThucAn thucAn = thucAnList.get(position);
        tvName.setText(thucAn.getName());
        ivImage.setImageResource(thucAn.getImage());
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thucAn.getType() == 0) {
                    IFoodItemClickListener iFoodItemClickListener = (IFoodItemClickListener) context;
                    iFoodItemClickListener.setFoodName(thucAn.getName());
                }
                else {
                    IDrinkItemClickListener iDrinkItemClickListener = (IDrinkItemClickListener) context;
                    iDrinkItemClickListener.setDrinkName(thucAn.getName());
                }
            }
        });
        return convertView;
    }
}
