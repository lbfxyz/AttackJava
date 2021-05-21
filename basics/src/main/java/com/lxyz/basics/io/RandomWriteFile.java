package com.lxyz.basics.io;

import java.io.*;

/**
 * @author lbf
 * @date 2021/5/18
 */
public class RandomWriteFile {

    public static final String BASIC_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    public void write(String fileName) {

        File file = new File("G:/");
        try {
            File newFile = new File(file, fileName);
            if (newFile.createNewFile()) {

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));


                writer.write(BASIC_CHAR);

                writer.flush();
                writer.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        RandomWriteFile file = new RandomWriteFile();

        for (int i = 0; i < 10000; i++) {
            String fileName = System.currentTimeMillis() + i * 100 + ".txt";

            file.write(fileName);

        }

    }


}
