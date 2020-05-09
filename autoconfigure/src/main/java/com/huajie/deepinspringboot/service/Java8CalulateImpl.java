package com.huajie.deepinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;

/**
 * Java 8 Stream 实现
 */
@Profile("Java8")
@Service
public class Java8CalulateImpl implements CalculateService {

    @Override
    public Integer sum(Integer... numbers) {
        System.out.println("Java8 实现");
        return Stream.of(numbers).collect(summingInt(Integer::intValue));
    }

}
