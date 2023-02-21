package com.moon.whiteboard;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SelectTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void selectBoardList(){
        List<BoardDto> list = boardMapper.selectBoardList();
        System.out.println("전체 글 개수 : "+list.size()+"!!");
    }
}