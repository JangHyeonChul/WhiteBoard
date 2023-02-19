package com.moon.whiteboard.controller;

import com.moon.whiteboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public ModelAndView getWrite(ModelAndView mv){
        mv.setViewName("/board/boardWrite");
        return mv;
    }
    @GetMapping("/boardDetail")
    public String getDetail(){
        return "/board/boardDetail";
    }//보드 /*/ 딛=테일

}
