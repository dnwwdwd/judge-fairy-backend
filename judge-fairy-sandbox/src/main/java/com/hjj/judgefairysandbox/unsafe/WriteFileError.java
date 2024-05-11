package com.hjj.judgefairysandbox.unsafe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * 读服务器文件
 */
public class WriteFileError {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/木马程序.bat";
        String dangerProgram = "java -version 2>&1";
        Files.write(Paths.get(filePath), Arrays.asList(dangerProgram));
        System.out.println("写木马成功，你完了哈哈");
    }
}
