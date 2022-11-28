package com.f6.twodo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

// Todo 용 Value Object
@Getter
@Setter
public class ToDo {
    Integer id;         // PK
    String subject;     // 일정제목
    String detail;      // 일정내용
    Date  target_date;       // 마감일시
    String str_target_date; // 마감일시 (문자열표시)
    String done;        // 완료여부 (Y면 완료, N면 미완료)
    String state;        // 완료면 객체 있음, 미완이면 객체 없음

    String must;        // 중요여부 (Y면 중요, N면 일반)
    String muststate;   // 중요면 객체 있음, 안 중요이면 객체 없음
    Date  insert_date;   // 등록일시
    Date modify_date;   // 수정일시

    public ToDo(Integer id, String subject, String detail, Date target_date, String done, String must, Date insert_date, Date modify_date) {
        this.id = id;
        this.subject = subject;
        this.detail = detail;
        this.target_date = target_date;
        this.done = done;
        this.must = must;
        this.insert_date = insert_date;
        this.modify_date = modify_date;
        makeData();
    }

    public ToDo(String _subject, String _detail, Date _target_date) {
        this.subject = _subject;
        this.detail = _detail;
        this.target_date = _target_date;
        makeData();
    }

    private void makeData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   // yyyy-MM-dd HH:mm:ss
        this.str_target_date = formatter.format(this.target_date);
        System.out.println("makeData:done-" + done);
        if(done.equals("Y")) {
            state = "Y";
        }
        else {
            state = null;
        }
        if(must.equals("Y")) {
            muststate = "Y";
        }
        else {
            muststate = null;
        }
        System.out.println("makeData:state-" + state);
    }
}
