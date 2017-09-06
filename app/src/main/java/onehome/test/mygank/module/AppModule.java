package onehome.test.mygank.module;

import dagger.Module;
import dagger.Provides;
import onehome.test.mygank.api.CommonApi;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/9/4.
 */


@Module
public class AppModule {
    @Provides
    CommonApi ProvidesCommonApi(Retrofit retrofit) {
        return retrofit.create(CommonApi.class);
    }
}
