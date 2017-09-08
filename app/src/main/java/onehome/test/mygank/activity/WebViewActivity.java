package onehome.test.mygank.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseActivity;
import onehome.test.mygank.global.Constant;

/**
 * Created by Administrator on 2017/9/8.
 */

public class WebViewActivity extends BaseActivity {
    @BindView(R.id.wv)
    WebView webView;
    String url;

    @Override
    protected void initData() {
        if (url != null) {
            webView.loadUrl(url);
        }
    }

    @Override
    protected void initView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        url = getIntent().getStringExtra(Constant.WV_URL);
    }

    @Override
    protected int rootViewId() {
        return R.layout.activity_webview;
    }
}
