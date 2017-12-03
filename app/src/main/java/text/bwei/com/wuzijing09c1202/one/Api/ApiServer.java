package text.bwei.com.wuzijing09c1202.one.Api;

import retrofit2.http.GET;
import rx.Observable;
import text.bwei.com.wuzijing09c1202.one.bean.News;

/**
 * Created by dell on 2017/12/2.
 */

public interface ApiServer {
    @GET("api/data/Android/10/1")
    Observable<News> getDates();

}
