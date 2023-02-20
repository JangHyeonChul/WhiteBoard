package com.moon.whiteboard.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter @Setter @ToString
public class Member {

    private Integer uid;
    private String password;
    private String nickname;
    private String email;
    private Date created_at;
    private Date updated_at;
    private Integer is_del;

    public Member() {}

    public Member(Integer uid, String password, String nickname, String email, Date created_at, Date updated_at, Integer is_del) {
        this.uid = uid;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_del = is_del;
    }

}
