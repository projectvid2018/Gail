package com.example.gail;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    CardView search, add, edit, delete, view, exit;

    public void search(android.view.View view) {
        Intent intent = new Intent(Dashboard.this,MainActivity.class);
        startActivity(intent);
    }

    public void add(android.view.View view) {
        Intent intent = new Intent(Dashboard.this,Add.class);
        startActivity(intent);
    }

    public void edit(android.view.View view) {
        Intent intent = new Intent(Dashboard.this,Edit.class);
        startActivity(intent);
    }

    public void delete(android.view.View view) {
        Intent intent = new Intent(Dashboard.this,Delete.class);
        startActivity(intent);
    }
    public void view(android.view.View view) {
        Intent intent = new Intent(Dashboard.this, com.example.gail.View.class);
        startActivity(intent);
    }

    public void exit(android.view.View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Dashboard.this);
        builder.setMessage("Do you want to log out?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

                finish();
                Intent i=new Intent(Dashboard.this,Login.class);
                i.putExtra("finish", true);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //--------------------------------------- To clean up all activities
                startActivity(i);
                finish();

            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert=builder.create();
        alert.show();
    }

}
