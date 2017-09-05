package onehome.test.mygank.data.api;

import java.util.List;

import io.reactivex.Observable;
import onehome.test.mygank.data.entity.HttpBaseResult;
import onehome.test.mygank.data.entity.WelfareBean;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/9/5.
 */

public interface CommonApi {
    /**
     * @return
     */
    @GET("random/data/福利/2")
    Observable<HttpBaseResult<List<WelfareBean>>> getSplash();

}
