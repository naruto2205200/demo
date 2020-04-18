package com.example.model;

import java.util.List;

/**
 * @author naruto
 * @data 2019/1/30.
 */
public class FirstVo {
    private Integer gradeId;
    private List<SecondVo> secondVoList;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public List<SecondVo> getSecondVoList() {
        return secondVoList;
    }

    public void setSecondVoList(List<SecondVo> secondVoList) {
        this.secondVoList = secondVoList;
    }
}
