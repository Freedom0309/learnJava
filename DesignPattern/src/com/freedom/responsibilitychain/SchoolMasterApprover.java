package com.freedom.responsibilitychain;

/**
 * @author liuf
 * date: 2020-02-22
 */
public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 30000) {
            System.out.println("此请求由" + name + "处理，请求编号是：" + purchaseRequest.getId());
        } else {
            approver.processRequest(purchaseRequest);
        }

    }
}
