package com.hjj.judgefairysandbox.security;

import java.security.Permission;

public class DefaultSecurityManager extends SecurityManager{

    /**
     * 检查所有权限
     * @param perm   the requested permission.
     */
    @Override
    public void checkPermission(Permission perm) {
        System.out.println("权限异常：" + perm.getActions());
    }
}
