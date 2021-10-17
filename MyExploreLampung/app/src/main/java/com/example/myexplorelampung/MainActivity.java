package com.example.myexplorelampung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private WisataAdapter adapter;
    private String[] dataName = {"Menara Siger","Taman Gajah","Pantai Pahawang","TN Way Kambas",
            "Pantai Gigi Hiu", "Pulau Anak Krakatau"};
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Wisata> wisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new WisataAdapter(this);
        listView.setAdapter(adapter);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, dataName);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, wisata.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        wisata = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Wisata wisata = new Wisata();
            wisata.setPhoto(dataPhoto.getResourceId(i, -1));
            wisata.setName(dataName[i]);
            wisata.setDescription(dataDescription[i]);
            wisata.add(wisata);
        }
        adapter.setWisata(wisata);
    }
}
