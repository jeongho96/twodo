package com.f6.twodo.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Blog {
    Integer id;

    String secret;
    String title;
    String content;
    String orifilename;
    String filename;
    String locationtag;
    Integer rank;
    Date insertdate;
    Date modifydate;


    public Blog(Integer id,String secret, String title, String content, String orifilename, String filename,
                String locationtag, Integer rank, Date insertdate,Date modifydate) {

        this.id = id;
        this.secret = secret;
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
