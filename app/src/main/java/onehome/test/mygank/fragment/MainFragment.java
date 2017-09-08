package onehome.test.mygank.fragment;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import onehome.test.mygank.R;
import onehome.test.mygank.adpter.MainVPAdapter;
import onehome.test.mygank.base.BaseMainFragment;
import onehome.test.mygank.base.BaseMvpFragment;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.presenter.MainFragmentPresenter;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/7.
 */

public class MainFragment extends BaseMvpFragment<MainFragmentPresenter> implements InitView {
    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager viewPager;

    @Override
    protected void injectComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        ArrayList<BaseMainFragment> baseMainFragments = new ArrayList<>();
        baseMainFragments.add(new AllDataFragment());
        baseMainFragments.add(new AndroidFragment());
        baseMainFragments.add(new IOSFragment());
        baseMainFragments.add(new WebFragment());
        viewPager.setAdapter(new MainVPAdapter(getChildFragmentManager(), baseMainFragments));
        tl.setupWithViewPager(viewPager, true);
    }

    @Override
    protected int rootViewID() {
        return R.layout.fragment_main;
    }

    @Override
    public void initDataSuccess(Object o) {

    }

    @Override
    public void initDataDefeat(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

}
