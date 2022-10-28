package com.tc.hutoolTest.bean;

import java.util.UUID;

public class SubPerson extends Person {
    public static final String SUBNAME = "TEST";

    private UUID id;
    private String subName;
    private Boolean isSlow;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Boolean getSlow() {
        return isSlow;
    }

    public void setSlow(Boolean slow) {
        isSlow = slow;
    }


    @Override
    public String toString() {
        return "SubPerson{" +
                "id=" + id +
                ", subName='" + subName + '\'' +
                ", isSlow=" + isSlow +
                "} " + super.toString();
    }
}
