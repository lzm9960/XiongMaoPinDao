package lzm.jiyun.com.xiongmaopindao.entity.entityzg;

import java.util.List;

/**
 * Created by lenovo on 2017/12/26.
 */

public class BaseZgTong {
    private List<LiveBean> live;

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class LiveBean {
        /**
         * title : 青海湖日出
         * brief : 青海湖又名“措温布”，藏语“青色的海”之意。位于青海省西北部的青海湖盆地内，中国最大内陆湖，中国最大咸水湖。是中国国家自然与文化双遗产、国家5A级旅游景区。同时又是全国八大鸟类自然保护区和七大国际重要湿地之一。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451297049892_125.jpg
         * id : lucidao01
         * order : 1
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String order;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
