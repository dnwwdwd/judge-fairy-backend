package com.hjj.judgefairysandbox.unsafe;

import cn.hutool.core.io.FileUtil;
import com.hjj.judgefairysandbox.security.CustomSecurityManager;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestSecurityManager {
    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());
        List<String> list = FileUtil.readLines("D:\\projects\\judge-fairy-sandbox\\src\\main\\resources\\application.yml",
                StandardCharsets.UTF_8);
        System.out.println(list);
    }
}
