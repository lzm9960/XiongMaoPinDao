package lzm.jiyun.com.xiongmaopindao.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/12/21.
 */

public class BaseDra {
    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"5710"}
     * video : [{"vsid":"VSET100167216881","order":"5724","vid":"d7dfe08eb36847e0b396650bdf32c44c","t":"《精彩一刻》 20171221 小仙女享受的服务就是不一样~","url":"http://tv.cntv.cn/video/VSET100167216881/d7dfe08eb36847e0b396650bdf32c44c","ptime":"2017-12-21 12:40:06","img":"http://p1.img.cctvpic.com/fmspic/2017/12/21/d7dfe08eb36847e0b396650bdf32c44c-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"5723","vid":"b031ec665c664755ae9433af71cbd4bf","t":"《精彩一刻》 20171221 嗝~吃得有点多了~","url":"http://tv.cntv.cn/video/VSET100167216881/b031ec665c664755ae9433af71cbd4bf","ptime":"2017-12-21 12:39:15","img":"http://p2.img.cctvpic.com/fmspic/2017/12/21/b031ec665c664755ae9433af71cbd4bf-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"5722","vid":"e054c73937bf47b6b4de47dcb3336603","t":"《精彩一刻》 20171221 挠痒绷脚尖是熊家传统么？","url":"http://tv.cntv.cn/video/VSET100167216881/e054c73937bf47b6b4de47dcb3336603","ptime":"2017-12-21 12:38:11","img":"http://p4.img.cctvpic.com/fmspic/2017/12/21/e054c73937bf47b6b4de47dcb3336603-20.jpg?p=2&h=120","len":"00:00:20","em":"CM01"},{"vsid":"VSET100167216881","order":"5721","vid":"887fbb13a15a4e55afdf7084faf146d9","t":"《精彩一刻》 20171221 \u201c乔伊\u201d：烦熊迪迪可真烦~","url":"http://tv.cntv.cn/video/VSET100167216881/887fbb13a15a4e55afdf7084faf146d9","ptime":"2017-12-21 12:36:46","img":"http://p4.img.cctvpic.com/fmspic/2017/12/21/887fbb13a15a4e55afdf7084faf146d9-34.jpg?p=2&h=120","len":"00:00:48","em":"CM01"},{"vsid":"VSET100167216881","order":"5720","vid":"2aec1f0c4f444b8799584bf12093dc17","t":"《精彩一刻》 20171221 看不出破绽的杂技表演","url":"http://tv.cntv.cn/video/VSET100167216881/2aec1f0c4f444b8799584bf12093dc17","ptime":"2017-12-21 09:47:21","img":"http://p3.img.cctvpic.com/fmspic/2017/12/21/2aec1f0c4f444b8799584bf12093dc17-24.jpg?p=2&h=120","len":"00:00:28","em":"CM01"},{"vsid":"VSET100167216881","order":"5719","vid":"4ed62477e07e4036a11cf39b859c696a","t":"《精彩一刻》 20171221 报告！这个熊猫耍流氓","url":"http://tv.cntv.cn/video/VSET100167216881/4ed62477e07e4036a11cf39b859c696a","ptime":"2017-12-21 09:46:18","img":"http://p2.img.cctvpic.com/fmspic/2017/12/21/4ed62477e07e4036a11cf39b859c696a-40.jpg?p=2&h=120","len":"00:01:00","em":"CM01"},{"vsid":"VSET100167216881","order":"5718","vid":"ddbe8059d17c4779836affe566aebffd","t":"《精彩一刻》 20171221 一只吃饭不认真的大熊猫","url":"http://tv.cntv.cn/video/VSET100167216881/ddbe8059d17c4779836affe566aebffd","ptime":"2017-12-21 09:45:27","img":"http://p2.img.cctvpic.com/fmspic/2017/12/21/ddbe8059d17c4779836affe566aebffd-22.jpg?p=2&h=120","len":"00:00:24","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 5710
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 5724
         * vid : d7dfe08eb36847e0b396650bdf32c44c
         * t : 《精彩一刻》 20171221 小仙女享受的服务就是不一样~
         * url : http://tv.cntv.cn/video/VSET100167216881/d7dfe08eb36847e0b396650bdf32c44c
         * ptime : 2017-12-21 12:40:06
         * img : http://p1.img.cctvpic.com/fmspic/2017/12/21/d7dfe08eb36847e0b396650bdf32c44c-9.jpg?p=2&h=120
         * len : 00:00:19
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        @Override
        public String toString() {
            return "VideoBean{" +
                    "vsid='" + vsid + '\'' +
                    ", order='" + order + '\'' +
                    ", vid='" + vid + '\'' +
                    ", t='" + t + '\'' +
                    ", url='" + url + '\'' +
                    ", ptime='" + ptime + '\'' +
                    ", img='" + img + '\'' +
                    ", len='" + len + '\'' +
                    ", em='" + em + '\'' +
                    '}';
        }
    }
}
