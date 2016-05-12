package com.chaminda.neo4j.example;

import java.io.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StreamGobbler extends Thread {

    private static final Logger log = Logger.getLogger(StreamGobbler.class.getName());

    InputStream is;
    String type;

    public StreamGobbler(InputStream is, String name, boolean isDaemon) {
        this.is = is;
        this.type = name;
        setDaemon(isDaemon);
    }

    public void run() {
        try {
            BasicConfigurator.configure();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                log.info(type + ">" + line);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args){
        InputStream is;
        StreamGobbler gobbler;
        try {
            is = new FileInputStream("highScores.txt");
            gobbler = new StreamGobbler(is, "strName", false);
            gobbler.start();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

}