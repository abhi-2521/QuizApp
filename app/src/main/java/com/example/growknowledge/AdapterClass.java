package com.example.growknowledge;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.viewHolder> {
    Context context;
    ArrayList<ContentClass> arrayList;
    private int last = -1;

    public AdapterClass(Context context, ArrayList<ContentClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designlayout, parent, false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).img);
        holder.textView.setText(arrayList.get(position).title);
        setanimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.Title);
            imageView = itemView.findViewById(R.id.Introimage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    switch (position)
                    {
                        case 0:
                            Intent intent=new Intent(context,History.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            Intent intent1=new Intent(context,Geography.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2=new Intent(context,Science.class);
                            context.startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3=new Intent(context,Literature.class);
                            context.startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4=new Intent(context,Health.class);
                            context.startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5=new Intent(context,Sports.class);
                            context.startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6=new Intent(context,India.class);
                            context.startActivity(intent6);
                            break;
                        case 7:
                            Intent intent7=new Intent(context,World.class);
                            context.startActivity(intent7);
                            break;

                    }
                }
            });
        }
    }

    private void setanimation(View viewHolder, int position) {
        if (position > last) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewHolder.startAnimation(animation);
            last = position;
        }
    }
}
