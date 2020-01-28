package com.expleo.webcm.entity.expleodb;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "Solution")
@Table(name = "solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_solution")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_record")
    private Record record;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_user")
    private UserExpleo userExpleo;

    @Column(name="Solutie")
    private String solutie;

    @Column(name="Data")
    private String date;

    @Column(name="Data_update")
    private String date_update;

    public Solution() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getSolutie() {
        return solutie;
    }

    public void setSolutie(String solutie) {
        this.solutie = solutie;
    }

    public UserExpleo getUserExpleo() {
        return userExpleo;
    }

    public void setUserExpleo(UserExpleo userExpleo) {
        this.userExpleo = userExpleo;
    }

    public String getDate() {
        return date;
    }

    public Date getDate1() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return dateFormat.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }
}
