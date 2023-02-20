package com.moon.whiteboard.mapper;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.dto.BoardTypeDto;
import com.moon.whiteboard.dto.FileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDto boardDto);

    void insertFile(List<FileDto> fileList);

    BoardDto selectBoard(long uid);
}
