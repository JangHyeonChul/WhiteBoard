package com.moon.whiteboard.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data //-> 게더 세터
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
}
