package onehome.test.mygank.api;

import java.util.List;

import io.reactivex.Observable;
import onehome.test.mygank.mode.entity.HttpBaseResult;
import onehome.test.mygank.mode.entity.Website;
import onehome.test.mygank.mode.entity.WelfareBean;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/9/5.
 */

public interface CommonApi {
    /**
     * @return
     */
    @GET("random/data/福利/2")
    Observable<HttpBaseResult<List<WelfareBean>>> getSplash();

    @GET("history/content/{count}/{page}")
    Observable<HttpBaseResult<List<Website>>> getRecent(@Path("count") int count, @Path("page") int page);
}