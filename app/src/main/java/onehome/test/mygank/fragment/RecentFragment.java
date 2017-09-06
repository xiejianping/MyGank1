package onehome.test.mygank.fragment;

import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseMvpFragment;
import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.component.DaggerActivityComponent;
import onehome.test.mygank.component.DaggerAppComponent;
import onehome.test.mygank.presenter.RecentPresenter;

/**
 * Created by Administrator on 2017/9/6.
 */

public class RecentFragment extends BaseMvpFragment<RecentPresenter> {
    @Override
    protected void injectComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int rootViewID() {
        return R.layout.fragment_recent;
    }
}
