package com.edazh.gank3rd.vo;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
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
    @NonNull
    @PrimaryKey
    @SerializedName("_id")
    public final String id;
    public final String createdAt;
    public final String publishedAt;
    public final String desc;
    public final String type;
    public final boolean used;
    public final String who;

    public Gank(@NonNull String id, String createdAt, String publishedAt, String desc, String type, boolean used, String who) {
        this.id = id;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.desc = desc;
        this.type = type;
        this.used = used;
        this.who = who;
    }

    public String getDisplayWho() {
        return who == null ? "匿名用户" : who;
    }

    public String getDisplayCreatedAt() {
        return createdAt.substring(0, 10);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gank)) return false;

        Gank gank = (Gank) o;

        if (used != gank.used) return false;
        if (!id.equals(gank.id)) return false;
        if (createdAt != null ? !createdAt.equals(gank.createdAt) : gank.createdAt != null)
            return false;
        if (publishedAt != null ? !publishedAt.equals(gank.publishedAt) : gank.publishedAt != null)
            return false;
        if (desc != null ? !desc.equals(gank.desc) : gank.desc != null) return false;
        if (type != null ? !type.equals(gank.type) : gank.type != null) return false;
        return who != null ? who.equals(gank.who) : gank.who == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (publishedAt != null ? publishedAt.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (used ? 1 : 0);
        result = 31 * result + (who != null ? who.hashCode() : 0);
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "Gank{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
