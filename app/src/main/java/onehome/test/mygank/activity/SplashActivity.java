package onehome.test.mygank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseMvpActivity;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.component.DaggerAppComponent;
import onehome.test.mygank.module.AppModule;
import onehome.test.mygank.presenter.SplashPresenter;

/**
 * Created by Administrator on 2017/9/4.
 */

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements BaseView {
    @BindView(R.id.tv_time)
    TextView time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void ComponentInject() {
        DaggerAppComponent.builder().appModule(new AppModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .subscribe(aLong -> time.setText(5 - aLong + ""), e -> e.printStackTrace(),
                        () -> {
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int rootViewId() {
        return R.layout.activity_splash;
    }
}
