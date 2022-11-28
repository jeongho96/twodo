package com.f6.twodo.vo;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
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
    String strfilename;
    String locationtag;
    Integer star;
    String starDisp;
    Date insertdate;
    Date modifydate;

    public Blog(Integer id,String secret, String title, String content, String orifilename, String filename,
                String locationtag, Integer star, Date insertdate,Date modifydate) {

        this.id = id;
        this.secret = secret;
        this.title = title;
        this.content = content;
        this.orifilename = orifilename;
        this.filename = filename;
        this.locationtag = locationtag;
        this.star = star;
        this.insertdate = insertdate;
        this.modifydate = modifydate;
        makeData();
    }
    public Blog(String secret, String title, String content, String orifilename, String filename,
                String locationtag, Integer star) {
        this.secret = secret;
        this.title = title;
        this.content = content;
        this.orifilename = orifilename;
        this.filename = filename;
        this.locationtag = locationtag;
        this.star = star;
        this.insertdate = insertdate;
        this.modifydate = modifydate;
        makeData();
    }
    public Blog(Integer id, String title, String content, String locationtag) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.locationtag = locationtag;
        makeData();
    }
    private void makeData() {
        strfilename = filename;
        if(filename == null) {
            strfilename = "empty";
        }

        if(star != null) {
            starDisp = "★";
            for (int i = 0; i < star - 1; i++) {
                starDisp =starDisp + "★";
            }
        }

        System.out.println("strfilename:" + strfilename);
    }
}
