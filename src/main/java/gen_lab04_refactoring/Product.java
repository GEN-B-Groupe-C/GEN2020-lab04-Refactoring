package gen_lab04_refactoring;

public class Product {
    public static final int SIZE_NOT_APPLICABLE = -1;
    private String code;
    private int size;
    private double price;
    private String currency;
    private Color color;

    public Product(String code, Color color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    String getSizeFor() {
        switch (getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    String getColorFor() {
        return color.getColor();

    }
}