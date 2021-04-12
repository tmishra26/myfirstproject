package com.example.practicaltask;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button button_location;
    private TextView textView;
    private ConstraintLayout cl_layout;
    private RecyclerView recyclerview;
    //String uri = "geo:0,0?q=india";
    private FusedLocationProviderClient fusedLocationProviderClient;
    NamesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        button_location = (Button) findViewById(R.id.button_location);
        cl_layout = (ConstraintLayout) findViewById(R.id.cl_layout);

        ApiManager apiService =
                ApiClient.getClient().create(ApiManager.class);
        Call<ImName> call = apiService.getNames();

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (getApplicationContext().checkSelfPermission( Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                if(location != null){
                                    Double lang = location.getLongitude();
                                    Double alti = location.getAltitude();
                                    Log.d("Tarang", "onSuccess: "+lang);
                                    button_location.setVisibility(View.GONE);
                                    cl_layout.setBackgroundColor(getResources().getColor(R.color.white));
                                    textView.setText("Longitude ="+lang + "Altitute"+alti);
                                    call.enqueue(new Callback<ImName>() {
                                        @Override
                                        public void onResponse(Call<ImName> call, Response<ImName> response) {
                                            if(response.isSuccessful()){
                                                ImName imName = response.body();
                                                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                                                Log.d("Tara", "onResponse: "+imName);
                                                recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                                adapter = new NamesAdapter(MainActivity.this,imName);
                                                recyclerview.setAdapter(adapter);
                                                adapter.notifyDataSetChanged();
                                            }
                                        }
                                        @Override
                                        public void onFailure(Call<ImName> call, Throwable t) {
                                            Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;
                    }
                }else {

                }


             }

        });
    }


}