package com.hjj.judgefairysandbox.utils;

import cn.hutool.core.util.StrUtil;
import com.hjj.judgefairysandbox.model.ExecuteMessage;
import javafx.scene.paint.Stop;
import org.springframework.util.StopWatch;

import java.io.*;

public class ProcessUtils {
    /**执行进程并获取信息
     *
     * @param runProcess
     * @param operationName
     * @return
     */
    public static ExecuteMessage runProcessAndGetMessage(Process runProcess, String operationName) {
        StringBuilder stringBuilder = new StringBuilder();
        ExecuteMessage executeMessage = new ExecuteMessage();
        try {
            // 等待程序执行，获取错误码
            int exitValue = runProcess.waitFor();
            // 正常退出
            if (exitValue == 0) {
                System.out.println(operationName + "成功");
                // 分批获取进程的正常输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                // 逐行读取
                String compileOutputLine;
                while ((compileOutputLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(compileOutputLine);
                }
                executeMessage.setMessage(stringBuilder.toString());
            } else {
                // 异常退出
                System.out.println(operationName + "失败，错误码：" + exitValue);
                // 分批获取进程的错误输出
                BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                // 逐行读取
                String compileOutputLine;
                while ((compileOutputLine = errorBufferedReader.readLine()) != null) {
                    stringBuilder.append(compileOutputLine);
                }
                executeMessage.setErrorMessage(stringBuilder.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return executeMessage;
    }

    /**
     * 执行交互式进程获取信息
     */
    public static ExecuteMessage runInterProcessAndGetMessage(Process runProcess, String operationName, String args) {
        StringBuilder stringBuilder = new StringBuilder();
        ExecuteMessage executeMessage = new ExecuteMessage();
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            // 向控制台输入程序
            OutputStream outputStream = runProcess.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            String[] s = args.split(" ");
            outputStreamWriter.write(StrUtil.join("\n", s) + "\n");
            // 相当于按了回车，执行输入的发送
            outputStreamWriter.flush();

            InputStream inputStream = runProcess.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // 逐行读取
            String compileOutputLine;
            while ((compileOutputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(compileOutputLine);
            }
            executeMessage.setMessage(stringBuilder.toString());
            stopWatch.stop();
            executeMessage.setTime(stopWatch.getLastTaskTimeMillis());
            // 记得资源的回收，否则会卡死
            outputStream.close();
            outputStreamWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return executeMessage;
    }
}
