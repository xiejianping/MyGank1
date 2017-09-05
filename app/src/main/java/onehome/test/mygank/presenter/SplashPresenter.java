package onehome.test.mygank.presenter;

import javax.inject.Inject;

import onehome.test.mygank.activity.SplashActivity;
import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.data.impl.SplashImpl;
import onehome.test.mygank.data.impl.SplashView;

/**
 * Created by Administrator on 2017/9/4.
 */

public class SplashPresenter extends BaseMvpPresenter<SplashView> {
    SplashImpl splashimpl;

    @Inject
    public SplashPresenter(SplashImpl splashimpl) {
        this.splashimpl = splashimpl;
    }

    public void loadData() {
        splashimpl.getSplash().take(1).subscribe(e -> {
            getView().getSplashSuccess(e.get(0));
        });
    }
}
