package com.example.project11.ui.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home==item.getItemId()) finish();
        return super.onOptionsItemSelected(item);

    }
    public void maketoast(String s){
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
    public Activity getthis(){
        return this;
    }
}
