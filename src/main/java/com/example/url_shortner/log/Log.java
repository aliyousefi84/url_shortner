package com.example.url_shortner.log;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





public class Log {
    public Log () {
        LogFile = new File("server.log");
        if (LogFile == null) {
            System.out.println("unable to create log file");
        }
        System.out.println("create log file in server.log");
        
    }

    public void WriteLogMessage (String msg,String... args) {
        try (FileWriter Write = new FileWriter(LogFile , true)) {
            LocalDateTime DateTime = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            String TimeFormat = DateTime.format(fmt);
            String msgFormat = String.format(msg, args);
            Write.write(TimeFormat + " " + msgFormat);
        } catch (Exception e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }

    private File LogFile;
    
}
