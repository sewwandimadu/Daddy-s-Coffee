package Model;

public class Orders {


    int proid;
    int qty;

    public Orders(int proid, int qty) {

        this.proid = proid;
        this.qty = qty;
    }

    public Orders() {
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
