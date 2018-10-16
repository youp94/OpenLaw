package com.save.test.openlaw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main2Activity extends AppCompatActivity {

    DrawerLayout dl;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        dl = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        nv = findViewById(R.id.nav_view);

        View header = nv.getHeaderView(0);
        TextView t = header.findViewById(R.id.header_title);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                dl.closeDrawers();
                item.setChecked(true);

                switch (item.getItemId()){
                    case R.id.home:
                        AccueilFragment homeFragment = new AccueilFragment();
                        //homeFragment.setArguments(b);
                        Toast.makeText(getApplicationContext(),"Accueil",Toast.LENGTH_LONG).show();
                        fm.beginTransaction().replace(R.id.content_frame, homeFragment).commit();
                        break;
                    case R.id.questions:
                        NouvelleQuestionFragment nouvelleQuestionFragment = new NouvelleQuestionFragment();
                        //homeFragment.setArguments(b);
                        Toast.makeText(getApplicationContext(),"Nouvelle question",Toast.LENGTH_LONG).show();
                        fm.beginTransaction().replace(R.id.content_frame, nouvelleQuestionFragment).commit();
                        break;
                    case R.id.map:
                        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        //homeFragment.setArguments(b);
                        Toast.makeText(getApplicationContext(),"Profile utilisateur",Toast.LENGTH_LONG).show();
                        fm.beginTransaction().replace(R.id.content_frame, profileFragment).commit();
                        break;
                    case R.id.about:
                        break;
                }

                return false;
            }
        });

        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Respond when the drawer's position changes
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Respond when the drawer is opened
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // Respond when the drawer is closed
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                // Respond when the drawer motion state changes
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
