package com.web.controller;

import com.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards/new")
    public String createForm(Model model) {
        return "/board/createForm";
    }

    @GetMapping("/boards/{idx}/edit")
    public String updateForm(@PathVariable Long idx,
                        Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/updateForm";
    }

    @GetMapping("/boards")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }
}
