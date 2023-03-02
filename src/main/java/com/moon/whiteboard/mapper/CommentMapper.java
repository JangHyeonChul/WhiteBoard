package com.moon.whiteboard.mapper;

import com.moon.whiteboard.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void writeComment(CommentDto commentDto);

    List<CommentDto> getCommentList(Long boardUid);

    CommentDto getCommentUid(Long commentUid);

    void deleteComment(Long commentUid);
}
