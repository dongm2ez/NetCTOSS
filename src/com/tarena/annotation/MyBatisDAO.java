package com.tarena.annotation;

/**
 * 自定义注解，用于标识DAO组件。
 * MapperScannerConfigurer会自动扫描带有此注解的类，
 * 然后实例化对象，放入Spring容器中。
 * 注：该注解是自定义的注解，名称随意。
 */
public @interface MyBatisDAO {

}
