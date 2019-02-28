package com.wupengchoy.mystudy.studydemo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String DIR_ROOT = "/Users/Jeremy/Documents/Code/parent/mystudy/target/classes/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = DIR_ROOT + fileName + ".class";
        try {
            byte[] bytes = readFileToByte(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] readFileToByte(String fileName) throws IOException {
        InputStream input = new FileInputStream(fileName);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] buf = new byte[4096];
        int byteRead = 0;
        while ((byteRead = input.read(buf)) != -1) {
            outputStream.write(buf, 0, byteRead);
        }
        return outputStream.toByteArray();
    }
}
