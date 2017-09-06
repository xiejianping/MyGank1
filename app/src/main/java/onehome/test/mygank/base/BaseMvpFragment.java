package onehome.test.mygank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.component.DaggerAppComponent;
import onehome.test.mygank.module.AppModule;
import onehome.test.mygank.module.ClientModule;

/**
 * Created by Administrator on 2017/9/6.
 */

public abstract class BaseMvpFragment<P extends BaseMvpPresenter> extends BaseFragment implements BaseView {
    @Inject
    protected P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule()).clientModule(new ClientModule()).build();
        injectComponent(appComponent);
        presenter.onAttachView(this);
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract void injectComponent(AppComponent appComponent);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.onDetachView();
        }
    }
}
