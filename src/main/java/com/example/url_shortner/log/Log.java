package com.example.url_shortner.log;

import java.io.File;
import java.io.FileWriter;



public class Log {
    public Log () {
        LogFile = new File("server.log");
        if (LogFile == null) {
            System.out.println("unable to create log file");

        }
        
    }

    public void WriteLogMessage (String msg) {
        try (FileWriter Write = new FileWriter(LogFile , true)) {
            Write.write(msg);
        } catch (Exception e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }

    private File LogFile;
    
}
