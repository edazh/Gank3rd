package com.edazh.gank3rd.vo;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:
 */
@Entity
public class Gank {
    @PrimaryKey
    @SerializedName("_id")
    private String id;
    private String createAt;
    private String publishedAt;
    private String desc;
    private String type;
    private boolean used;
    private String who;

    public Gank(String id, String createAt, String publishedAt, String desc, String type, boolean used, String who) {
        this.id = id;
        this.createAt = createAt;
        this.publishedAt = publishedAt;
        this.desc = desc;
        this.type = type;
        this.used = used;
        this.who = who;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gank)) return false;

        Gank gank = (Gank) o;

        if (used != gank.used) return false;
        if (id != null ? !id.equals(gank.id) : gank.id != null) return false;
        if (createAt != null ? !createAt.equals(gank.createAt) : gank.createAt != null)
            return false;
        if (publishedAt != null ? !publishedAt.equals(gank.publishedAt) : gank.publishedAt != null)
            return false;
        if (desc != null ? !desc.equals(gank.desc) : gank.desc != null) return false;
        if (type != null ? !type.equals(gank.type) : gank.type != null) return false;
        return who != null ? who.equals(gank.who) : gank.who == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (publishedAt != null ? publishedAt.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (used ? 1 : 0);
        result = 31 * result + (who != null ? who.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Gank{" +
                "id='" + id + '\'' +
                ", createAt='" + createAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
