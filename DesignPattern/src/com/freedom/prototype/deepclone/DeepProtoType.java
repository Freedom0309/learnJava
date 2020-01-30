package com.freedom.prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {
    private static final long serialVersionUID = -209459424098144311L;
    private String name;
    private DeepCloneToTarget deepCloneToTarget;

    public DeepProtoType() {
        super();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", deepCloneToTarget=" + deepCloneToTarget +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCloneToTarget getDeepCloneToTarget() {
        return deepCloneToTarget;
    }

    public void setDeepCloneToTarget(DeepCloneToTarget deepCloneToTarget) {
        this.deepCloneToTarget = deepCloneToTarget;
    }

    /**
     * 深拷贝 - 方式1使用clone方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //完成对基本数据类型的拷贝
        deep = super.clone();
        //对引用类型的属性，进行单独的拷贝
        DeepProtoType deepProtooType = (DeepProtoType) deep;
        deepProtooType.deepCloneToTarget = (DeepCloneToTarget) deepCloneToTarget.clone();
        return deepProtooType;
    }

    /**
     * 使用序列化进行深拷贝
     * @return
     */
    public Object deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType cloneObj = (DeepProtoType) ois.readObject();

            return cloneObj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
