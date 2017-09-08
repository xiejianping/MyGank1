package onehome.test.mygank.base;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import onehome.test.mygank.R;

/**
 * Created by Administrator on 2017/9/8.
 */

public abstract class BaseMainFragment<T extends BaseMvpPresenter> extends BaseMvpFragment<T> {
    @BindView(R.id.all_rv)
    protected RecyclerView recyclerView;

    public abstract String fragmentTabTitle();

    @Override
    protected int rootViewID() {
        return R.layout.fragment_all;
    }
}
