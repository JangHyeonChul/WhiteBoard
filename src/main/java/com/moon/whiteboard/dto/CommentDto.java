package com.moon.whiteboard.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private long uid;
    private long mother_uid;
    private String comment;
    private String created_user;
    private Date created_at;
    private Date update_at;
    private int is_del;
}
