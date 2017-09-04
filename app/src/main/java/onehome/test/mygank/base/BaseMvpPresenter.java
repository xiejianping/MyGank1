package onehome.test.mygank.base;

/**
 * Created by Administrator on 2017/9/4.
 */

public class BaseMvpPresenter<V extends BaseView> implements BasePresenter<V> {
    private V view;

    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
