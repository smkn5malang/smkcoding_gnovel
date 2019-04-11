package com.fikri.gnoovel;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    ModelAdapter adapter;

    List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        modelList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adding some items to our list
        modelList.add(
                new Model(
                        1,
                        "Dilan 1990",
                        "Milea  bertemu dengan Dilan di sebuah SMA di Bandung. Itu adalah tahun 1990, saat Milea pindah dari Jakarta ke Bandung. Perkenalan yang tidak biasa kemudian membawa Milea mulai mengenal keunikan Dilan lebih jauh. Dilan yang pintar, baik hati dan romantis... semua dengan caranya sendiri.",
                        8.1,
                        R.drawable.dilanimg));

        modelList.add(
                new Model(
                        1,
                        "Exo Salah Gaul",
                        "Siapa bilang boyband Korea cuman modal tampang doang? Kalo emang mereka cuman modal tampang doang kenapa EXO punya visual yang Temsek alias item pesek. Leader-nya miskin tinggi badan, leader yang satunya lagi badannya tinggi sih tapi giginya maju ke depan, dan main vokalnya juga cabe-cabean. ",
                        8.0,
                        R.drawable.exoimg));

        modelList.add(
                new Model(
                        1,
                        "Laskar Pelangi",
                        "Cerita dari sebuah daerah di Belitung, yakni di SD Muhammadiyah. Saat itu menjadi saat yang menegangkan bagi anak-anak yang ingin bersekolah di SD Muhammadiyah. Kesembilan murid yakni, Ikal, Lintang, Sahara, A Kiong, Syahdan, Kucai, Borek, Trapani tengah gelisah lantaran SD Muhammadiyah akan ditutup jika murid yang bersekolah tidak genap menjadi 10.",
                        8.1,
                        R.drawable.laskarimg));

        modelList.add(
                new Model(
                        1,
                        "Harry Poter",
                        "Diselamatkan dari bibi & paman yang terlalu mengabaikannya, seorang bocah dengan garis takdir besar membuktikan kemampuannya saat ia mulai memasuki Sekolah Sihir Hogwarts.",
                        9.0,
                        R.drawable.harryimg));

        adapter = new ModelAdapter(this, modelList);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
