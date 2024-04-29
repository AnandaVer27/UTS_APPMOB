package com.example.uts_appmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        // Membuat list item sebagai contoh
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Mbah Gojol Group", "This is Mbah Gojol Project", R.drawable.git01));
        itemList.add(new Item("BAGUS BUDI SATOTO", "I'm a student at Universitas Amikom Yogyakarta, Indonesia.", R.drawable.git02));
        itemList.add(new Item("siti", "Calculate Spatial Information / Temporal Information according to ITU-T P.910", R.drawable.git03));
        itemList.add(new Item("Code-used-on-Daniel-Lemire-s-blog", "This is a repository for the code posted on my blog", R.drawable.git04));
        itemList.add(new Item("Radar", "An audi-visual experiment", R.drawable.git05));
        itemList.add(new Item("ali", "Generate HTTP load and plot the results in real-time", R.drawable.git06));
        itemList.add(new Item("Bagaskara-Userbot2", "Deploy Your Own , New Version Of Bagaskara-Userbot.", R.drawable.git07));

        // Anda dapat menambahkan item lain sesuai kebutuhan

        // Membuat adapter dan mengatur RecyclerView dengan adapter tersebut
        MyAdapter adapter = new MyAdapter(getApplicationContext(), itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Menambahkan click listener untuk RecyclerView
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Mengambil data dari item yang diklik
                Item clickedItem = itemList.get(position);

                // Membuat Intent untuk membuka DetailActivity (ganti dengan nama Activity yang Anda buat)
                Intent intent = new Intent(MainActivity.this, HalamanWeb.class);
                intent.putExtra("name", clickedItem.getName());
                intent.putExtra("bio", clickedItem.getBio());
                intent.putExtra("image", clickedItem.getImage());

                // Memulai Activity baru
                startActivity(intent);
            }
        });
    }
}