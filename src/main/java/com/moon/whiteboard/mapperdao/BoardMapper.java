package com.moon.whiteboard.mapperdao;

import com.moon.whiteboard.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    void insertBoard(BoardDto boardDto);
}
