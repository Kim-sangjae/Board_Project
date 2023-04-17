package org.koreait.project.controllers.boards;


import jakarta.validation.Valid;
import org.koreait.project.models.boards.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {



    @Autowired
    private BoardSaveService service;

    @Autowired
    private BoardWriteService writeService;
    @Autowired
    private BoardDao boardDao;


    @GetMapping("")
    public String main(){

        return "board/main";
    }




    @GetMapping("/write")
    public String write(Model model){
        BoardForm boardForm = new BoardForm();

        model.addAttribute("boardForm",boardForm);

        return "board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid BoardForm boardForm , Errors errors){

        if(errors.hasErrors()){
            return "board/write";
        }

        writeService.write(boardForm);
        return "redirect:/board/list";
    }


///////////////List Mappping


    @GetMapping("/list")
    public String list(Model model){

        model.addAttribute("list",writeService.read());


        return "board/list";
    }




    @GetMapping("/list/{id}")
    public String board(@PathVariable Long id,Model model){
        Board board = boardDao.get(id);

        model.addAttribute("listId",board);

        return "board/boardContent";
    }




    // 현재 게시글 삭제 후 리스트로 돌아감
    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Long id){

        boardDao.delete(id);

        return "redirect:/board/list";
    }










}
