package onehome.test.mygank.presenter;

import javax.inject.Inject;

import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.mode.impl.CommonImpl;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/7.
 */

public class MainFragmentPresenter extends BaseMvpPresenter<InitView> {
    CommonImpl common;

    @Inject
    public MainFragmentPresenter(CommonImpl common) {
        this.common = common;
    }
}
