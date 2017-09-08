package onehome.test.mygank.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseMvpActivity;
import onehome.test.mygank.base.BaseMvpFragment;
import onehome.test.mygank.component.AppComponent;
import onehome.test.mygank.fragment.MainFragment;
import onehome.test.mygank.fragment.RecentFragment;
import onehome.test.mygank.fragment.WelfareFragment;
import onehome.test.mygank.global.Constant;
import onehome.test.mygank.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.dl)
    DrawerLayout drawerLayout;
    @BindView(R.id.nv)
    NavigationView navigationView;
    @BindView(R.id.fl)
    FrameLayout frameLayout;

    ImageView ivHeaderBg;
    private boolean prepareExit = false;
    private String imgUrl;
    private MainFragment mainFragment;
    private BaseMvpFragment currentFragment;
    private RecentFragment recentFragment;
    private WelfareFragment welfareFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void componentInject(AppComponent component) {
        component.inject(this);
    }

    @Override
    protected void initData() {
        if (imgUrl != null) {
            Glide.with(this).load(imgUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
//                    .bitmapTransform(new BlurTransformation(this, 80))
                    .into(ivHeaderBg);
        }
    }

    @Override
    protected void initView() {
        imgUrl = getIntent().getStringExtra(Constant.MAIN_URL);
        toolbar.setTitle("一家集中营");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        ivHeaderBg = ((ImageView) headerView.findViewById(R.id.iv_user_header_bg));
        recentFragment = new RecentFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl, recentFragment).commitAllowingStateLoss();
        currentFragment = recentFragment;

    }

    @Override
    protected int rootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
            return;
        }
        if (!prepareExit) {
            prepareExit = true;
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            Observable.timer(3, TimeUnit.SECONDS)
                    .subscribe(aLong -> {
                        prepareExit = false;
                    });
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_recent_gank:
                if (currentFragment == recentFragment) {
                    break;
                }
                if (recentFragment == null) {
                    recentFragment = new RecentFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fl, recentFragment).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().show(recentFragment).commitAllowingStateLoss();
                }
                getSupportFragmentManager().beginTransaction().hide(currentFragment).commitAllowingStateLoss();
                currentFragment = recentFragment;
                break;
            case R.id.menu_all_gank:
                if (currentFragment == mainFragment) {
                    break;
                }
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fl, mainFragment).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().show(mainFragment).commitAllowingStateLoss();
                }
                getSupportFragmentManager().beginTransaction().hide(currentFragment).commitAllowingStateLoss();
                currentFragment = mainFragment;
                break;
            case R.id.menu_welfare:
                if (currentFragment == welfareFragment) {
                    break;
                }
                if (welfareFragment == null) {
                    welfareFragment = new WelfareFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fl, welfareFragment).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().show(welfareFragment).commitAllowingStateLoss();
                }
                getSupportFragmentManager().beginTransaction().hide(currentFragment).commitAllowingStateLoss();
                currentFragment = welfareFragment;
                break;
            case R.id.menu_zhihu:
                Toast.makeText(this, "知乎日报", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_feedback:
                Toast.makeText(this, "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_about_me:
                Toast.makeText(this, "关于我", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(navigationView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
