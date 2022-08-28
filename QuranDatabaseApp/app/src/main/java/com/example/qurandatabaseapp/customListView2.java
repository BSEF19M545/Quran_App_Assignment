package com.example.qurandatabaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class customListView2 extends ArrayAdapter<QuranDisplayModelData> {
    public customListView2(@NonNull Context context, ArrayList<QuranDisplayModelData> model) {
        super(context, 0, model);

    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        QuranDisplayModelData model = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_view_para, parent, false);

        TextView tv1= convertView.findViewById(R.id.textView4);
        TextView tv2= convertView.findViewById(R.id.textView5);

        tv1.setText(String.valueOf(model.getArabic()));
//        tv2.setText(model.getSurahNameArabic());
        tv2.setText(model.getTranslation());

        return convertView;
    }
}
