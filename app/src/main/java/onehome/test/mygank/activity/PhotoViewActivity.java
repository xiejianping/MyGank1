package onehome.test.mygank.activity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import onehome.test.mygank.R;
import onehome.test.mygank.base.BaseActivity;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Administrator on 2017/9/8.
 */

public class PhotoViewActivity extends BaseActivity {

    @BindView(R.id.photo_iv)
    PhotoView photoView;
    private String url;

    @Override
    protected void initData() {
        if (url != null) {
            PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(photoView);
            photoView.setZoomable(true);
            Glide.with(this).load(url).into(photoView);
            photoViewAttacher.update();
        }
    }

    @Override
    protected void initView() {
        url = getIntent().getStringExtra("uu");
    }

    @Override
    protected int rootViewId() {
        return R.layout.photo_activity;
    }
}
