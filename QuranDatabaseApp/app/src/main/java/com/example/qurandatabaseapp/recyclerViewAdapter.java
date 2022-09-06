package com.example.qurandatabaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.viewHolder> {

    ArrayList<surahListModel_V2> displayData_V2;
    private onNoteListener mOnNoteListener;
    public recyclerViewAdapter(ArrayList<surahListModel_V2> display,onNoteListener OnNoteListener){
        this.displayData_V2=display;
        this.mOnNoteListener=OnNoteListener;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_surah, parent, false);
        return new viewHolder(itemView,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.data=displayData_V2.get(position);
        holder.tv1.setText(String.valueOf((holder.data.getSurahNO())));
        holder.tv2.setText(holder.data.getSurahNameEnglish());
        holder.tv3.setText(holder.data.getSurahNameUrdu());

    }

    @Override
    public int getItemCount() {
        return displayData_V2.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        surahListModel_V2 data;
        onNoteListener OnNoteListener;

        public viewHolder(@NonNull View itemView,onNoteListener OnNoteListener) {
            super(itemView);
            tv1=itemView.findViewById(R.id.textView1);
            tv2=itemView.findViewById(R.id.textView2);
            tv3=itemView.findViewById(R.id.textView13);
            this.OnNoteListener=OnNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            OnNoteListener.onNoteClick(getAdapterPosition(),view);
        }
    }
    public interface onNoteListener
    {
        void onNoteClick(int position,View view);


    }
}
