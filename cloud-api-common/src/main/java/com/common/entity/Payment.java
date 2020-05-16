package com.common.entity;

import lombok.Data;

import java.io.Serializable;

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
