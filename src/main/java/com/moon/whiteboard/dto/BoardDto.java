package com.moon.whiteboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
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
    private List<FileDto> files = new ArrayList<>();
}

