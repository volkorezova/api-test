package com.api.domaine.attach;

import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by tatyanavolkorezova on 02.05.17.
 */
public class AttachLogs {

public void attach(){







}
    @Attachment(value = "Request log")
    public static byte[] request(String log){
        return log.getBytes();
    }

    @Attachment (value = "Response log")
    public static byte[] response(String log){
        return log.getBytes();
    }




}
