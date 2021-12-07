package com.example.accessingdatarest;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Entity
public class mock_data {
    @Id
    private int id;
    @Column
    private String buzzwords;
    @Column
    private String appNames;
    @Column
    private String companyNames;
    @Column
    private String userAgent;

}
