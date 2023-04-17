package org.koreait.project.models.boards;

import org.springframework.stereotype.Service;
import org.koreait.project.validator.CommonValidator;


@Service
public class BoardSaveValidator implements CommonValidator<Board> {


    @Override
    public void check(Board board) {

        String subject = board.getSubject();
        String content = board.getContent();

        if(subject == null || subject.isBlank()){
            throw new RuntimeException("제목을 입력해주세요");
        }

        if(content == null || content.isBlank()){
            throw new RuntimeException("내용을 입력해주세요");
        }

    } // check













//    @Override
//    public void check1(Board board) {
//        String subject = board.getSubject();
//        String content = board.getContent();
//        /** 제목 필수 항목 체크 */
//        if (subject == null || subject.isBlank()) {
//            throw new BoardValidationException("제목을 입력하세요.");
//        }
//
//        /** 내용 필수 항목 체크 */
//        if (content == null || content.isBlank()) {
//            throw new BoardValidationException("내용을 입력하세요.");
//        }
//    }

}
