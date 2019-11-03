package com.example.kuwait.AllNews;

public interface NewsContainer {
    interface NewsPresenter{
        void GetData(String q);

    }
    interface NewsView{
        void ReadData(NewsModel newsModel,String q);
        void ErrorData();
        void ReadFromDataBase();
    }
}
