package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSaying wiseSaying;
    private int wiseSayingid;
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingid = 0;
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
                    break;
            }
        }
    }


}
