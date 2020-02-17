package com.freedom.memento.game;

/**
 * @author liuf
 * date: 2020-02-17
 */
public class Client {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("战斗前的状态:");
        gameRole.display();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("战斗开始:");
        gameRole.setVit(50);
        gameRole.setDef(50);
        gameRole.display();

        System.out.println("从备忘录恢复状态:");
        gameRole.recoveryGameRoleFromMemento(caretaker.getMemento());
        gameRole.display();

    }
}
