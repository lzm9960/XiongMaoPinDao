package lzm.jiyun.com.xiongmaopindao.fragment.ggBoFang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import lzm.jiyun.com.xiongmaopindao.R;

public class GgActivity extends AppCompatActivity {

    private NiceVideoPlayer mNiceVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gg);
        init();
    }

    private void init() {
        mNiceVideoPlayer = (NiceVideoPlayer) findViewById(R.id.nice_video_player);
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
        mNiceVideoPlayer.setUp("http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/14/bfe0d8eaad33462d8a6346820100f91b_h264818000nero_aac32.mp4 ", null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("大熊猫");
        controller.setImage(R.drawable.pb_change);
        mNiceVideoPlayer.setController(controller);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在onStop时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在Activity中onBackPress要交给NiceVideoPlayer先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    public void enterTinyWindow(View view) {
        if (mNiceVideoPlayer.isIdle()) {
            Toast.makeText(this, "要点击播放后才能进入小窗口", Toast.LENGTH_SHORT).show();
        } else {
            mNiceVideoPlayer.enterTinyWindow();
        }
    }

}

