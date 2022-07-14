package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    public List<WiseSaying> wiseSayings;
    public int wiseSayingid;
    WiseSayingRepository(){
        wiseSayingid = 0;
        wiseSayings = new ArrayList<>();
    }

    public int write(String content, String author) {
        wiseSayingid++;
        wiseSayings.add(new WiseSaying(wiseSayingid,content,author));
        return wiseSayingid;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findByID(int rmnum) {
        for(int i = wiseSayings.size()-1; i>=0; i--){
            if (wiseSayings.get(i).id == rmnum) {
                return wiseSayings.get(i);
            }
        }
        return null;
    }

    public void remove(WiseSaying findwiseSaying) {
        wiseSayings.remove(findwiseSaying);
    }

    public void modify(int mdnum, String content, String author) {
        WiseSaying wiseSaying = findByID(mdnum);
        wiseSaying.author = author;
        wiseSaying.content = content;
    }
}
