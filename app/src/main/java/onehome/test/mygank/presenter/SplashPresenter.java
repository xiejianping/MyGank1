package onehome.test.mygank.presenter;

import javax.inject.Inject;

import onehome.test.mygank.activity.SplashActivity;
import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.base.BaseView;

/**
 * Created by Administrator on 2017/9/4.
 */

public class SplashPresenter extends BaseMvpPresenter<BaseView> {
    @Inject
    SplashActivity splashActivity;
}
