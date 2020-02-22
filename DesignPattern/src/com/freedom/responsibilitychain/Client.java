package com.freedom.responsibilitychain;

/**
 * @author liuf
 * date: 2020-02-22
 */
public class Client {
    public static void main(String[] args) {
        PurchaseRequest request = new PurchaseRequest(1, 31000, 1);
        //创建审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("系主任");
        Approver collegeApprover = new CollegeApprover("院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");
        //设置相应的下一个处理者
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(request);

    }
}
