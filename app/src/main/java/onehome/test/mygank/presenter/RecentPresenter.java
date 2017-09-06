package onehome.test.mygank.presenter;

import javax.inject.Inject;

import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.fragment.RecentFragment;
import onehome.test.mygank.mode.impl.CommonImpl;

/**
 * Created by Administrator on 2017/9/6.
 */

public class RecentPresenter extends BaseMvpPresenter<BaseView> {
    CommonImpl common;

    @Inject
    public RecentPresenter(CommonImpl common) {
        this.common = common;
    }
    public void loadData(){

    }
}
