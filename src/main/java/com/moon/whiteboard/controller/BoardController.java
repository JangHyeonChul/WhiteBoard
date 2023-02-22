package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("")
    public String index(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        System.out.println("나오는지"+boardList);
        return "index";
    }

    @GetMapping("/boardDetail")
    public String getBoardDetail(Model model, @RequestParam("uid") long uid) {
        BoardDto board = boardService.getBoardDetail(uid); // uid == board.uid 의 값을 가져오기.
        model.addAttribute("board", board);
        return "board/boardDetail";
    }

    @GetMapping("/write")
    public ModelAndView getWrite(ModelAndView mv){
        mv.addObject("boardDto", new BoardDto());
        mv.setViewName("/board/boardWrite");

        return mv;
    }

    @RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
    public String BoardWrite(@ModelAttribute("boardDto") BoardDto boardDto, @RequestParam("file")MultipartFile[] files) throws IOException {
        log.info("페이지 글쓰기 확인 111");
        boardService.write(boardDto, files);
        return "redirect:/";
    }

}
