package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSayingController wiseSayingController;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(sc);
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
                    wiseSayingController.write(rq);
                    break;
                case "목록":
                    wiseSayingController.list(rq);

                    break;
                case "삭제":
                    wiseSayingController.remove(rq);

                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
            }
        }
    }




}
