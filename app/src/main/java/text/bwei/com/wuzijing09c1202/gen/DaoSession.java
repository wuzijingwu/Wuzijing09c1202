package text.bwei.com.wuzijing09c1202.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import text.bwei.com.wuzijing09c1202.one.view.News_bean;

import text.bwei.com.wuzijing09c1202.gen.News_beanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig news_beanDaoConfig;

    private final News_beanDao news_beanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        news_beanDaoConfig = daoConfigMap.get(News_beanDao.class).clone();
        news_beanDaoConfig.initIdentityScope(type);

        news_beanDao = new News_beanDao(news_beanDaoConfig, this);

        registerDao(News_bean.class, news_beanDao);
    }
    
    public void clear() {
        news_beanDaoConfig.clearIdentityScope();
    }

    public News_beanDao getNews_beanDao() {
        return news_beanDao;
    }

}