package com.shreyxnsh.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.shreyxnsh.newsapi.Adapters.CategoryAdapter;
import com.shreyxnsh.newsapi.Adapters.NewsAdapter;
import com.shreyxnsh.newsapi.Modals.Articles;
import com.shreyxnsh.newsapi.Modals.CategoryModal;
import com.shreyxnsh.newsapi.Modals.NewsModal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickInterface{

    // 62a221324a2141cfb2134e484eb32a03

    // variables
    private RecyclerView newsRV, categoryRV;
    private ProgressBar progressBar;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoryModal> categoryModalArrayList;
    private CategoryAdapter categoryAdapter;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialising variable
        newsRV = findViewById(R.id.newsRV);
        categoryRV = findViewById(R.id.categoryRV);
        progressBar = findViewById(R.id.progressBar);
        articlesArrayList = new ArrayList<>();
        categoryModalArrayList = new ArrayList<>();

        // setting the adapters into the array list
        newsAdapter = new NewsAdapter(articlesArrayList, this);
        categoryAdapter = new CategoryAdapter(categoryModalArrayList , this, this::onCategoryClick);

        //setting layout manager
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(newsAdapter);
        categoryRV.setAdapter(categoryAdapter );

        getCategories();
        getNews("All");
        newsAdapter.notifyDataSetChanged();
    }

    private void getCategories(){
        // hard coding the news categories :

        // created string resources of image urls for better code readability
        categoryModalArrayList.add(new CategoryModal("All",getString(R.string.newsurl)));
        categoryModalArrayList.add(new CategoryModal("Technology",getString(R.string.technologyurl)));
        categoryModalArrayList.add(new CategoryModal("Science",getString(R.string.scienceurl)));
        categoryModalArrayList.add(new CategoryModal("Sports",getString(R.string.sportsurl)));
        categoryModalArrayList.add(new CategoryModal("General",getString(R.string.generalnewsurl)));
        categoryModalArrayList.add(new CategoryModal("Business",getString(R.string.businessurl)));
        categoryModalArrayList.add(new CategoryModal("Entertainment",getString(R.string.enturl)));
        categoryModalArrayList.add(new CategoryModal("Health ",getString(R.string.healthurl)));

        // notify the adapter the data has been changed
        categoryAdapter.notifyDataSetChanged();
    }

    private void getNews(String category){
        progressBar.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String categoryURL = "https://newsapi.org/v2/top-headlines?country=in&category="+ category +"&apiKey=62a221324a2141cfb2134e484eb32a03";
        String allnewsURL = "https://newsapi.org/v2/top-headlines?country=in&apiKey=62a221324a2141cfb2134e484eb32a03";
        String BASE_URL = "https://newsapi.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // convert data into json form
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<NewsModal> call;
        // check if category is all
        if (category.equals("All")){
            call = retrofitApi.getAllNews(allnewsURL);
        }else {
            call = retrofitApi.getNewsByCategory(categoryURL);
        }

        call.enqueue(new Callback<NewsModal>() {
            @Override
            public void onResponse(Call<NewsModal> call, Response<NewsModal> response) {
                // successful response
                NewsModal newsModal = response.body();
                progressBar.setVisibility(View.GONE);
                // method to get all articles from news modal
                ArrayList<Articles> articles = newsModal.getArticles();
                for (int i =0; i<articles.size();i++){
                    articlesArrayList.add(new Articles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),articles.get(i).getUrl(),articles.get(i).getContent()));
                }
                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModal> call, Throwable t) {
                // error from api
                Toast.makeText(MainActivity.this, "Failed to fetch news!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onCategoryClick(int position) {
        String category = categoryModalArrayList.get(position).getCategory();
        getNews(category);
    }
}