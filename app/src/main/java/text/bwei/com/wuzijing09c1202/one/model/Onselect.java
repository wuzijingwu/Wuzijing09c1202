package text.bwei.com.wuzijing09c1202.one.model;

import java.util.List;

import text.bwei.com.wuzijing09c1202.one.bean.News;

/**
 * Created by dell on 2017/12/2.
 */

public interface Onselect {
    void dataSuccess(List<News.ResultsBean> list);
    void dataError(String s);

}
