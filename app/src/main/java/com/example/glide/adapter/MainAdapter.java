package com.example.glide.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.glide.Contact;
import com.example.glide.R;
import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {


    private ArrayList<Contact> data;
    public Activity Context;


    public MainAdapter(ArrayList<Contact> data, Activity context) {
        this.data = data;
        this.Context=context;
    }

    class MainHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;


        public MainHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.contactimage);

        }
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        return new MainHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i ) {
        mainHolder.name.setText(data.get(i).getName());
        Glide.with(Context)
               .load(data.get(i).getUrl())
               .transform(new CircleCrop())
               .into(mainHolder.image);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
}
