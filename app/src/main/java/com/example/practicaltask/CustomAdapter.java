package com.example.practicaltask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Response> {
    Context context;
    List<Response> responseList;
    public CustomAdapter(@NonNull Context context, @NonNull List<Response> responseList) {
        super(context, R.layout.listviewitems, responseList);
        this.context = context;
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = inflater.inflate(R.layout.listviewitems,null,true);
        Response response = responseList.get(position);
        TextView users = rowview.findViewById(R.id.users);
        TextView address = rowview.findViewById(R.id.address);
        TextView geo = rowview.findViewById(R.id.geo);
        TextView company = rowview.findViewById(R.id.company);
        TextView id = rowview.findViewById(R.id.id);
        TextView name = rowview.findViewById(R.id.name);
        TextView email = rowview.findViewById(R.id.email);
        TextView phone = rowview.findViewById(R.id.phone);
        TextView website = rowview.findViewById(R.id.website);
        TextView username = rowview.findViewById(R.id.username);
        users.setText("Users");
        address.setText("Address");
        geo.setText("Geo");
        company.setText("Company");
        id.setText(String.valueOf(response.getId()));
        name.setText(response.getName());
        email.setText(response.getEmail());
        phone.setText(response.getPhone());
        website.setText(response.getWebsite());
        username.setText(response.getUsername());
        return rowview;
    }
}
