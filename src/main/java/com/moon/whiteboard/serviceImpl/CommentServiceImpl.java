package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.dto.CommentDto;
import com.moon.whiteboard.mapper.CommentMapper;
import com.moon.whiteboard.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    @Override
    public CommentDto getComment(Long commentUid) {
        return commentMapper.getCommentUid(commentUid);
    }

    @Override
    public void deleteComment(Long commentUid) {
        log.info("댓글삭제 확인 222");
        commentMapper.deleteComment(commentUid);
    }
}
