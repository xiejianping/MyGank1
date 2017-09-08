package onehome.test.mygank.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import onehome.test.mygank.R;
import onehome.test.mygank.adpter.MainRecyclerAdapter;
import onehome.test.mygank.base.BaseMainFragment;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.mode.entity.AllDataBean;
import onehome.test.mygank.presenter.DataPresenter;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/7.
 */

public class AllDataFragment extends BaseMainFragment<DataPresenter> implements InitView<List<AllDataBean>> {
    @Override
    protected void injectComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void loadData() {
        presenter.loadInitData("all", 10, 1);
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public String fragmentTabTitle() {
        return "All";
    }

    @Override
    public void initDataSuccess(List<AllDataBean> allDataBeen) {
        recyclerView.setAdapter(new MainRecyclerAdapter(getActivity(), allDataBeen));
    }

    @Override
    public void initDataDefeat(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}
