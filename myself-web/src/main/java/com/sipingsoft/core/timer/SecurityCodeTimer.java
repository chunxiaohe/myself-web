package com.sipingsoft.core.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author HeChunXiao
 * @since 2018-11-02 下午 3:26
 */
public class SecurityCodeTimer {


    @Scheduled(cron = "0 0 0 1/1 * ?")
    public void deletePic(){
        try {
            String path = ResourceUtils.getURL("classpath:").getPath()+"/static/codeImage/";
            File file = new File(path);
            if (file.exists()){
                String[] fileName = file.list();
                for(String picName:fileName){
                    File f = new File(path,picName);
                    if (f.exists() && f.isFile()){
                        f.delete();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

