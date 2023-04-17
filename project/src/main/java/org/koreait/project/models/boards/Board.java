package org.koreait.project.models.boards;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {

    private Long Id;
    private String subject;
    private String content;



    private LocalDateTime regDt;
    private LocalDateTime modDt;


}
