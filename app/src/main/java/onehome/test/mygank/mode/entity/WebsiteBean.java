package onehome.test.mygank.mode.entity;

/**
 * Created by Administrator on 2017/9/6.
 */

public class WebsiteBean {
    String _id;
    String content;
    String created_at;
    String publishedAt;
    String rand_id;
    String title;
    String updated_at;

    public String get_id() {
        return _id;
    }

    public String getContent() {
        return content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getRand_id() {
        return rand_id;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    @Override
    public String toString() {
        return "WebsiteBean{" +
                "_id='" + _id + '\'' +
                ", content='" + content + '\'' +
                ", created_at='" + created_at + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", rand_id='" + rand_id + '\'' +
                ", title='" + title + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
