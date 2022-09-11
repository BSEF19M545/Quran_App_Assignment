package com.example.qurandatabaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapterView2 extends RecyclerView.Adapter<recyclerViewAdapterView2.viewHolder> {

    ArrayList<QuranDisplayModelData_V2> displayData_V2;
    public recyclerViewAdapterView2(ArrayList<QuranDisplayModelData_V2> display){
        this.displayData_V2=display;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_para, parent, false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.data=displayData_V2.get(position);
        holder.tv1.setText(String.valueOf((holder.data.getArabic())));
        holder.tv2.setText(holder.data.getTranslationEnglish());
        holder.tv3.setText(holder.data.getTranslationUrdu());

    }

    @Override
    public int getItemCount() {
        return displayData_V2.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        QuranDisplayModelData_V2 data;
        public viewHolder(@NonNull View itemView)
        {
            super(itemView);
            tv1=itemView.findViewById(R.id.textView4);
            tv2=itemView.findViewById(R.id.textView5);
            tv3=itemView.findViewById(R.id.textView11);

        }
    }

}
