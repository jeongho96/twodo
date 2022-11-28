package com.f6.twodo.vo;

import java.time.LocalDateTime;

public class Blog {
    Integer id;
    String title;
    String content;
    String orifilename;
    String filename;
    String locationtag;
    Integer rank;
    LocalDateTime insertdate;
    LocalDateTime modifydate;


    public Blog(Integer id, String title, String content, String orifilename, String filename,
                String locationtag, Integer rank, LocalDateTime insertdate,LocalDateTime modifydate) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.orifilename = orifilename;
        this.filename = filename;
        this.locationtag = locationtag;
        this.rank = rank;
        this.insertdate = insertdate;
        this.modifydate = modifydate;


    }
}
