package com.freedom.responsibilitychain;

/**
 * @author liuf
 * date: 2020-02-22
 */
public abstract class Approver {
    /**
     * 下一个处理者
     */
    Approver approver;
    /**
     * 名称
     */
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * 处理审批请求的方法，得到一个方法，处理是子类完成。
     * @param purchaseRequest
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
