package com.ll.exam;

import com.ll.exam.App;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료() {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));
    }
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_등록() {
        Scanner sc = TestUtil.genScanner("""
                등록
                작가1
                명언1
                등록
                작가2
                명언2
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
        assertTrue(rs.contains("1번 명언이 등록 되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록 되었습니다."));
    }
}
