package com.ll.exam;

import com.ll.exam.App;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    void 파일에_객체를_저장() {
        Util.json.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1,"명언1","작가1");
        Util.file.saveToFile("test_data/1.json",wiseSaying.toJson());
        String rs = Util.file.readFromFile("test_data/1.json","");
        assertEquals(wiseSaying.toJson(),rs);
    }
    @Test
    void 파일에_내용쓰기() {
        Util.json.mkdir("test_data");
        Util.file.saveToFile("test_data/1.json","내용\n내용");
        String rs = Util.file.readFromFile("test_data/1.json","");
        assertEquals("내용\n내용",rs);
    }
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
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_등록_목록() {
        Scanner sc = TestUtil.genScanner("""
                등록
                명언1
                작가1
                등록
                명언2
                작가2
                목록
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("----------------------"));
        assertTrue(rs.contains(("2 / 작가2 / 명언2")));
        assertTrue(rs.contains("1 / 작가1 / 명언1"));
    }
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_등록_삭제() {
        Scanner sc = TestUtil.genScanner("""
                등록
                작가1
                명언1
                등록
                작가2
                명언2
                삭제?id=1
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        assertTrue(rs.contains("1번 명언이 삭제 되었습니다."));
    }
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_등록_삭제_예외처리() {
        Scanner sc = TestUtil.genScanner("""
                등록
                작가1
                명언1
                등록
                작가2
                명언2
                목록
                삭제?id=1
                삭제?id=1
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        assertTrue(rs.contains("1번 명언은 존재하지 않습니다."));
    }
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_등록_삭제_수정() {
        Scanner sc = TestUtil.genScanner("""
                등록
                명언1
                작가1
                등록
                명언2
                작가2
                목록
                삭제?id=1
                삭제?id=1
                수정?id=2
                현재와 자신을 사랑하라.
                홍길동
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        assertTrue(rs.contains("명언(기존) : 명언2"));
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가(기존) : 작가2"));
        assertTrue(rs.contains("작가(기존) : "));
    }
}
