package com.freedom.lamda;

/**
 * 自定义Function接口
 * create in 2019/6/23 23:24 by Allen
 */
@FunctionalInterface
public interface ThreeFunctional< T, U, K, R> {

    R Apply(T t, U u, K k);
}
