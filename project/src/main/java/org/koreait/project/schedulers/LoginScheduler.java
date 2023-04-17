package org.koreait.project.schedulers;

import lombok.extern.java.Log;
import org.koreait.project.models.boards.Board;
import org.koreait.project.models.boards.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@Log
public class LoginScheduler {


    @Autowired
    private BoardDao boardDao;


    @Scheduled(cron = "*/5 * * * * *")
    public void logging(){
        log.info("01시마다 실행");

//        List str  = boardDao.getList();
//
//         long count = str.stream().filter(s-> (s == "regdt")).count();
//
//        System.out.println(count);





    }



}
