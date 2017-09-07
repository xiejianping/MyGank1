package onehome.test.mygank.presenter;

import java.util.List;

import javax.inject.Inject;

import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.mode.entity.WebsiteBean;
import onehome.test.mygank.mode.impl.CommonImpl;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/6.
 */

public class RecentPresenter extends BaseMvpPresenter<InitView<List<WebsiteBean>>> {
    CommonImpl common;

    @Inject
    public RecentPresenter(CommonImpl common) {
        this.common = common;
    }

    public void loadData() {
        common.getRecent(10, 1).subscribe(n -> {
            getView().initDataSuccess(n);
        },e->e.printStackTrace());
    }
}
