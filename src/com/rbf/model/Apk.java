package com.rbf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RenBF on 2016/6/7.
 */
public class Apk {
    String packageName;
    List<String> permissions;
    int degree;

    @Override
    public String toString() {
        return "Apk{" +
                "degree=" + degree +
                ", packageName='" + packageName + '\'' +
                '}';
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Apk(){
        packageName = "";
        permissions = new ArrayList<String>();
    }

    public Apk(String packageName, List<String> permissions){
        this.packageName = packageName;
        this.permissions = permissions;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
