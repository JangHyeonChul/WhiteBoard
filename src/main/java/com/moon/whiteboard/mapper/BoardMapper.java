package com.moon.whiteboard.mapper;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.dto.BoardTypeDto;
import com.moon.whiteboard.dto.FileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDto boardDto);

    void insertFile(List<FileDto> fileList);
}
