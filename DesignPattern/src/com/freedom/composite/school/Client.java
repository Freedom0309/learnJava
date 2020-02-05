package com.freedom.composite.school;

/**
 * @author liuf
 * date: 2020-02-05
 */
public class Client {
    public static void main(String[] args) {

        OrganizationComponent qUniversity = new University("清华大学", "大雪纷飞");
        OrganizationComponent pekingUniversity = new University("北京大学", "Peking");

        OrganizationComponent computerCollege = new College("计算机学院", "计算机");
        OrganizationComponent chemistryCollege = new College("化工学院", "化学、高分子");



        qUniversity.addComponent(computerCollege);
        computerCollege.addComponent(new Department("计算机科学与技术", "计算机"));
        computerCollege.addComponent(new Department("信息工程", "信息"));
        qUniversity.addComponent(chemistryCollege);
        chemistryCollege.addComponent(new Department("化学", "化学"));
        chemistryCollege.addComponent(new Department("高分子", "材料"));
        qUniversity.print();

    }
}
