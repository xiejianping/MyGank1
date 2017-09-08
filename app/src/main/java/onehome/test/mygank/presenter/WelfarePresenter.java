package onehome.test.mygank.presenter;

import java.util.List;

import javax.inject.Inject;

import onehome.test.mygank.base.BaseMvpPresenter;
import onehome.test.mygank.mode.entity.WelfareBean;
import onehome.test.mygank.mode.impl.CommonImpl;
import onehome.test.mygank.view.InitView;

/**
 * Created by Administrator on 2017/9/4.
 */

public class WelfarePresenter extends BaseMvpPresenter<InitView<List<WelfareBean>>> {
    private CommonImpl splashimpl;

    @Inject
    public WelfarePresenter(CommonImpl splashimpl) {
        this.splashimpl = splashimpl;
    }

    public void loadData(String type,int count) {
        splashimpl.getSplash(type, count).take(1).subscribe(e -> {
            if (!e.isEmpty()) {
                getView().initDataSuccess(e);
            }
        });
    }
}
