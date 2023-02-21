package com.moon.whiteboard.service;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.moon.whiteboard.dto.BoardTypeDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {
    BoardDto getBoardDetail(long uid);
    void write(BoardDto boardDto, MultipartFile[] files) throws IOException;

    public List<BoardDto> getBoardList();//여기서 메소드 이름 선언 후 impl에서 구체화 해서 사용
}
