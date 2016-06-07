package com.rbf.util;

import java.io.File;
/**
 * Created by RenBF on 2016/6/6.
 */
public class CheckFilePostFix {

    /**
     * 判断文件后缀名是否为指定的
     * @param postFix
     * @param file
     * @return
     */
    public static boolean check(String postFix, File file){
        return postFix.equals(file.getName().substring(file.getName().lastIndexOf(".")+1));
    }
}
