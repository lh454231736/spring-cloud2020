package com.mytest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author lh
 * @Date 2020/5/14 10:20
 * @Version 1.0
 */
@Data
public class Payment implements Serializable {
    private static final long serialVersionUID = 6960673072228734210L;
    /**
     * id
     */
    private Long id;
    /**
     * 流水号
     */
    private String serial;
}
