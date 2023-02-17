package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.mapper.BoardMapper;
import com.moon.whiteboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

}
