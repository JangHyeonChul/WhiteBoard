package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boardDetail")
    public String getBoardDetail(Model model) {
        BoardDto board = boardService.getBoardDetail(1L); // uid == 1의 값을 가져오기.
        model.addAttribute("board", board);
        return "board/boardDetail";
    }

    @GetMapping("/write")
    public ModelAndView getWrite(ModelAndView mv){
        mv.setViewName("/board/boardWrite");
        return mv;
    }
}
