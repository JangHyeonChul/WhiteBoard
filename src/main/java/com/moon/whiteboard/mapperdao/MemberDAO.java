package com.moon.whiteboard.mapperdao;

import com.moon.whiteboard.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
    Member findByEmail(String email);
    void saveMember(Member member);
}
