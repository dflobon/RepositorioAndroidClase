package com.example.planetas.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.planetas.R;

import java.util.ArrayList;
import java.util.List;

public class PlanetAdapter extends BaseAdapter {
    List<Planeta> planetas = new ArrayList<>();
    @Override
    public int getCount() {
        return planetas.size();
    }

    @Override
    public Object getItem(int i) {
        return planetas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) view = inflater.inflate(R.layout.planetrow,null);

        TextView text_name = view.findViewById(R.id.text_name);
        text_name.setText(planetas.get(i).getName());
        TextView text_size = view.findViewById(R.id.txt_size);
        text_size.setText(planetas.get(i).getDiameter());
        ImageView imageView = view.findViewById(R.id.img_1);
        imageView.setImageBitmap(planetas.get(i).getFoto());
        return null;
    }
    public void addPlanets(List<Planeta> planetas) {
        this.planetas = planetas;
        super.notifyDataSetChanged();
    }
    public void clearPlanets(){
        this.planetas.clear();
        super.notifyDataSetChanged();
    }
}
