package onehome.test.mygank.presenter;

import java.util.List;

import javax.inject.Inject;

import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.mode.entity.AllDataBean;
import onehome.test.mygank.mode.impl.CommonImpl;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/7.
 */

public class DataPresenter extends BaseMvpPresenter<InitView<List<AllDataBean>>> {
    CommonImpl common;

    @Inject
    public DataPresenter(CommonImpl common) {
        this.common = common;
    }

    public void loadInitData(String type, int count, int page) {
        InitView<List<AllDataBean>> view = getView();
        common.getAllData(type, count, page)
                .subscribe(o -> {
                    if (!o.isEmpty()) {
                        view.initDataSuccess(o);
                    } else {
                        view.initDataDefeat("");
                    }
                });
    }

}
