package com.f6.twodo.vo;

import lombok.Data;

import java.util.Date;

// Todo 용 Value Object
@Data
public class ToDo {
    Integer id;         // PK
    String subject;     // 일정제목
    String detail;      // 일정내용
    Date target_date;   // 마감일시
    String done;        // 완료여부 (Y면 완료, N면 미완료)
    String must;        // 중요여부 (Y면 중요, N면 일반)
    Date insert_date;   // 등록일시
    Date modify_date;   // 수정일시

    public ToDo(String _subject, String _detail, Date _target_date) {
        this.subject = _subject;
        this.detail = _detail;
        this.target_date = _target_date;
    }
}
