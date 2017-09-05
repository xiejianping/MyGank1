package onehome.test.mygank.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import onehome.test.mygank.global.GankGlobal;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/9/5.
 */
@Module
public class ClientModule {
//    private String url;
//    private Interceptor[] interceptors;

//    public ClientModule(Builder builder) {
//        this.url = builder.url;
//        this.interceptors = builder.interceptors;
//    }

    public ClientModule() {
    }

//    public static Builder builder() {
//        return new Builder();
//    }


    @Singleton
    @Provides
    Retrofit ProvidesRetrofit(OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder();
        return componentRetrofit(builder, client);
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient() {
        return componentOkHttpClient();
    }

    private Retrofit componentRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        Retrofit retrofit = builder
                .client(client)
                .baseUrl(GankGlobal.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient componentOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(GankGlobal.connectOut, TimeUnit.SECONDS)
                .readTimeout(GankGlobal.readOut, TimeUnit.SECONDS)
                .build();
    }

//    public static class Builder {
//        Builder() {
//        }
//
//        private String url;
//        private Interceptor[] interceptors;
//
//        Builder url(String url) {
//            this.url = url;
//            return this;
//        }
//
//        Builder interceptors(Interceptor[] interceptors) {
//            this.interceptors = interceptors;
//            return this;
//        }
//
//        ClientModule builder() {
//            if (this.url == null) {
//                new IllegalArgumentException(" URL 不能为空");
//            }
//            return new ClientModule(this);
//        }
//    }
}
