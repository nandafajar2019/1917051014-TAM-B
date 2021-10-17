package com.example.myexplorelampung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WisataAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Wisata> wisata = new ArrayList<>();

    //setter hasil generate

    public void setWisata(ArrayList<Wisata> wisata) {
        this.wisata = wisata;
    }

    //constructor hasil generate

    public WisataAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return wisata.size();
    }

    @Override
    public Object getItem(int i) {
        return wisata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_wisata, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Wisata wisata = (Wisata) getItem(i);
        viewHolder.bind(wisata);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Wisata wisata) {
            txtName.setText(wisata.getName());
            txtDescription.setText(wisata.getDescription());
            imgPhoto.setImageResource(wisata.getPhoto());
        }
    }
}
