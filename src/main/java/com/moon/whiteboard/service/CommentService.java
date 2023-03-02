package com.moon.whiteboard.service;

import com.moon.whiteboard.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto writeComment(Long boardUid, CommentDto commentDto);

    List<CommentDto> getComments(Long boardUid);

    CommentDto getComment(Long commentUid);

    void deleteComment(Long commentUid);
}
