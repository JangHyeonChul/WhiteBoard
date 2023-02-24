package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.CommentDto;
import com.moon.whiteboard.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam Long boardUid, @RequestBody CommentDto commentDto){
        CommentDto writeComment = commentService.writeComment(boardUid, commentDto);
        return ResponseEntity.ok(writeComment);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComment(@RequestParam Long boardUid){
        List<CommentDto> comment = commentService.getComments(boardUid);
        return ResponseEntity.ok(comment);
    }
}
