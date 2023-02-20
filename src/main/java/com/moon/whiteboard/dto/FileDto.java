package com.moon.whiteboard.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
@Getter
@Data
public class FileDto {
    private long uid;
    private long mother_uid;
    private long file_size;
    private String file_name;
    private String file_url;
    private Date created_at;
    private Date updated_at;

    public FileDto(long mother_uid, String fileName, Long fileSize, String fileUrl) {
        this.mother_uid = mother_uid;
        this.file_name = fileName;
        this.file_size = fileSize;
        this.file_url = fileUrl;
    }

    public long getFileSize() {
        return file_size;
    }

    public String getFileName() {
        return file_name;
    }

    public String getFileUrl() {
        return file_url;
    }
}
