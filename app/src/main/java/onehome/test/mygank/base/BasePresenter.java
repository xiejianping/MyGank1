package onehome.test.mygank.base;

/**
 * Created by Administrator on 2017/9/4.
 */

public interface BasePresenter<V extends BaseView> {
    void onAttachView(V view);

    void onDetachView();
}
