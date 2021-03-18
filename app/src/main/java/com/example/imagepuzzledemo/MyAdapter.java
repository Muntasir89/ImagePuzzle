package com.example.imagepuzzledemo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    Intent i;
    int[] img_actor;
    ChooseImage choose_img;
    int ImgHeight;
    public MyAdapter(ChooseImage choose_img, int[] img_actor,int ImgHeight) {
        this.img_actor = img_actor;
        this.choose_img = choose_img;
        this.ImgHeight = ImgHeight;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_image, parent, false);
        MyViewHolder VH = new MyViewHolder(v);
        return VH;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(img_actor[position]);
        holder.imageView.getLayoutParams().height = ImgHeight;
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                i = new Intent(choose_img, Puzzle.class);
                i.putExtra("IMG_NO", position);
                i.putExtra("LEVEL", 1);
                choose_img.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return img_actor.length;
    }
}
