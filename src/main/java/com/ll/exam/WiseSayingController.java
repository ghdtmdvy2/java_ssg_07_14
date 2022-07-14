package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    public WiseSaying wiseSaying;
    public List<WiseSaying> wiseSayings;
    public int wiseSayingid;
    WiseSaying findwiseSaying;
    Scanner sc;
    WiseSayingController(Scanner sc){
        wiseSayingid = 0;
        wiseSayings = new ArrayList<>();
        this.sc = sc;
    }

    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        wiseSayingid++;
        wiseSaying = new WiseSaying(wiseSayingid,content,author);
        wiseSayings.add(wiseSaying);
        System.out.println(wiseSayingid+"번 명언이 등록 되었습니다.");
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = wiseSayings.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s",wiseSayings.get(i).id,wiseSayings.get(i).author,wiseSayings.get(i).content);
        }
    }

    public void remove(Rq rq) {
        int rmnum = rq.getIntParam("id",0);
        findwiseSaying = findById(rmnum);

        if (findwiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.",rmnum);
            return;
        }
        wiseSayings.remove(findwiseSaying);
        System.out.printf("%d번 명언이 삭제 되었습니다.",rmnum);
    }

    public void modify(Rq rq) {
        int mdnum = rq.getIntParam("id",0);
        findwiseSaying = findById(mdnum);
        if (findwiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.",mdnum);
            return;
        }
        System.out.printf("명언(기존) : %s", findwiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();
        findwiseSaying.content = content;
        System.out.printf("작가(기존) : %s", findwiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();
        findwiseSaying.author = author;
    }
    private WiseSaying findById(int rmnum) {
        for(int i = wiseSayings.size()-1; i>=0; i--){
            if (wiseSayings.get(i).id == rmnum) {
                return wiseSayings.get(i);
            }
        }
        return null;
    }

}
