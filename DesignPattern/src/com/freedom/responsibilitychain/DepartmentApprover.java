package com.freedom.responsibilitychain;

/**
 * @author liuf
 * date: 2020-02-22
 */
public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println(name + " 可以处理此请求，编号是：" + purchaseRequest.getId());
        }else{
            this.approver.processRequest(purchaseRequest);
        }
    }
}
