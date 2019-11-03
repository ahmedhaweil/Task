package com.example.kuwait.AllNews;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuwait.DetailsPost;
import com.example.kuwait.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    String textsearch;
    private final Activity activity;
    private List<Post> posts;
    private ArrayList<PostStorage> list;


    public NewsAdapter(String textsearch, Activity activity, List<Post> posts) {
        this.textsearch = textsearch;
        this.activity = activity;
        this.posts = posts;
    }

    public NewsAdapter(Activity activity, ArrayList<PostStorage> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = activity.getLayoutInflater().inflate(R.layout.adpter_news, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        if (list != null) {
            final PostStorage storage = list.get(i);
            viewHolder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, DetailsPost.class);
                    intent.putExtra("Poststorage", storage);
                    activity.startActivity(intent);
                }
            });
            if (list.get(i).getMain_image() == null) {
                viewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);

            } else {
                viewHolder.imageView.setImageURI(Uri.parse(list.get(i).getMain_image()));
            }
            viewHolder.txttitle.setText(storage.getTitle());
            viewHolder.txtauth.setText(storage.getAuth());
            viewHolder.txtsite.setText(storage.getSite());
        } else {
            final Post post = posts.get(i);
            viewHolder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, DetailsPost.class);
                    intent.putExtra("Post", post);
                    activity.startActivity(intent);
                }
            });
            if (posts.get(i).getThread().getMainImage() == null) {
                viewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);

            } else {
                viewHolder.imageView.setImageURI(Uri.parse(posts.get(i).getThread().getMainImage()));
            }
            String criteria = textsearch;
            String fullText = post.getTitle();
            if (fullText.contains(criteria)) {
                int indexOfCriteria = fullText.indexOf(criteria);
                String highlighted = "<font color='red'>"+criteria+"</font>";
                fullText = fullText.replace(criteria, highlighted);

            }

            viewHolder.txttitle.setText(Html.fromHtml(fullText));
            viewHolder.txtauth.setText(post.getAuthor());
            viewHolder.txtsite.setText(post.getThread().getSite());
        }
    }

    @Override
    public int getItemCount() {
        int count = 30;
        if (posts != null) {
            count = posts.size();
        } else if (list != null) {
            count = list.size();
        }
        return count;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final SimpleDraweeView imageView;
        final AppCompatTextView txttitle;
        final AppCompatTextView txtauth;
        final AppCompatTextView txtsite;
        final RelativeLayout item;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            imageView = itemView.findViewById(R.id.imgnews);
            txtauth = itemView.findViewById(R.id.txtauthor);
            txtsite = itemView.findViewById(R.id.txtsite);
            txttitle = itemView.findViewById(R.id.txttitle);
        }
    }
}
