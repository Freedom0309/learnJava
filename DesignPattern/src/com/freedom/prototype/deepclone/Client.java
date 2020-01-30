package com.freedom.prototype.deepclone;

public class Client {
    public static void main(String[] args) {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.setName("猫咪");
        deepProtoType.setDeepCloneToTarget(new DeepCloneToTarget("小黑"));

        System.out.println("原型：" + deepProtoType + " --- " + deepProtoType.getDeepCloneToTarget().hashCode());
        try {
            DeepProtoType clone = (DeepProtoType) deepProtoType.clone();
            System.out.println("clone进行深拷贝：" + clone + "=" + clone.getDeepCloneToTarget().hashCode());

            DeepProtoType deepClone = (DeepProtoType) deepProtoType.deepClone();
            System.out.println("clone进行深拷贝：" + deepClone + "=" + deepClone.getDeepCloneToTarget().hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
