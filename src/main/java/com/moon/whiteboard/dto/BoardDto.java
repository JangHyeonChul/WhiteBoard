package com.moon.whiteboard.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class BoardDto {
    private long uid;
    private String type;
    private String title;
    private String content;
    private String created_user;
    private Date created_at;
    private Date updated_at;
    private int is_del;
    private long view_cnt;

    public BoardDto(String type, String title, String content, String created_user, Date created_at, Date updated_at, int is_del, long view_cnt) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.created_user = created_user;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_del = is_del;
        this.view_cnt = view_cnt;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_user='" + created_user + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_del=" + is_del +
                ", view_cnt=" + view_cnt +
                '}';
    }
}
