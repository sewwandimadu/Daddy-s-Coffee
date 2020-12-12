package Model;

import java.util.ArrayList;

public class ProductList {

    ArrayList<Products> plist;

    public ProductList(ArrayList<Products> plist) {
        this.plist = plist;
    }

    public ProductList() {
    }

    public ArrayList<Products> getPlist() {
        return plist;
    }

    public void setPlist(ArrayList<Products> plist) {
        this.plist = plist;
    }
}
