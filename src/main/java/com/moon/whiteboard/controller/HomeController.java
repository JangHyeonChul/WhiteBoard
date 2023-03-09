package com.moon.whiteboard.controller;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class HomeController {
    @Autowired
    BoardService boardService;

//    @GetMapping("/")
//    public String index(Model model) {
//        List<BoardDto> boardList = boardService.getBoardList();
//        model.addAttribute("boardList", boardList);
//        return "index";
//    }

    @GetMapping("/")
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
}
