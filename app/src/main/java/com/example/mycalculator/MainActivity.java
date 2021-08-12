package com.example.mycalculator;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.BuildConfig;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbarID);
        setSupportActionBar(toolbar);

        //dialog code

        dialog=new Dialog(this);

        //end dialog code

        //initial id

        drawerLayout=findViewById(R.id.mydrawerID);
        NavigationView navigationView=findViewById(R.id.mynavID);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_navigation_drawer,
                R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new standard()).commit();
            toolbar.setSubtitle("Standard ");
            navigationView.setCheckedItem(R.id.nav_standard);}
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_standard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new standard()).commit();
                toolbar.setSubtitle("Standard ");
                break;
            case R.id.nav_scientific:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new scientific()).commit();
                toolbar.setSubtitle("Scientific ");
                break;
            case R.id.nav_programmer:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new programmer()).commit();
                toolbar.setSubtitle("Programmer ");
                break;
            case R.id.nav_date:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new date_calculation()).commit();
                toolbar.setSubtitle("Date Calculation ");
                break;
            case R.id.nav_currency:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new currency()).commit();
                toolbar.setSubtitle("Currency ");
                break;
            case R.id.nav_length:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new length_class()).commit();
                toolbar.setSubtitle("Length ");
                break;
            case R.id.nav_temperature:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new temperature_class()).commit();
                toolbar.setSubtitle("Temperature ");
                break;
            case R.id.nav_time:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new time_class()).commit();
                toolbar.setSubtitle("Time ");
                break;
            case R.id.nav_data:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new data_class()).commit();
                toolbar.setSubtitle("Data ");
                break;
            case R.id.nav_share:
                try {
                    Intent it = new Intent(Intent.ACTION_SEND);
                    it.setType("text/plain");
                    it.putExtra(Intent.EXTRA_SUBJECT, "My Calculator");
                    String sharemessage = "https://play.google.com/store/apps/details?=" + BuildConfig.APPLICATION_ID + "\n\n";
                    it.putExtra(Intent.EXTRA_TEXT, sharemessage);
                    startActivity(Intent.createChooser(it, "share by"));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_feedback:
                try {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{"rhrifat940279@gmail.com"});
                it.putExtra(Intent.EXTRA_SUBJECT, "WINCAL Calculator Feedback");
                it.putExtra(Intent.EXTRA_TEXT, "Enter Your Feedback Here......");
                it.setType("message/rfc822");

                startActivity(it);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_contact:
                openFirstDialog();
                break;
            case R.id.nav_about:
                about_showclass dd3=new about_showclass();
                dd3.show(getSupportFragmentManager(),"about class");
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFirstDialog(){
        dialog.setContentView(R.layout.option_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewclose=dialog.findViewById(R.id.imageView_close_ob);
        ImageView buttonOk1=dialog.findViewById(R.id.button_ok_ob1);
        ImageView buttonOk2=dialog.findViewById(R.id.button_ok_ob2);
        ImageView buttonOk3=dialog.findViewById(R.id.button_ok_ob3);


        imageViewclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        buttonOk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlink("https://www.facebook.com/rh.rifat.33633");
                dialog.dismiss();
            }
        });
        buttonOk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlink("https://twitter.com/Rifatho25073502");

                dialog.dismiss();
            }
        });
        buttonOk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlink("https://www.instagram.com/rh_rifat220/?hl=en");

                dialog.dismiss();
            }
        });
        dialog.show();

    }
    public void openlink(String s){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(s));
        startActivity(intent);
    }
}