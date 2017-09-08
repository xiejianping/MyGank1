package onehome.test.mygank.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import butterknife.BindView;
import onehome.test.mygank.R;
import onehome.test.mygank.adpter.WelfareRecyclerAdapter;
import onehome.test.mygank.base.BaseMvpFragment;
import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.mode.entity.WelfareBean;
import onehome.test.mygank.presenter.DataPresenter;
import onehome.test.mygank.presenter.WelfarePresenter;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/8.
 */

public class WelfareFragment extends BaseMvpFragment<WelfarePresenter> implements InitView<List<WelfareBean>> {
    @BindView(R.id.welfare_rv)
    RecyclerView recyclerView;

    @Override
    public void initDataSuccess(List<WelfareBean> welfareBean) {
        recyclerView.setAdapter(new WelfareRecyclerAdapter(getContext(), welfareBean));
    }

    @Override
    public void initDataDefeat(String errorMessage) {

    }

    @Override
    protected void injectComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void loadData() {
        presenter.loadData("福利", 20);
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    protected int rootViewID() {
        return R.layout.fragment_welfare;
    }
}
