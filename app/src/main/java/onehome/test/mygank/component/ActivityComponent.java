package onehome.test.mygank.component;

import dagger.Component;
import onehome.test.mygank.activity.SplashActivity;
import onehome.test.mygank.dagger.ActivityScope;
import onehome.test.mygank.data.api.CommonApi;

/**
 * Created by Administrator on 2017/9/5.
 */

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

}
