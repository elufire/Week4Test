package com.example.week4test.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4test.R;
import com.example.week4test.activities.Main2Activity;
import com.example.week4test.flickr.Photo;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Photo> PhotosArrayList;
    Photo TAG;

    public RecyclerViewAdapter(ArrayList<Photo> PhotosArrayList) {
        this.PhotosArrayList = PhotosArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Photo photo = PhotosArrayList.get(position);

        if (photo != null) {
            String title = photo.getTitle();
            String owner = photo.getOwner();
            viewHolder.tvTitle.setText(title);
            viewHolder.tvOwner.setText(owner);
            viewHolder.setPhoto(photo);
            Glide.with(viewHolder.itemView.getContext()).load("https://farm" + photo.getFarm()
                    + ".staticflickr.com/" + photo.getServer() + "/" + photo.getId() +
                    "_" + photo.getSecret() + ".jpg").into(viewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return PhotosArrayList != null ? PhotosArrayList.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvOwner;
        TextView tvTitle;
        Photo photo;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
            tvOwner = itemView.findViewById(R.id.tvOwner);
            tvTitle = itemView.findViewById(R.id.tvTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), Main2Activity.class);
                    intent.putExtra("photo_id", photo);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void setPhoto(Photo photo){ this.photo = photo;}

    }

    public void addPhoto(Photo photo){
        //System.out.println(name);
        PhotosArrayList.add(photo);
        notifyDataSetChanged();
    }
}