package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSaying wiseSaying;
    private List<WiseSaying> wiseSayings;
    private int wiseSayingid;
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingid = 0;
        wiseSayings = new ArrayList<>();
    }
    public void run(){
        System.out.println("== 명언 SSG ==");
        outer:
        while(true){
            System.out.print("명령)");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()){
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSayingid++;
                    wiseSaying = new WiseSaying(wiseSayingid,content,author);
                    wiseSayings.add(wiseSaying);
                    System.out.println(wiseSayingid+"번 명언이 등록 되었습니다.");
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(int i = wiseSayings.size()-1; i>=0; i--){
                        System.out.printf("%d / %s / %s",wiseSayings.get(i).id,wiseSayings.get(i).content,wiseSayings.get(i).author);
                    }
                    break;
                case "삭제":
                    int rmnum = rq.getIntParam("id",0);

                    wiseSayings.remove(rmnum-1);
                    System.out.printf("%d번 명언이 삭제 되었습니다.",rmnum);
                    break;
            }
        }
    }


}
