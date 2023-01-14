package com.shreyxnsh.newsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    String title,desc,content,imageUrl,url;
    private TextView titleTV, subDescTV, contentTV;
    private ImageView newsImage;
    private Button readBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        // getting the values from NewsAdapter itself
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        imageUrl = getIntent().getStringExtra("imageurl");
        url = getIntent().getStringExtra("url");

        // initialising variables assigned to the views
        titleTV = findViewById(R.id.newstitle);
        subDescTV = findViewById(R.id.subdesc);
        contentTV = findViewById(R.id.newscontent);
        newsImage = findViewById(R.id.newsImg);
        readBtn = findViewById(R.id.readBtn);

        // setting the values
        titleTV.setText(title);
        subDescTV.setText(desc);
        contentTV.setText(content);
        Picasso.get().load(imageUrl).into(newsImage);

        // to view entire article
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });

    }
}