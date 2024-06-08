package com.example;

import java.io.IOException;
import java.io.InputStream;

public class Process1 {
    public static void main(String[] args) throws IOException {
        try{
            //ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "javac src/main/java/com/example/App.java");
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "src/main/java", "com.example.App");

            // this allows to execute external commands within your own application


            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();

            int val;
            while((val = inputStream.read()) != -1){
                System.out.print((char)val);
            }

            int exitCode = process.waitFor();

            // Print the exit code
            System.out.println("Process exited with code: " + exitCode);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
