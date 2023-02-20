package com.moon.whiteboard.service;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BoardService {
    BoardDto getBoardDetail(Long uid);
}
