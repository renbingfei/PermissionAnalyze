package com.rbf.config;

/**
 * Created by RenBF on 2016/6/7.
 * certain permissions.
 * Given a number of apks, resolve them, and find which apk contains these permissions, then calculate their weight of combinations of PotentialThreatingPermission
 */
public class Res {
    public static String[] internetPermissions = {"RECORD_AUDIO","RECORD_VIDEO","CAMERA","ACCESS_FINE_LOCATION","ACCESS_COARSE_LOCATION","READ_CALENDAR","READ_EXTERNAL_STORAGE","READ_HISTORY_BOOKMARKS","READ_LOGS","READ_SMS","READ_CONTACTS",
    "READ_PHONE_STATE","PROCESS_OUTGOING_CALLS","READ_OWNER_DATA"};

    public static String[] smsPermissions = {"RECEIVE_MMS","RECEIVE_SMS","WRITE_SMS"};

    public static String[] internetDescs = {"Application may record audio, and send audio data through internet secretly.",
                                            "Application may record video, and send video data through internet secretly.",
                                            "Application may take a picture, and send it through internet secretly.",
                                            "Application may access fine location of users, and send it through internet secretly.",
                                            "Application may access coarse location of users, and send it through internet secretly.",
                                            "Application may read user’s calendar data, and send it through internet secretly.",
                                            "Application may read data of external storage, and send it through internet secretly.",
                                            "Application may read users history bookmarks, and send it through internet secretly.",
                                            "Application may read system log files, and sent them through internet secretly.",
                                            "Application may read SMS messages, and send them through internet secretly.",
                                            "Application may read user’s contact data, and send them through internet secretly.",
                                            "Application may obtain phone number, IMSI data, and send them through internet secretly.",
                                            "Application may monitor, modify, or abort outgoing calls, which will cause information leakage.",
                                            "Application may read owner’s data, and send them through internet secretly."};
    public static String[] smsDescs = {"Application may monitor incoming MMS messages, and send them through internet secretly.",
                                        "Application may monitor incoming SMS messages, and send them through internet secretly.",
                                        "Application may write SMS messages secretly, and send them through internet."};
}
