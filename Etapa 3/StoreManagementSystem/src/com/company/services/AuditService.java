package com.company.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {
    private static AuditService ourInstance = new AuditService();

    public static AuditService getInstance() {
        return ourInstance;
    }

    private String historyPath = "./files/HistoryData.csv";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy HH:mm ");

    private AuditService() {
    }

    public void addActivity (String eventName, Date timestamp) {

        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(historyPath,true));

            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append(eventName)
                    .append(",").append(dateFormat.format(timestamp)).append(",").append(Thread.currentThread().getName());

            printWriter.println();
            printWriter.print(stringBuilder.toString());

            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
