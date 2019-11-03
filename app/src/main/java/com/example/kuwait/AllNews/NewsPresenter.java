package com.example.kuwait.AllNews;

import android.app.Activity;

import com.example.kuwait.Util.APIClient;
import com.example.kuwait.Util.ApiInterface;
import com.example.kuwait.Util.ConnectionDetector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsPresenter implements NewsContainer.NewsPresenter {
   private final NewsContainer.NewsView view;
    private final ConnectionDetector detector;

    public NewsPresenter(NewsContainer.NewsView view, Activity activity) {
        this.view = view;
        detector = new ConnectionDetector(activity);
    }

    @Override
    public void GetData(final String q) {
        if(detector.isConnected()) {
            ApiInterface apiService =
                    APIClient.getClient().create(ApiInterface.class);
            Call<NewsModel> call = apiService.getDataFromSearch(q, "788d850d-7411-4de4-9fcc-784f0856bf36", "crawled", "1572475703743", "english");
            call.enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                    view.ReadData(response.body(),q);
                }
                @Override
                public void onFailure(Call<NewsModel> call, Throwable t) {
                    view.ErrorData();
                }
            });

        }else {
            view.ReadFromDataBase();

        }


    }
}
