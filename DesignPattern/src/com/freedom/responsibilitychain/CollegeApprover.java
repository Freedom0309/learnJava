package com.freedom.responsibilitychain;

/**
 * @author liuf
 * date: 2020-02-22
 */
public class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 5000 && purchaseRequest.getPrice() <= 1000) {
            System.out.println(name + "处理此请求，请求编号是：" + purchaseRequest.getPrice());
        } else {
            this.approver.processRequest(purchaseRequest);
        }
    }
}
