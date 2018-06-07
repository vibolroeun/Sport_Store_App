package com.vibolroeun.android_project;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.vibolroeun.android_project.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView nvDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layoutID);
        nvDrawer = findViewById(R.id.navigation_viewID);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        defaultFragment();
        setupDrawerContent(nvDrawer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_setting, menu);

        MenuItem actionItemSearch = menu.findItem(R.id.action_searchID);
        SearchView searchView = (SearchView) actionItemSearch.getActionView();



        return true;
    }

    public void defaultFragment(){
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentID, new Home());
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        if(id == R.id.action_searchID){

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer(MenuItem item){
        android.support.v4.app.Fragment myFragment = null;
        Class fragmentClass;

        switch (item.getItemId()){

            case R.id.nav_homeID:
                fragmentClass = Home.class;
                break;

            case R.id.nav_cartID:
                fragmentClass = Cart.class;
                break;

            case R.id.nav_favoriteID:
                fragmentClass = Favorite.class;
                break;

            case R.id.nav_historyID:
                fragmentClass = History.class;
                break;

                default:
                    fragmentClass = Home.class; break;

        }
        try {
            myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentID, myFragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();

    }

    private void setupDrawerContent(NavigationView navigationView){

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }



}
