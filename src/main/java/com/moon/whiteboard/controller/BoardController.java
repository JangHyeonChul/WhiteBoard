package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/page")
    public String home(Model model, @RequestParam(defaultValue = "1") int page) {
        // 한 페이지에 표시 될 게시물 수
        int pageSize = 10;

        // 총 게시물 수
        int totalCount = boardService.getBoardCount();

        // 총 페이지 수
        int totalPageCount = (int) Math.ceil((double) totalCount / pageSize);

        // 현재 페이지 번호
        int currentPage = page;

        // 시작 위치
        int start = (currentPage - 1) * pageSize;

        // 페이지 번호 범위 설정
        int startPage = ((currentPage - 1) / 5) * 5 + 1;
        int endPage = Math.min(startPage + 4, totalPageCount);

        // 이전 페이지, 다음 페이지 설정
        int prevPage = Math.max(currentPage - 1, 1);
        int nextPage = Math.min(currentPage + 1, totalPageCount);

        // 게시물 리스트 가져오기
        List<BoardDto> boardList = boardService.getBoardListWithPaging(currentPage);

        model.addAttribute("boardList", boardList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        return "index";
    }

//
//    @GetMapping("")
//    public String index(Model model) {
//        List<BoardDto> boardList = boardService.getBoardList();
//        model.addAttribute("boardList", boardList);
//        return "index";
//    }

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
