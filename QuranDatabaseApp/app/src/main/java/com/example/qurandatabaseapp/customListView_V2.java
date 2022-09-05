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

public class customListView_V2 extends ArrayAdapter<surahListModel_V2> {
    TextView textView1,textView2,textView3;

    public customListView_V2(@NonNull Context context, ArrayList<surahListModel_V2> model) {
        super(context, 0, model);

    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        surahListModel_V2 model = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_view_surah, parent, false);


        TextView tv1= convertView.findViewById(R.id.textView1);
        TextView tv2= convertView.findViewById(R.id.textView2);
        TextView tv3= convertView.findViewById(R.id.textView13);

        tv1.setText(String.valueOf(model.getSurahNO()));
//        tv2.setText(model.getSurahNameArabic());
        tv2.setText(model.getSurahNameEnglish());
        tv3.setText(model.getSurahNameUrdu());

        return convertView;
    }
}