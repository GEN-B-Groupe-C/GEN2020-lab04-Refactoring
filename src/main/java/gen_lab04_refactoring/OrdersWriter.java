package gen_lab04_refactoring;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer result = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {

            result.append("{");
            result.append("\"id\": ");
            result.append(getOrderForWriter(i).getOrderId());
            result.append(", ");
            result.append("\"products\": [");
            for (int j = 0; j < getOrderForWriter(i).getProductsCount(); j++) {

                result.append(getProductContents(getOrderForWriter(i).getProduct(j)));
            }

            if (getOrderForWriter(i).getProductsCount() > 0) {
                result.delete(result.length() - 2, result.length());
            }

            result.append("]");
            result.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            result.delete(result.length() - 2, result.length());
        }

        return result.append("]}").toString();
    }

    private Order getOrderForWriter(int order) {
        return orders.getOrder(order);
    }

    private String getProductContents(Product product) {
        StringBuffer result = new StringBuffer();
        result.append("{");
        result.append("\"code\": \"");
        result.append(product.getCode());
        result.append("\", ");
        result.append("\"color\": \"");
        result.append(product.getColorFor());
        result.append("\", ");

        if (!product.getSizeFor().equals(Product.SIZE_NOT_APPLICABLE.getSize())) {
            result.append("\"size\": \"");
            result.append(product.getSizeFor());
            result.append("\", ");
        }

        result.append("\"price\": ");
        result.append(product.getPrice());
        result.append(", ");
        result.append("\"currency\": \"");
        result.append(product.getCurrency());
        result.append("\"}, ");
        return result.toString();
    }

}