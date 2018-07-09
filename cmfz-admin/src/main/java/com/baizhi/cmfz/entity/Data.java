package com.baizhi.cmfz.entity;

import java.util.List;

public class Data {
    //用户性别
    private List<String> sexes;
    //用户对应的数量
    private List<Integer> counts;

    @Override
    public String toString() {
        return "Data{" +
                "sexes=" + sexes +
                ", counts=" + counts +
                '}';
    }

    public List<String> getSexes() {
        return sexes;
    }

    public void setSexes(List<String> sexes) {
        this.sexes = sexes;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public Data() {

    }

    public Data(List<String> sexes, List<Integer> counts) {

        this.sexes = sexes;
        this.counts = counts;
    }
}
