package onehome.test.mygank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseMvpActivity;
import onehome.test.mygank.component.AppComponent;

import onehome.test.mygank.global.Constant;
import onehome.test.mygank.mode.entity.WelfareBean;
import onehome.test.mygank.view.SplashView;
import onehome.test.mygank.presenter.SplashPresenter;


/**
 * Created by Administrator on 2017/9/4.
 */

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashView {

    @BindView(R.id.tv_time)
    TextView time;
    @BindView(R.id.iv_splash_bg)
    ImageView bg;
    String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void componentInject(AppComponent component) {
        component.inject(this);
    }

    @Override
    protected void initData() {
        presenter.loadData();
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> time.setText(4 - aLong + ""), e -> e.printStackTrace(),
                        () -> {
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            intent.putExtra(Constant.MAIN_URL, url);
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
//        File photoCacheDir = Glide.getPhotoCacheDir(this);
//        Log.d("4444444", "getSplashSuccess: " + photoCacheDir.getAbsolutePath());
//        if (photoCacheDir.exists()) {
//            File[] files = photoCacheDir.listFiles(new FileFilter() {
//                @Override
//                public boolean accept(File pathname) {
//                    Log.d("4444444", "getSplashSuccess: " + photoCacheDir.getName());
//                    if (pathname.getName().endsWith(".jpg")) {
//                        return true;
//                    }
//                    return false;
//                }
//            });
//            if (files.length > 0) {
//                Glide.with(this).load(welfareBean.getUrl()).asBitmap().placeholder(Drawable.createFromPath(files[0].getAbsolutePath())).into(bg);
//                return;
//            }
//        }
        url = welfareBean.getUrl();
        Glide.with(this).load(url).asBitmap().into(bg);

    }
}
