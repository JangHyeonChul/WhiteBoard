package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public ModelAndView getWrite(ModelAndView mv){
        mv.addObject("boardDto", new BoardDto());
        mv.setViewName("/board/boardWrite");
        return mv;
    }
    @GetMapping("/boardDetail")
    public ModelAndView getDetail(ModelAndView mv){
        mv.setViewName("/board/boardDetail");
        return mv;
    }

    @PostMapping("/boardWrite")
    public String BoardWrite(@ModelAttribute("boardDto") BoardDto boardDto, @RequestParam("file")MultipartFile[] files) throws IOException {
        log.info("페이지 글쓰기 확인 111");
        boardService.write(boardDto, files);
        return "redirect:/";
    }

}
