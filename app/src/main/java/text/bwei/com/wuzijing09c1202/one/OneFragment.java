package text.bwei.com.wuzijing09c1202.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.wuzijing09c1202.R;
import text.bwei.com.wuzijing09c1202.gen.News_beanDao;
import text.bwei.com.wuzijing09c1202.one.Api.Api;
import text.bwei.com.wuzijing09c1202.one.adapter.MyAdapter;
import text.bwei.com.wuzijing09c1202.one.adapter.MyGreendaoAdapter;
import text.bwei.com.wuzijing09c1202.one.bean.News;
import text.bwei.com.wuzijing09c1202.one.presenter.presenter;
import text.bwei.com.wuzijing09c1202.one.utils.DbHelper;
import text.bwei.com.wuzijing09c1202.one.view.Iview;
import text.bwei.com.wuzijing09c1202.one.view.News_bean;

/**
 * Created by dell on 2017/12/2.
 */

public class OneFragment extends Fragment implements Iview {


    @BindView(R.id.recycler)
    RecyclerView recycler;

    private Unbinder unbinder;
    private text.bwei.com.wuzijing09c1202.one.presenter.presenter presenter;

    
    private News_beanDao personDao;
    private List<News_bean> news_been;
    private News_bean news_bean;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.onfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new presenter(this);
        presenter.getOk(Api.URL);
        personDao = DbHelper.getInstance(getActivity()).getPersonDao();
        news_bean = new News_bean();

        news_been = personDao.loadAll();
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(new MyGreendaoAdapter(news_been, getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showSuccess(List<News.ResultsBean> list) {
        presenter.getOk(Api.URL);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(new MyAdapter(list, getActivity()));
        for (int i = 0; i < list.size(); i++) {
            news_bean.setDesc(list.get(i).getDesc());
            personDao.insert(news_bean);
        }
    }


}
