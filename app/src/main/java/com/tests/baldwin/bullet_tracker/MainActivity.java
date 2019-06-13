package com.tests.baldwin.bullet_tracker;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.tests.baldwin.bullet_tracker.adapters.BulletAdapter;
import com.tests.baldwin.bullet_tracker.room_entities.AppDatabase;
import com.tests.baldwin.bullet_tracker.room_entities.Bullet;

import java.util.List;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    FloatingActionButton fabNewBullet;
    FloatingActionButton fabSearch;

    RecyclerView bulletRecyclerView;
    RecyclerView.Adapter bulletRecyclerViewAdapter;

    List<Bullet> bullets;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();
        bullets = db.bulletDao().getAllBullets();

        bulletRecyclerView = findViewById(R.id.bulletsRecyclerView);
        bulletRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //
        //
        //

        fabSearch = findViewById(R.id.fabSearch);

        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void updateRecyclerView(){
        Log.d(TAG, "updateRecyclerView: ");

        bulletRecyclerViewAdapter = new BulletAdapter(bullets);
    }
}
