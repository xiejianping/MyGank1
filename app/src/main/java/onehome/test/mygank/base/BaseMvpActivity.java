package onehome.test.mygank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/9/4.
 */

public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends BaseActivity implements BaseView {
    @Inject
    P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentInject();
        presenter.onAttachView(this);
    }

    protected abstract void ComponentInject();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDetachView();
        }
    }

    @Override
    public View getActivityRootView() {
        return this.findViewById(android.R.id.content);
    }
}
