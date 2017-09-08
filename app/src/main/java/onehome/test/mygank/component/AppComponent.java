package onehome.test.mygank.component;

import javax.inject.Singleton;

import dagger.Component;
import onehome.test.mygank.activity.MainActivity;
import onehome.test.mygank.activity.SplashActivity;
import onehome.test.mygank.api.CommonApi;
import onehome.test.mygank.fragment.AllDataFragment;
import onehome.test.mygank.fragment.AndroidFragment;
import onehome.test.mygank.fragment.IOSFragment;
import onehome.test.mygank.fragment.MainFragment;
import onehome.test.mygank.fragment.RecentFragment;
import onehome.test.mygank.fragment.WebFragment;
import onehome.test.mygank.fragment.WelfareFragment;
import onehome.test.mygank.module.AppModule;
import onehome.test.mygank.module.ClientModule;

/**
 * Created by Administrator on 2017/9/4.
 */

@Singleton
@Component(modules = {ClientModule.class, AppModule.class})
public interface AppComponent {
    CommonApi providesCommonApi();

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

    void inject(RecentFragment recentFragment);

    void inject(AllDataFragment allDataFragment);

    void inject(MainFragment mainFragment);

    void inject(AndroidFragment androidFragment);

    void inject(IOSFragment iosFragment);

    void inject(WebFragment webFragment);

    void inject(WelfareFragment welfareFragment);
}
