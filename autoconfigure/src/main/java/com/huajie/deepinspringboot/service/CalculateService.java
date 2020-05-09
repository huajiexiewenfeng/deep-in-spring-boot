package com.huajie.deepinspringboot.service;

/**
 * 计算服务
 */
public interface CalculateService {
    /**
     * 求和
     * @param numbers
     * @return
     */
    Integer sum(Integer... numbers);
}
