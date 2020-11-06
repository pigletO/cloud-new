package com.pig1et.study.commonapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: pig1etO
 * @create: 2020-11-06 15:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Long age;

    private Long gender;
}

