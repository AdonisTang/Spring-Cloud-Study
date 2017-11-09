package com.bornstone.crm.server.dao.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private String id;

    private String username;

    private String password;

    private Integer accountType;

    private Date updateTime;

    private Date createTime;
}
