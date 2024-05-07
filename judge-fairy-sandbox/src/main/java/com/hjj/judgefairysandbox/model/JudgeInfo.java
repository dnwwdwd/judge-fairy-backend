package com.hjj.judgefairysandbox.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 判题信息
 */
@Data
public class JudgeInfo implements Serializable {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存（KB）
     */
    private Long memory;

    /**
     * 消耗时间（ms）
     */
    private Long time;

    private static final long serialVersionUID = 1L;
}
