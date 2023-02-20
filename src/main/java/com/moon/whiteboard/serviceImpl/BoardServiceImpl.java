package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.mapper.BoardMapper;
import com.moon.whiteboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardDto getBoardDetail(Long uid) {
        return boardMapper.selectBoard(uid);
    }
}
