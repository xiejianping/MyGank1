package onehome.test.mygank.mode.impl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import onehome.test.mygank.api.CommonApi;
import onehome.test.mygank.mode.entity.Website;
import onehome.test.mygank.mode.entity.WelfareBean;

/**
 * Created by Administrator on 2017/9/5.
 */

public class CommonImpl {
    CommonApi commonApi;

    @Inject
    public CommonImpl(CommonApi commonApi) {
        this.commonApi = commonApi;
    }

    public Observable<List<WelfareBean>> getSplash() {
        return commonApi.getSplash().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(e -> e.getResults());
    }

    public Observable<List<Website>> getRecent() {
        return null;
    }
}
