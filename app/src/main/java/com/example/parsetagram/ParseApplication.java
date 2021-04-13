package com.example.parsetagram;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        ParseObject.registerSubclass(Post.class);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("0junomRm3fSTE4kcaC0SDwAkxkJng5ExfjZZ4E5l")
                .clientKey("4qw1ATCKaLVomBnz92sBMVMXH3jziHUaceJEkCF4")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}