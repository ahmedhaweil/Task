package com.example.kuwait.AllNews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuwait.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

public class News extends AppCompatActivity implements NewsContainer.NewsView {

    private RecyclerView rv_news;
    private EditText mEditsearch;
    private Realm realm = null;
    private NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        IntialUI();
        presenter.GetData("");

    }

    private void IntialUI() {
        presenter=new NewsPresenter(this, News.this);
        Realm.init(this);
        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .name("newsa")
                        .schemaVersion(2)
                        .deleteRealmIfMigrationNeeded()
                        .build();
        realm = Realm.getInstance(config);

        rv_news = findViewById(R.id.rv_news);
        rv_news.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mEditsearch = findViewById(R.id.editsearch);
        Button mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.GetData(mEditsearch.getText().toString());

            }
        });
    }

    private void Save(final RealmList<PostStorage>  model) {
        realm.beginTransaction();
        realm.insertOrUpdate(model);
        realm.commitTransaction();


    }


    @Override
    public void ReadData(NewsModel newsModel,String q) {
        rv_news.setAdapter(new NewsAdapter(q,News.this,newsModel.getPosts()));
        RealmList<PostStorage> list = new RealmList<>();
        for (int i = 0; i < newsModel.getPosts().size(); i++) {
            Post post = newsModel.getPosts().get(i);

            PostStorage storgeData = new PostStorage();
            storgeData.setTitle(post.getTitle());
            storgeData.setAuth(post.getAuthor());
            storgeData.setMain_image(post.getThread().getMainImage());
            storgeData.setDetails(post.getText());
            storgeData.setSite(post.getThread().getSite());
            storgeData.setUrl(post.getAuthor());
            list.add(storgeData);
        }
        Save(list);


    }

    @Override
    public void ErrorData() {

    }

    @Override
    public void ReadFromDataBase() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmResults<PostStorage> list=realm.where(PostStorage.class).findAll();
                ArrayList<PostStorage> storageList = new ArrayList<>(list);
                rv_news.setAdapter(new NewsAdapter(News.this,storageList));

            }
        });



    }
}
