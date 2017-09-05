package onehome.test.mygank.data.impl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import onehome.test.mygank.data.api.CommonApi;
import onehome.test.mygank.data.entity.HttpBaseResult;
import onehome.test.mygank.data.entity.WelfareBean;

/**
 * Created by Administrator on 2017/9/5.
 */

public class SplashImpl {
    CommonApi commonApi;

    @Inject
    public SplashImpl(CommonApi commonApi) {
        this.commonApi = commonApi;
    }

    public Observable<List<WelfareBean>> getSplash() {
        return commonApi.getSplash().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(e -> e.getResults());
    }
}
