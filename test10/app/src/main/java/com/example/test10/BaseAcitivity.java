package com.example.test10;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseAcitivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public Activity getthis(){
        return this;
    }
    public void maketoast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home==item.getItemId()) finish();
        return super.onOptionsItemSelected(item);
    }
}
