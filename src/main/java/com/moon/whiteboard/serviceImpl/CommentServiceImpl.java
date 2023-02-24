package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.dto.CommentDto;
import com.moon.whiteboard.mapper.CommentMapper;
import com.moon.whiteboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public CommentDto writeComment(Long boardUid, CommentDto commentDto) {
        commentDto.setMother_uid(boardUid);
        commentMapper.writeComment(commentDto);
        return commentDto;
    }

    @Override
    public List<CommentDto> getComments(Long boardUid) {
        return commentMapper.getCommentList(boardUid);
    }
}
