package com.example.gail;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.gail.Adapter.GailAdapter;
import com.example.gail.Class.GailInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GailAdapter gailAdapter;
    List<GailInfo> gailInfoList;
    SearchView searchView;
    DatabaseReference dbRef;
    BottomNavigationView bottomNavigationView;
    int a = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.mainRvId);
        searchView = findViewById(R.id.search_view_Id);
        bottomNavigationView = findViewById(R.id.bottomNavId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        gailInfoList = new ArrayList<>();

        dbRef = FirebaseDatabase.getInstance().getReference();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.moujaBottomId){
                    a = 1;
                }
                if (menuItem.getItemId() == R.id.rsBottomId){
                    a = 2;
                }
                if (menuItem.getItemId() == R.id.saBottomId){
                    a = 3;
                }
                return true;
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        if (dbRef != null){
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        gailInfoList.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                            GailInfo gailInfo = snapshot.getValue(GailInfo.class);
                            gailInfoList.add(gailInfo);
                        }
                        gailAdapter = new GailAdapter(MainActivity.this,gailInfoList);
                        recyclerView.setAdapter(gailAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }


    }

    private void search(String str) {
        ArrayList<GailInfo> myList = new ArrayList<>();
        for (GailInfo obj : gailInfoList){
            if (obj.getMouja().toLowerCase().contains(str.toLowerCase()) && a== 1){
                myList.add(obj);
            }

            if (obj.getRs().toLowerCase().contains(str.toLowerCase()) && a == 2 ){
                myList.add(obj);
            }
            if (obj.getSa().toLowerCase().contains(str.toLowerCase()) && a == 3){
                myList.add(obj);
            }
        }
        GailAdapter adapter = new GailAdapter(MainActivity.this,myList);
        recyclerView.setAdapter(adapter);
    }
}
