package com.lagou.bean;

public class Score {
    private Integer math;
    private Integer chinese;
    private Integer english;

    public Score() {
    }

    public Score(Integer math, Integer chinese, Integer english) {
        this.math = math;
        this.chinese = chinese;
        this.english = english;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }
}
