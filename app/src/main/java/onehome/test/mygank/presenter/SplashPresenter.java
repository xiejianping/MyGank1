package onehome.test.mygank.presenter;

import javax.inject.Inject;

import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.mode.impl.CommonImpl;
import onehome.test.mygank.view.SplashView;

/**
 * Created by Administrator on 2017/9/4.
 */

public class SplashPresenter extends BaseMvpPresenter<SplashView> {
    CommonImpl splashimpl;

    @Inject
    public SplashPresenter(CommonImpl splashimpl) {
        this.splashimpl = splashimpl;
    }

    public void loadData() {
        splashimpl.getSplash().take(1).subscribe(e -> {
            getView().getSplashSuccess(e.get(0));
        });
    }
}
