package onehome.test.mygank.presenter;

import javax.inject.Inject;

import onehome.test.mygank.api.CommonApi;
import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.mode.impl.CommonImpl;
import onehome.test.mygank.view.MainView;

/**
 * Created by Administrator on 2017/9/6.
 */

public class MainPresenter extends BaseMvpPresenter<MainView> {
    CommonImpl common;

    @Inject
    public MainPresenter(CommonImpl common) {
        this.common = common;
    }
}
