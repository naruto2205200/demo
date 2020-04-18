package com.example.model;

import java.util.List;

/**
 * @author naruto
 * @data 2019/1/30.
 */
public class SecondVo {

    private Integer classId;
    private List<User> userList;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
