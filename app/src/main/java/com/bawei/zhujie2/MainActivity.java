package com.bawei.zhujie2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://169.254.247.113:8080/WebSample/action/book_detail?id=1";
    private TextView mTvTitle;
    private TextView mTvDtCreated;
    private TextView mTvDescription;




    // 观察者
    Observer<Qbean> mObserver = new Observer<Qbean>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "请求HTTP失败！", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNext(Qbean qbean) {
            mTvTitle.setText(qbean.getData().getTitle());
            mTvDtCreated.setText(qbean.getData().getDtCreated());
            mTvDescription.setText(qbean.getData().getDescription());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvDtCreated = (TextView) findViewById(R.id.tv_dt_created);
        mTvDescription = (TextView) findViewById(R.id.tv_description);


        Observable.OnSubscribe<Qbean> observable = new Observable.OnSubscribe<Qbean>() {
            @Override
            public void call(final Subscriber<? super Qbean> subscriber) {
                Request req = new Request.Builder().url("http://169.254.247.113:8080/WebSample/action/book_detail?id=5").build();
                OkHttpClient client = new OkHttpClient();
                Call call = client.newCall(req);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String data = response.body().string();
                        Qbean entity = new Gson().fromJson(data, Qbean.class);
                        subscriber.onNext(entity);
                    }
                });
            }
        };

        Observable.create(observable).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(mObserver);

    }




    }

