package com.rbf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RenBF on 2016/6/7.
 */
public class Apks {
    List<Apk> apks;

    public Apks(){
        apks = new ArrayList<Apk>();
    }
    public Apks(List<Apk> apks){
        this.apks = apks;
    }

    public List<Apk> getApks() {
        return apks;
    }

    public void setApks(List<Apk> apks) {
        this.apks = apks;
    }
}
