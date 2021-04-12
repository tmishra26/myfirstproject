package com.example.practicaltask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {
    ImName imNameList;
    Context context;
    public NamesAdapter(Context context,ImName imNameList) {
        this.context = context;
        this.imNameList = imNameList;
    }

    @NonNull
    @Override
    public NamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nameslist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamesAdapter.ViewHolder holder, int position) {
        if(imNameList != null) {
            Log.d("Tara", "onBindViewHolder: " + imNameList.getLabel());
            holder.t1.setText(imNameList.getLabel());
            holder.t2.setText(imNameList.getLabel());
            holder.t3.setText(imNameList.getLabel());
            Toast.makeText(context, "not empty", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,t3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             t1 = itemView.findViewById(R.id.txt1);
            t2 = itemView.findViewById(R.id.txt2);
            t3 = itemView.findViewById(R.id.txt3);
        }
    }
}
