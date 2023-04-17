package org.koreait.project.models.boards;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardSaveValidator validator;
    private final BoardDao boardDao;

    public void save(Board board){
        save(board, null);
    }




    public void save(Board board, Errors errors) {

        if (errors != null && errors.hasErrors()) { // Bean Validation 검증을 진행하고 검증 실패한 경우
            return;
        }

        validator.check(board);

        boardDao.insert(board);

    } // save


}




