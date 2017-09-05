package onehome.test.mygank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseMvpActivity;
import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.component.AppComponent;

import onehome.test.mygank.component.DaggerActivityComponent;
import onehome.test.mygank.data.entity.WelfareBean;
import onehome.test.mygank.data.impl.SplashView;
import onehome.test.mygank.presenter.SplashPresenter;


/**
 * Created by Administrator on 2017/9/4.
 */

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashView {
    //    @Inject
//    SplashPresenter presenter;
    @BindView(R.id.tv_time)
    TextView time;
    @BindView(R.id.iv_splash_bg)
    ImageView bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        presenter.loadData();
    }

    @Override
    protected void componentInject(AppComponent component) {
        component.inject(this);
    }

    @Override
    protected void initData() {
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> time.setText(4 - aLong + ""), e -> e.printStackTrace(),
                        () -> {
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        });
    }

    @Override
    protected void initView() {

    }

    public void tip(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int rootViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void getSplashSuccess(WelfareBean welfareBean) {

    }
}
