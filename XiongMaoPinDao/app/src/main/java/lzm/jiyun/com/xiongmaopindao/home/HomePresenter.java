package lzm.jiyun.com.xiongmaopindao.home;

/**
* Created by TMVPHelper on 2017/12/19
*/
public class HomePresenter extends HomeContract.Presenter{

    @Override
    public void presenter_Method(String url) {
        baseModel.model_Method(url,new HomeMp() {
            @Override
            public void home_Method(String string) {
                baseView.view_Method(string);
            }
        });
    }
}