package gen_lab04_refactoring;

public class Product {
    public static final EnumSize SIZE_NOT_APPLICABLE = EnumSize.INVALID_SIZE;
    private String code;
    private EnumSize size;
    private double price;
    private String currency;
    private EnumColor color;

    public Product(String code, EnumColor color, EnumSize size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public EnumSize getSize(){ return size; }

    public EnumColor getColor(){ return color; }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSizeFor() {
        return size.getSize();
    }

    public String getColorFor() {
        return color.getColor();
    }

    public String getProductContent() {
        StringBuffer result = new StringBuffer();

        result.append(String.format("{\"code\": \"%s\", \"color\": \"%s\", ", code, getColorFor()));

        if (!getSizeFor().equals(SIZE_NOT_APPLICABLE.getSize())) {
            result.append(String.format("\"size\": \"%s\", ", getSizeFor()));
        }

        result.append(String.format("\"price\": %s, \"currency\": \"%s\"}, ", Double.toString(price), currency));

        return result.toString();
    }
}