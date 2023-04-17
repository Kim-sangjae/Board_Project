package org.koreait.project.models.boards;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardWriteService {

    // BoardDao 주입
    private final BoardDao boardDao;



//    public void setBoardDao(BoardDao boardDao){
//        this.boardDao = boardDao;
//    }

    public void write(BoardForm boardForm){
        Board board = new Board();
        board.setSubject(boardForm.getSubject());
        board.setContent(boardForm.getContent());

        boardDao.insert(board);
    }



    public List<Board> read(){

        List<Board> list = boardDao.getList();

        return list;
    }




}
