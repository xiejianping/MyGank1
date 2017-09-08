package onehome.test.mygank.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import onehome.test.mygank.R;
import onehome.test.mygank.adpter.RecentRecyclerAdapter;
import onehome.test.mygank.base.BaseMvpFragment;
import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.component.DaggerActivityComponent;
import onehome.test.mygank.component.DaggerAppComponent;
import onehome.test.mygank.mode.entity.WebsiteBean;
import onehome.test.mygank.presenter.RecentPresenter;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/6.
 */

public class RecentFragment extends BaseMvpFragment<RecentPresenter> implements InitView<List<WebsiteBean>> {
    @BindView(R.id.rv)
    RecyclerView rv;
    private List<WebsiteBean> list;

    @Override
    protected void injectComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected int rootViewID() {
        return R.layout.fragment_recent;
    }

    @Override
    public void initDataSuccess(List<WebsiteBean> websiteBeen) {
        list = websiteBeen;
        rv.setAdapter(new RecentRecyclerAdapter(getContext(), list));
    }

    @Override
    public void initDataDefeat(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}
