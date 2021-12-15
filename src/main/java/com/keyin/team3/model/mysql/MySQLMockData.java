package com.keyin.team3.model.mysql;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "mysqlmockdata")
public class MySQLMockData {

    @Id
    private Long id;

    private String carmake;
    private String carmodel;
    private String color;
    private String gender;

}