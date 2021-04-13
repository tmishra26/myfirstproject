package com.example.practicaltask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PostActivity extends AppCompatActivity {
  //  private ExpandableListView expandablelistview;
    private ListView listView;
    private static final String TAG = "PostActivity";
    List<Response> responseList=new ArrayList<>();
    Address address;
    Geo geo;
    Company company;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        listView = (ListView) findViewById(R.id.listview);
      ApiManager manager = ApiClient.getPostClient().create(ApiManager.class);
      Call<List<Response>> call = manager.getUsersList();
      call.enqueue(new Callback<List<Response>>() {
          @Override
          public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
              if(response.isSuccessful()){
                  responseList = response.body();
                  for(int i =0; i < responseList.size(); i++){
                       address = response.body().get(i).getAddress();
                       company = response.body().get(i).getCompany();
                       geo = address.getGeo();

                  }

                  Log.d(TAG, "onResponse: "+responseList.size());


                  customAdapter = new CustomAdapter(PostActivity.this,responseList,address,company
                  ,geo);
                  listView.setAdapter(customAdapter);
              }

          }

          @Override
          public void onFailure(Call<List<Response>> call, Throwable t) {
              Log.d(TAG, "onResponse: "+t.getMessage());

          }
      });
    }
}