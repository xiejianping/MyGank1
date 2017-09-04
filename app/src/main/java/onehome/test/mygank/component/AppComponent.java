package onehome.test.mygank.component;

import dagger.Component;
import dagger.Module;
import onehome.test.mygank.activity.SplashActivity;
import onehome.test.mygank.module.AppModule;
import onehome.test.mygank.presenter.SplashPresenter;

/**
 * Created by Administrator on 2017/9/4.
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(SplashActivity splashActivity);
}
