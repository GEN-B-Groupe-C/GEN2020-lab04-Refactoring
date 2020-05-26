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

    String getProductContent() {
        StringBuffer result = new StringBuffer();

        result.append(String.format("{\"code\": \"%s\", \"color\": \"%s\", ", code, getColorFor()));

        if (!getSizeFor().equals(SIZE_NOT_APPLICABLE.getSize())) {
            result.append(String.format("\"size\": \"%s\", ", getSizeFor()));
        }

        result.append(String.format("\"price\": %s, \"currency\": \"%s\"}, ", Double.toString(price), currency));

        return result.toString();
    }
}