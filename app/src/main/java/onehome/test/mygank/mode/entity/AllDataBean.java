package onehome.test.mygank.mode.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */

public class AllDataBean {
    String _id;
    String createdAt;
    String publishedAt;
    String desc;
    String source;
    String type;
    String url;
    String used;
    String who;
    List<String> images;

    @Override
    public String toString() {
        return "AllDataBean{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", desc='" + desc + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used='" + used + '\'' +
                ", who='" + who + '\'' +
                ", images=" + images +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getDesc() {
        return desc;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getUsed() {
        return used;
    }

    public String getWho() {
        return who;
    }

    public List<String> getImages() {
        return images;
    }
}
