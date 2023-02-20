package com.moon.whiteboard.mapper;

import com.moon.whiteboard.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findByEmail(String email);
    void saveMember(Member member);
}
