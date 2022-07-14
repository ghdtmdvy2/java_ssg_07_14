package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }
    public void run(){
        outer:
        while(true){
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()){
                case"종료":
                    break outer;
            }
        }
    }


}
