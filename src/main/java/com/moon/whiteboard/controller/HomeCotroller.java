package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class HomeCotroller {
    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "index";
    }
}
