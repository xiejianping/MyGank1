package onehome.test.mygank.mode.impl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import onehome.test.mygank.api.CommonApi;
import onehome.test.mygank.mode.entity.AllDataBean;
import onehome.test.mygank.mode.entity.WebsiteBean;
import onehome.test.mygank.mode.entity.WelfareBean;
import onehome.test.mygank.utils.RxJavaUtils;

/**
 * Created by Administrator on 2017/9/5.
 */

public class CommonImpl {
    CommonApi commonApi;

    @Inject
    public CommonImpl(CommonApi commonApi) {
        this.commonApi = commonApi;
    }

    //获取欢迎页的数据
    public Observable<List<WelfareBean>> getSplash(String type,int count) {
        return commonApi.getSplash(type, count)
                .compose(RxJavaUtils.rxSchedule())
                .map(o -> o.getResults());
    }

    public Observable<List<WebsiteBean>> getRecent(int count, int page) {
        return commonApi.getRecent(count, page)
                .compose(RxJavaUtils.rxSchedule())
                .map(o -> o.getResults());
    }

    public Observable<List<AllDataBean>> getAllData(String type, int count, int page) {
        return commonApi.getAllData(type, count, page)
                .compose(RxJavaUtils.rxSchedule())
                .map(o -> o.getResults());
    }
}
