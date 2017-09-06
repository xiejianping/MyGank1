package onehome.test.mygank.component;

import dagger.Component;
import onehome.test.mygank.dagger.ActivityScope;

/**
 * Created by Administrator on 2017/9/5.
 */

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

}
