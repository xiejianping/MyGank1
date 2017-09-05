package onehome.test.mygank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.component.DaggerAppComponent;
import onehome.test.mygank.module.AppModule;
import onehome.test.mygank.module.ClientModule;

/**
 * Created by Administrator on 2017/9/4.
 */

public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends BaseActivity implements BaseView {
    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hh();
//        componentInject();
//        presenter.onAttachView(this);
    }

    protected void hh() {
        AppComponent component = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .clientModule(new ClientModule())
                .build();
        componentInject(component);
    }

    protected abstract void componentInject(AppComponent component);

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (presenter != null) {
//            presenter.onDetachView();
//        }
    }

    @Override
    public View getActivityRootView() {
        return this.findViewById(android.R.id.content);
    }
}
