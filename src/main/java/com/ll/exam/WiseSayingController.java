package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    WiseSayingService wiseSayingService;
    Scanner sc;
    WiseSayingController(Scanner sc){
        wiseSayingService = new WiseSayingService();
        this.sc = sc;
    }

    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        int wrnum = wiseSayingService.write(content,author);
        System.out.println(wrnum+"번 명언이 등록 되었습니다.");
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();
        for(int i = wiseSayingList.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s",wiseSayingList.get(i).id,wiseSayingList.get(i).author,wiseSayingList.get(i).content);
        }
    }

    public void remove(Rq rq) {
        int rmnum = rq.getIntParam("id",0);
        WiseSaying findwiseSaying = wiseSayingService.findById(rmnum);

        if (findwiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.",rmnum);
            return;
        }
        wiseSayingService.remove(findwiseSaying);
        System.out.printf("%d번 명언이 삭제 되었습니다.",rmnum);
    }

    public void modify(Rq rq) {
        int mdnum = rq.getIntParam("id",0);
        WiseSaying findwiseSaying = wiseSayingService.findById(mdnum);
        if (findwiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.",mdnum);
            return;
        }
        System.out.printf("명언(기존) : %s", findwiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s", findwiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();
        wiseSayingService.modify(mdnum,content,author);
    }


}