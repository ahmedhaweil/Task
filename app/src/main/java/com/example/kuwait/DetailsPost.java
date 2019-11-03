package com.example.kuwait;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.kuwait.AllNews.Post;
import com.example.kuwait.AllNews.PostStorage;
import com.facebook.drawee.view.SimpleDraweeView;

public class DetailsPost extends AppCompatActivity {

    private PostStorage storage;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_post);
        storage = getIntent().getParcelableExtra("Poststorage");
        post = getIntent().getParcelableExtra("Post");
        SimpleDraweeView mImagenew = findViewById(R.id.imagenew);
        TextView mTitlearc = findViewById(R.id.titlearc);
        AppCompatTextView mTxtauthor = findViewById(R.id.txtauthor);
        View mView = findViewById(R.id.view);
        AppCompatTextView mTxtsite = findViewById(R.id.txtsite);
        TextView mDetailspost = findViewById(R.id.detailspost);
        if (storage != null) {
            if (storage.getMain_image()!=null) {
                mImagenew.setImageURI(Uri.parse(storage.getMain_image()));
            }  mTxtsite.setText(storage.getSite());
            mDetailspost.setText(storage.getDetails());
            mTxtauthor.setText(storage.getAuth());
            mTitlearc.setText(storage.getTitle());
        } else if (post != null) {
            if (post.getThread().getMainImage()!=null) {
                mImagenew.setImageURI(Uri.parse(post.getThread().getMainImage()));
            }            mTxtsite.setText(post.getThread().getSite());
            mDetailspost.setText(post.getText());
            mTxtauthor.setText(post.getAuthor());
            mTitlearc.setText(post.getThread().getTitle());
        }

    }
}
