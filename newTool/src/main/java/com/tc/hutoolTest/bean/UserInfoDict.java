package com.tc.hutoolTest.bean;

import java.util.List;

public class UserInfoDict {
    private Integer id;
    private String photoPath;
    private String realName;
    private List examInfoDict;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List getExamInfoDict() {
        return examInfoDict;
    }

    public void setExamInfoDict(List examInfoDict) {
        this.examInfoDict = examInfoDict;
    }
}
