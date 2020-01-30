package com.freedom.prototype.deepclone;

import java.io.Serializable;

/**
 *
 */
public class DeepCloneToTarget implements Cloneable, Serializable {
    private static final long serialVersionUID = -5777573932630273644L;
    private String name;

    public DeepCloneToTarget(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DeepCloneToTarget{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
