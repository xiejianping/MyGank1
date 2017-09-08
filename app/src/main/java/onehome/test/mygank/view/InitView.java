package onehome.test.mygank.view;

import onehome.test.mygank.base.BaseView;
import onehome.test.mygank.mode.entity.WelfareBean;

/**
 * Created by Administrator on 2017/9/5.
 */

public interface InitView<T> extends BaseView {
    void initDataSuccess(T t);
    void initDataDefeat(String errorMessage);
}
