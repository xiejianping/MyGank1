package onehome.test.mygank.api;

import java.util.List;

import io.reactivex.Observable;
import onehome.test.mygank.mode.entity.AllDataBean;
import onehome.test.mygank.mode.entity.HttpBaseResult;
import onehome.test.mygank.mode.entity.WebsiteBean;
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
    @GET("random/data/{type}/{count}")
    Observable<HttpBaseResult<List<WelfareBean>>> getSplash(@Path("type") String type, @Path("count") int count);

    @GET("history/content/{count}/{page}")
    Observable<HttpBaseResult<List<WebsiteBean>>> getRecent(@Path("count") int count, @Path("page") int page);

    @GET("data/{type}/{count}/{page}")
    Observable<HttpBaseResult<List<AllDataBean>>> getAllData(@Path("type") String type, @Path("count") int count, @Path("page") int page);
}