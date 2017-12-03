package text.bwei.com.wuzijing09c1202.one.presenter;

import java.util.List;

import text.bwei.com.wuzijing09c1202.one.bean.News;
import text.bwei.com.wuzijing09c1202.one.model.Imodel;
import text.bwei.com.wuzijing09c1202.one.model.Onselect;
import text.bwei.com.wuzijing09c1202.one.model.model;
import text.bwei.com.wuzijing09c1202.one.view.Iview;

/**
 * Created by dell on 2017/12/2.
 */

public class presenter {
    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getOk(String url) {
        imodel.RequestSuccess(url, new Onselect() {
            @Override
            public void dataSuccess(List<News.ResultsBean> list) {
                iview.showSuccess(list);
            }

            @Override
            public void dataError(String s) {

            }
        });


    }


}
