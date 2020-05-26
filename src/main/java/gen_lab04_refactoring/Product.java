package gen_lab04_refactoring;

public class Product {
    public static final Size SIZE_NOT_APPLICABLE = new Size();
    private String code;
    private Size size;
    private double price;
    private String currency;
    private Color color;

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Size getSize(){ return size; }

    public Color getColor(){ return color; }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    String getSizeFor() {
        return size.getSize();
    }

    String getColorFor() {
        return color.getColor();

    }
}