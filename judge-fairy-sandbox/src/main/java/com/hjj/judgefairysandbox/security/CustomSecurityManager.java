package com.hjj.judgefairysandbox.security;

import java.security.Permission;

public class CustomSecurityManager extends SecurityManager{

    /**
     * 检查所有权限
     * @param perm   the requested permission.
     */
    @Override
    public void checkPermission(Permission perm) {

    }

    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("权限异常" + cmd);
    }

    @Override
    public void checkRead(String file, Object context) {
        throw new SecurityException("权限异常" + context);
    }

    @Override
    public void checkWrite(String file) {
        throw new SecurityException("权限异常" + file);
    }

    @Override
    public void checkDelete(String file) {
        System.out.println(file);
        if (file.contains("D:\\projects\\judge-fairy-sandbox")) {
            return;
        }
        throw new SecurityException("权限异常" + file);
    }

    @Override
    public void checkConnect(String host, int port) {
        throw new SecurityException("权限异常" + host + port);
    }
}
