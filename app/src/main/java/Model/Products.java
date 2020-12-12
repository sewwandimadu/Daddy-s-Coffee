package Model;

public class Products {

    private String name;
    private String img;
    private double price;
    private int catId;
    private  String desc;


    public Products(String name, String img, double price, int catId, String desc) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.catId = catId;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
