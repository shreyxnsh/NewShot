package com.shreyxnsh.newsapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shreyxnsh.newsapi.Modals.CategoryModal;
import com.shreyxnsh.newsapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    // variables
    private ArrayList<CategoryModal> categoryModal;
    private Context context;
    private CategoryClickInterface categoryClickInterface;

    // constructor


    public CategoryAdapter(ArrayList<CategoryModal> categoryModal, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoryModal = categoryModal;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creating a view to inflate the layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        // getting the data
        CategoryModal categoryModals = categoryModal.get(position);
        // setting the data
        holder.categoryName.setText(categoryModals.getCategory());
        // using picasso library to fetch image
        Picasso.get().load(categoryModals.getCategoryImageUrl()).into(holder.categoryImage);

        // on category clicked
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClickInterface.onCategoryClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryModal.size();
    }

    public interface CategoryClickInterface{
        void onCategoryClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // variable for category card view
        private TextView categoryName;
        private ImageView categoryImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialising variable
            categoryName = itemView.findViewById(R.id.categoryTitle);
            categoryImage = itemView.findViewById(R.id.categoryImage);

        }
    }
}
