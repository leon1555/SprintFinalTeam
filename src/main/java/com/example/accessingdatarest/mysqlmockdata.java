package com.example.accessingdatarest;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class mysqlmockdata {

    @Id
    private Long id;

    private String carmake;
    private String carmodel;
    private String color;
    private String gender;

}