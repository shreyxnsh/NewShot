package com.shreyxnsh.newsapi.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shreyxnsh.newsapi.Modals.Articles;
import com.shreyxnsh.newsapi.NewsDetailActivity;
import com.shreyxnsh.newsapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    //variables
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public NewsAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creating a view to inflate the recyclerview
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        // getting data
        Articles articles = articlesArrayList.get(position);
        // setting data
        holder.heading.setText(articles.getTitle());
        holder.subheading.setText(articles.getDescription());
        // using picasso to get the image
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsImage);

        // on clicking the news card, navigate to NewsDetailActivity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("title",articles.getTitle());
                intent.putExtra("content",articles.getContent());
                intent.putExtra("desc",articles.getDescription());
                intent.putExtra("imageurl",articles.getUrlToImage());
                intent.putExtra("url",articles.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // variable according to news card
        private TextView heading, subheading;
        private ImageView newsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialising variables
            heading = itemView.findViewById(R.id.newsHeading);
            subheading = itemView.findViewById(R.id.newssubHeading);
            newsImage = itemView.findViewById(R.id.newsImage);


        }
    }
}
