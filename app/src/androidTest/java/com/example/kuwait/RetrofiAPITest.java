package com.example.kuwait;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.kuwait.AllNews.NewsModel;
import com.example.kuwait.Util.APIClient;
import com.example.kuwait.Util.ApiInterface;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("NullableProblems")
@RunWith(AndroidJUnit4.class)
public class RetrofiAPITest {
    private final CountDownLatch latch = new CountDownLatch(1);
    private ApiInterface apiService;
    private NewsModel newsModel;
    @Before
    public void beforeTest() {
        apiService= APIClient.getClient().create(ApiInterface.class);

    }

    @Test
    public void TestApi(){
        Call<NewsModel> call = apiService.getDataFromSearch("mohamed Salah", "788d850d-7411-4de4-9fcc-784f0856bf36", "crawled", "1572475703743", "english");
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
            newsModel=response.body();
                latch.countDown();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(newsModel);

    }

    @After
    public void afterTest() {
        newsModel = null;
    }
}
