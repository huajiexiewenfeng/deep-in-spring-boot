package com.huajie.deepinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Java 7 for 循环实现
 */
@Profile("Java7")
@Service
public class Java7CalulateImpl implements CalculateService {

    @Override
    public Integer sum(Integer... numbers) {
        System.out.println("Java7 实现");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
