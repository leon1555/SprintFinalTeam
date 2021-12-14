package com.keyin.team3.model.postgres;

import lombok.Getter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Entity
public class PostGresMockData {
    @Id
    private int id;
    @Column
    private String buzzwords;
    @Column
    private String appnames;
    @Column
    private String companynames;
    @Column
    private String useragent;

}
