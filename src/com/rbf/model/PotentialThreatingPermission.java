package com.rbf.model;

/**
 * Created by RenBF on 2016/6/7.
 * permission model: consists of name, leakageway, desc, and weight (which will be calculated in Main.java
 */
public class PotentialThreatingPermission {
    String permissions;
    String leakageWay;
    String desc;
    int weight;  //important weight

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getLeakageWay() {
        return leakageWay;
    }

    public void setLeakageWay(String leakageWay) {
        this.leakageWay = leakageWay;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
