package com.example.multimedia.adoptadog;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.multimedia.adoptadog.Fragments.FragmentContact;
import com.example.multimedia.adoptadog.Fragments.FragmentDogs;
import com.example.multimedia.adoptadog.Fragments.FragmentFollowUs;
import com.example.multimedia.adoptadog.Fragments.FragmentHome;
import com.example.multimedia.adoptadog.Fragments.FragmentMaps;

public class ActivityPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentContact.OnFragmentInteractionListener,
        FragmentDogs.OnFragmentInteractionListener, FragmentFollowUs.OnFragmentInteractionListener, FragmentHome.OnFragmentInteractionListener,
        FragmentMaps.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Ejecutamos el FragmentHome
        Fragment objFragment = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, objFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Creo una instancia null de Fragment
        Fragment fragment = null;
        boolean selectFragment = false;

        if (id == R.id.nav_home){
            fragment = new FragmentHome();
            selectFragment = true;
        }else if (id == R.id.nav_dogs){
            fragment = new FragmentDogs();
            selectFragment = true;
        }else if (id == R.id.nav_follow_us){
            fragment = new FragmentFollowUs();
            selectFragment = true;
        }else if (id == R.id.nav_maps){
            fragment = new FragmentMaps();
            selectFragment = true;
        }else if (id == R.id.nav_contact){
            fragment = new FragmentContact();
            selectFragment = true;
        }

        if (selectFragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
