public class Smartphone extends Product {
    private String namePhone;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String namePhone, String manufacturer) {
        super(id, name, price);
        this.namePhone = namePhone;
        this.manufacturer = manufacturer;
    }
}