package com.test;

import java.io.File;
import java.text.DecimalFormat;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("/Users/anthony/Desktop/참고/F09_000000002823745IMG_1.jpg");

        String length = String.valueOf(file.length());
        System.out.println("length = " + length);
        String fileSize = byteCalculation(length);
        System.out.println("fileSize = " + fileSize);
        double size = Double.parseDouble(fileSize);
        System.out.println(size);
        if ( size >= 30l ) {
            System.out.println("크다");
        }
        else {
            System.out.println("작다");
        }
    }
    public static String getFileSize(String size)
    {
        String returnSize = "0";
        double changeSize = 0;
        long fileSize = 0;
        try{
            fileSize =  Long.parseLong(size);
            for ( int x=0 ; ( fileSize / (double) 1024 ) > 0 ; x++, fileSize /= (double) 1024 ) {
                changeSize = fileSize;
            }
            returnSize = String.valueOf(changeSize);
        } catch ( Exception ex){
            returnSize = "0.0";
        }
        return returnSize;
    }

    public static String byteCalculation(String bytes) {
        String retFormat = "0";
        Double size = Double.parseDouble(bytes);

        if (bytes != "0") {
            int idx = (int) Math.floor(Math.log(size) / Math.log(1024));
            DecimalFormat df = new DecimalFormat("#,###.##");
            double ret = ((size / Math.pow(1024, Math.floor(idx))));
            retFormat = df.format(ret);
        }
        return retFormat;
    }
}
