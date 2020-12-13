package Model;

public class Orders {

    int orderid;
    int proid;
    int qty;

    public Orders(int orderid, int proid, int qty) {
        this.orderid = orderid;
        this.proid = proid;
        this.qty = qty;
    }

    public Orders() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
