package com.ll.exam;


import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository;
    WiseSayingService(){
        wiseSayingRepository = new WiseSayingRepository();
    }


    public int write(String content, String author) {
        return wiseSayingRepository.write(content,author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }
    WiseSaying findById(int rmnum) {

        return wiseSayingRepository.findByID(rmnum);
    }

    public void remove(WiseSaying findwiseSaying) {
        wiseSayingRepository.remove(findwiseSaying);
        return;
    }

    public void modify(int mdnum, String content, String author) {
        wiseSayingRepository.modify(mdnum,content,author);

        return;
    }
}
