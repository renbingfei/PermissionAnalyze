import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.rbf.model.Apk;
import com.rbf.model.Apks;
import com.rbf.model.PermissionCombination;
import com.rbf.model.PotentialThreatingPermission;
import com.rbf.util.CheckFilePostFix;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static PermissionCombination pc  = new PermissionCombination();

    public static void main(String[] args) {
        Apks apks = init(args);
        //print weight result for Permission Combinations
        System.out.println(JSON.toJSONString(pc.getInternet()));
        System.out.println(JSON.toJSONString(pc.getSMS()));

        //print matching degree for each apk
        for(Apk apk : apks.getApks()){
            System.out.println(apk.toString());
        }
    }

    /**
     *
     * @param args
     * @return
     */
    public static Apks init(String[] args){
        Apks apks = new Apks();
        if(args!=null && args.length == 1){
            String rootPath = args[0];
            File file = new File(rootPath);
            if(file.exists() && file.isDirectory()){
                boolean result = analyzeFiles(apks,file.listFiles());
                if(result){
                    calculateWeight(apks);
                }
            }
            return apks;
        }
        System.out.println("请输入正确的apk所在文件夹路径");
        return apks;
    }
    public static boolean analyzeFiles(Apks apks, File[] files){
        StringBuffer cmd;
        List<Apk> tmp = new ArrayList<Apk>();
        for(File file: files){
            //检查file的格式
            if(file.isFile() && CheckFilePostFix.check("apk",file)){
                cmd = new StringBuffer("");
                InputStream in = null;
                try{
                    cmd.append("tool/aapt.exe d permissions " + '"' + file.getAbsolutePath() + '"');
                    Process pro = Runtime.getRuntime().exec(cmd.toString());
                    in = pro.getInputStream();
                    BufferedReader read = new BufferedReader(new InputStreamReader(in));
                    String result = null;
                    Apk apk = new Apk();
                    List<String> permissions = new ArrayList<String>();
                    while((result = read.readLine())!=null){
                        int pkIndex = result.indexOf("package:");
                        int pmIndex = result.indexOf("uses-permission: name=");
                        if(pkIndex>=0){
                            apk.setPackageName(result.substring(pkIndex+8).trim());
                            apk.setDegree(0);
                        }
                        if(pmIndex>=0){
                            permissions.add(result.substring(pmIndex+23,result.length()-1).trim());
                        }
                    }
                    apk.setPermissions(permissions);
                    tmp.add(apk);
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
            }
        }
        apks.setApks(tmp);
        return true;
    }

    public static void calculateWeight(Apks apks){
        pc.init();
        for(Apk apk : apks.getApks()){
            //calculate PermissionsCombination weight;
//            System.out.println(JSON.toJSON(apk).toString());
            //check if apk has internet permission
            if(apk.getPermissions().contains("android.permission.INTERNET")){
                for(PotentialThreatingPermission ptp : pc.getInternet()){
                    if(apk.getPermissions().contains(ptp.getPermissions())){
                        ptp.setWeight(ptp.getWeight()+1);
                        apk.setDegree(apk.getDegree()+1);
                    }
                }
            }

            //check if apk has sms permission
            if(apk.getPermissions().contains("android.permission.SEND_SMS")){
                for(PotentialThreatingPermission ptp : pc.getSMS()){
                    if(apk.getPermissions().contains(ptp.getPermissions())){
                        ptp.setWeight(ptp.getWeight()+1);
                        apk.setDegree(apk.getDegree()+1);
                    }
                }
            }
        }
    }
}
