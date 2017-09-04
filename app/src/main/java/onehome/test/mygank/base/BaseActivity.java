package onehome.test.mygank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/9/4.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(rootViewId());
        bind = ButterKnife.bind(this);
        synchronized (BaseActivity.this) {
            ((BaseApplication) getApplication()).getActivityList().add(this);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int rootViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (BaseActivity.this) {
            ((BaseApplication) getApplication()).getActivityList().remove(this);
        }
        bind.unbind();
    }
}
