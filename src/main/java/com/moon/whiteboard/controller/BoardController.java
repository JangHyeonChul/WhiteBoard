package com.moon.whiteboard.controller;

import com.moon.whiteboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/boardDetail")
    public ModelAndView getWrite(ModelAndView  mv){
        mv.setViewName("/board/boardDetail");
        return mv;
    }
    @GetMapping("/write")
    public ModelAndView getWrite(ModelAndView mv){
        mv.setViewName("/board/boardWrite");
        return mv;
    }

}
