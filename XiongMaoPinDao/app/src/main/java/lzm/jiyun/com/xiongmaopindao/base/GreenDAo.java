package lzm.jiyun.com.xiongmaopindao.base;

import android.content.Context;

import com.jiyun.com.day07_greendao.AlllistBeanDao;
import com.jiyun.com.day07_greendao.DaoMaster;
import com.jiyun.com.day07_greendao.DaoSession;
import com.jiyun.com.day07_greendao.TablistBeanDao;

/**
 * Created by lenovo on 2017/12/23.
 */

public class GreenDAo {
      private static GreenDAo greenDAO;
          private  DaoMaster.DevOpenHelper devOpenHelper;

          private GreenDAo(Context context) {
               devOpenHelper = new DaoMaster.DevOpenHelper(context, ".db");
          }
          public static synchronized GreenDAo getTan(Context context) {
              if (greenDAO==null) {
                  greenDAO = new GreenDAo(context);
              }
              return greenDAO;
          }
          public AlllistBeanDao getDao(){
              DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
              DaoSession daoSession = daoMaster.newSession();
              AlllistBeanDao alllistBeanDao = daoSession.getAlllistBeanDao();
              return alllistBeanDao;
          }
    public TablistBeanDao getDaos(){
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        TablistBeanDao tablistBeanDao = daoSession.getTablistBeanDao();
        return tablistBeanDao;
    }
}
