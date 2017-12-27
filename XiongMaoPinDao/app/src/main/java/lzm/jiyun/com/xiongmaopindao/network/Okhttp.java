package lzm.jiyun.com.xiongmaopindao.network;

import java.io.IOException;

import lzm.jiyun.com.xiongmaopindao.utlis.Apps;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/12/19.
 */

public class Okhttp {
      private static Okhttp okhttp;
          private OkHttpClient build;

          private  Okhttp() {
               build = new OkHttpClient.Builder().build();
          }
          public static synchronized Okhttp getTran(){
              if (okhttp==null){
                   okhttp = new Okhttp();
              }
              return okhttp;
          }
          public void sendGet(String url, final Callbacks callbacks){
              Request builds = new Request.Builder().url(url).build();
              Call call = build.newCall(builds);
              call.enqueue(new Callback() {
                  @Override
                  public void onFailure(Call call, IOException e) {
                      System.out.println("========="+"请求网络失败");
                  }

                  @Override
                  public void onResponse(Call call, Response response) throws IOException {
                      final String string = response.body().string();
                      Apps.baseActivity.runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              callbacks.callback_Method(string);
                          }
                      });
                  }
              });
          }
}
