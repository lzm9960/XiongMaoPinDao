package lzm.jiyun.com.xiongmaopindao.entity.entityzg;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 2017/12/23.
 */
@Entity(nameInDb = "tabnu")
public class TablistBean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "url")
    private String url;
    @Property(nameInDb = "type")
    private String type;
    @Property(nameInDb = "order")
    private String order;
    @Generated(hash = 1476417125)
    public TablistBean(Long id, String title, String url, String type,
            String order) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.type = type;
        this.order = order;
    }
    @Generated(hash = 1369515462)
    public TablistBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getOrder() {
        return this.order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
}
