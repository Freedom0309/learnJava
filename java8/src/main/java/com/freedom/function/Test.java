package com.freedom.function;

import jdk.internal.misc.JavaLangAccess;
import jdk.internal.misc.SharedSecrets;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description:
 *
 * @author: liufeng
 * @version: v1.0 2020/6/10 11:00
 * @since: v1.0
 */
class Test {

    public Test() {
        System.out.println("test");
    }
    private static String a = null;

    public static void main(String[] args) {

        assert  a == null;


        FileSystem fileSystem = FileSystems.getDefault();
        Set<String> strings = fileSystem.supportedFileAttributeViews();
        strings.stream().forEach(c->{
//            System.out.println(c);
        });
        FileSystemProvider provider = fileSystem.provider();

//        System.out.println(provider.getScheme());

        JavaLangAccess javaLangAccess = SharedSecrets.getJavaLangAccess();
        javaLangAccess.invalidatePackageAccessCache();
    }

}
