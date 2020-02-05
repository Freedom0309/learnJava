package com.freedom.composite;

/**
 * 叶子对象，叶子对象不再包含其他对象
 *
 * @author liuf
 * date: 2020-02-05
 */
public class Leaf extends Component {
    private String name = "";
    /**
     * 示意方法，子叶子对象的操作
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println("叶子对象的操作" + preStr);
    }
}
