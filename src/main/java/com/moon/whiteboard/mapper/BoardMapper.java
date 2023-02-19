package com.moon.whiteboard.mapper;

import com.moon.whiteboard.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("BoardMapper")
public interface BoardMapper {
    List<BoardDto> getBoard() throws Exception;
}
