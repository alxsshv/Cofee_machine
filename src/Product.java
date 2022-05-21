public class Product {
    private int price;
    private String name;
    private static int count;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
        count++;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }
}
