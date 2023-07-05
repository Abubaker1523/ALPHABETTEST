package com.example.drawernavigation_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
  DrawerLayout drawerLayout;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
      if(drawerLayout.isDrawerOpen(GravityCompat.START))
      {
          drawerLayout.closeDrawer(GravityCompat.START);
      }else {
          super.onBackPressed();
      }

    }

    NavigationView navigationView;
  Intent intent;
  ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
          drawerLayout.addDrawerListener(actionBarDrawerToggle);
          actionBarDrawerToggle.syncState();
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                  switch (item.getItemId())
                  {
                      case R.id.test:
                      {
                          Intent intent = new Intent(MainActivity.this, test.class);
                          startActivity(intent);
                          break;


                      }
                      case R.id.commits:
                      {
                          String url = "https://github.com/Abubaker1523/ALPHABETTEST.git";
                          Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                          websiteIntent.setData(Uri.parse(url));
                          startActivity(websiteIntent);
                          break;
                      }
                  }
                  return false;
              }
          });

    }
}