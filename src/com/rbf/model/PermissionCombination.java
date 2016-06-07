package com.rbf.model;

import com.rbf.config.Res;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RenBF on 2016/6/7.
 * combinations of permissions: divided by leakage way, we get two categories Internet and SMS
 * through analyzing malware apps, we can assign different weight value to each combination according to its matching degree.
 */
public class PermissionCombination {

    List<PotentialThreatingPermission> Internet;   //potential threating combinations of permissions, whose leakage way is internet
    List<PotentialThreatingPermission> SMS;        //potential threating combinations of permissions, whose leakage way is short message;

    public List<PotentialThreatingPermission> getInternet() {
        return Internet;
    }

    public void setInternet(List<PotentialThreatingPermission> internet) {
        Internet = internet;
    }

    public List<PotentialThreatingPermission> getSMS() {
        return SMS;
    }

    public void setSMS(List<PotentialThreatingPermission> SMS) {
        this.SMS = SMS;
    }

    /**
     * initial variables
     */
    public void init(){
        Internet = new ArrayList<PotentialThreatingPermission>();
        SMS = new ArrayList<PotentialThreatingPermission>();

        PotentialThreatingPermission ptp;
        for(int i=0;i< Res.internetPermissions.length;i++){
            ptp = new PotentialThreatingPermission();
            ptp.setDesc(Res.internetDescs[i]);
            ptp.setLeakageWay("android.permission.INTERNET");
            ptp.setWeight(1);
            ptp.setPermissions("android.permission."+Res.internetPermissions[i]);
            Internet.add(ptp);
        }

        for(int i=0;i<Res.smsPermissions.length;i++){
            ptp = new PotentialThreatingPermission();
            ptp.setDesc(Res.smsDescs[i]);
            ptp.setPermissions("android.permission."+Res.smsPermissions[i]);
            ptp.setWeight(1);
            ptp.setLeakageWay("android.permission.SEND_SMS");
            SMS.add(ptp);
        }
    }
}
