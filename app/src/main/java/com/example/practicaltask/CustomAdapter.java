package com.example.practicaltask;

import android.content.Context;
import android.graphics.Color;
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

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Response> {
    Context context;
    List<Response> responseList;
    Address address1;
    Company company1;
    Geo geo1;

    public CustomAdapter(@NonNull Context context, @NonNull List<Response> responseList,
                         Address address1,Company company1,Geo geo1) {
        super(context, R.layout.listviewitems, responseList);
        this.context = context;
        this.responseList = responseList;
        this.company1 = company1;
        this.address1 = address1;
        this.geo1 = geo1;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = inflater.inflate(R.layout.listviewitems,null,true);
        Response response = responseList.get(position);
        address1 = response.getAddress();
        company1 = response.getCompany();
        geo1 = address1.getGeo();
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
        TextView street = rowview.findViewById(R.id.street);
        TextView suite = rowview.findViewById(R.id.suite);
        TextView city = rowview.findViewById(R.id.city);
        TextView zipcode = rowview.findViewById(R.id.zipcod);
        TextView lat = rowview.findViewById(R.id.lat);
        TextView lng = rowview.findViewById(R.id.lng);
        TextView names = rowview.findViewById(R.id.namec);
        TextView catchPhase = rowview.findViewById(R.id.catchPharse);
        TextView bs = rowview.findViewById(R.id.bs);
        street.setText(address1.getStreet());
        suite.setText(address1.getSuite());
        city.setText(address1.getCity());
        zipcode.setText(address1.getZipcode());
        lat.setText(geo1.getLat());
        lng.setText(geo1.getLng());
        names.setText(company1.getName());
        catchPhase.setText(company1.getCatchPhrase());
        bs.setText(company1.getBs());
        users.setText("Users");
        users.setTextColor(Color.BLACK);
        address.setText("Address");
        address.setTextColor(Color.BLACK);
        geo.setText("Geo");
        geo.setTextColor(Color.BLACK);
        company.setText("Company");
        company.setTextColor(Color.BLACK);
        id.setText(String.valueOf(response.getId()));
        name.setText(response.getName());
        email.setText(response.getEmail());
        phone.setText(response.getPhone());
        website.setText(response.getWebsite());
        username.setText(response.getUsername());

        return rowview;
    }
}
