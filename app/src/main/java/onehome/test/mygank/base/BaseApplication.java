package onehome.test.mygank.base;

import android.app.Application;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/9/4.
 */

public class BaseApplication extends Application {
    private LinkedList<BaseActivity> linkedList;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    protected LinkedList<BaseActivity> getActivityList() {
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        return linkedList;
    }
}
