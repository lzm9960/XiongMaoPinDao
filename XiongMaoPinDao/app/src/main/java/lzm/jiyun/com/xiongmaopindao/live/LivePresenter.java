package lzm.jiyun.com.xiongmaopindao.live;

/**
* Created by TMVPHelper on 2017/12/20
*/
public class LivePresenter extends LiveContract.Presenter{

    @Override
    public void presenter_Method(final int type, String url) {
     baseModel.model_Method(url, new LiveMp() {
         @Override
         public void liveMp_Method(String string) {
             baseView.view_Method(string,type);
         }
     });
    }
}