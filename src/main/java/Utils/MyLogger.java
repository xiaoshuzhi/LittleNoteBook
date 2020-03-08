package Utils;

import java.util.Date;

public class MyLogger {
    private String classname;
    public MyLogger(String classname){
        this.classname = classname;
    }

    public void info(String info, String infovalue) {
        System.out.println("Info "+new Date(System.currentTimeMillis())+" "+classname +" "+info+" "+infovalue);
    }
}
