package com.freedom.memento.game;

/**
 * @author liuf
 * date: 2020-02-17
 */
public class GameRole {
    private int vit;
    private int def;

    /**
     * 创建Memento，根据游戏角色的当前状态
     *
     * @return
     */
    public Memento createMemento() {
        return new Memento(this.vit, this.def);
    }

    /**
     * 从备忘录对象，恢复GameRole的状态
     *
     * @param memento
     */
    public void recoveryGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    /**
     * 显示当前游戏角色的状态
     */
    public void display() {
        System.out.println("游戏角色当前的攻击力：" + this.vit + ", 防御力：" + this.def);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
