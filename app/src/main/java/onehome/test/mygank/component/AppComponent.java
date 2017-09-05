package onehome.test.mygank.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import onehome.test.mygank.activity.SplashActivity;
import onehome.test.mygank.data.api.CommonApi;
import onehome.test.mygank.module.AppModule;
import onehome.test.mygank.module.ClientModule;
import onehome.test.mygank.presenter.SplashPresenter;

/**
 * Created by Administrator on 2017/9/4.
 */

@Singleton
@Component(modules = { ClientModule.class,AppModule.class})
public interface AppComponent {
    CommonApi providesCommonApi();

    void inject(SplashActivity splashActivity);
}
