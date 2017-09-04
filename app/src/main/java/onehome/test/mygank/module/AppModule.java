package onehome.test.mygank.module;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import onehome.test.mygank.base.BaseMvpActivity;
import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.presenter.SplashPresenter;

/**
 * Created by Administrator on 2017/9/4.
 */


@Module
public class AppModule {
    BaseMvpActivity baseMvpActivity;

    public AppModule(BaseMvpActivity baseMvpActivity) {
        this.baseMvpActivity = baseMvpActivity;
    }

    @Provides
    BaseMvpActivity providesSplashPresenter() {
        return baseMvpActivity;
    }

    ;
}
