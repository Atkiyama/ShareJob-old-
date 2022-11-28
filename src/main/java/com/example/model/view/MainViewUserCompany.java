package com.example.model.view;

import lombok.Data;

@Data
public class MainViewUserCompany {
   
    public MainViewUserCompany(String name, String memo) {
        super();
        this.name = name;
        this.memo = memo;
    }
    private String name;
    private String memo;
}
