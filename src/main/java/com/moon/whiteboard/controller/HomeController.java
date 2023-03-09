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
    @GetMapping("/page")
    public String home(Model model, @RequestParam(name = "nowPage", defaultValue = "1") int currentPage) {
        int pageSize = 10; // 한 페이지에 표시될 게시물 수

        List<BoardDto> boardList = boardService.getBoardListWithPaging(currentPage, pageSize);

        int totalCount = boardService.getBoardCount();
        int totalPageCount = (int) Math.ceil((double) totalCount / pageSize);

        int startPage = ((currentPage - 1) / 5) * 5 + 1;
        int endPage = Math.min(startPage + 4, totalPageCount);

        int prevPage = Math.max(currentPage - 1, 1);
        int nextPage = Math.min(currentPage + 1, totalPageCount);

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
