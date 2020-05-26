package gen_lab04_refactoring;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {

            sb.append("{");
            sb.append("\"id\": ");
            sb.append(getOrderForWriter(i).getOrderId());
            sb.append(", ");
            sb.append("\"products\": [");
            for (int j = 0; j < getOrderForWriter(i).getProductsCount(); j++) {

                getProductContents(sb, getOrderForWriter(i).getProduct(j));
            }

            if (getOrderForWriter(i).getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]");
            sb.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private Order getOrderForWriter(int order) {
        return orders.getOrder(order);
    }

    private void getProductContents(StringBuffer sb, Product product) {
        sb.append("{");
        sb.append("\"code\": \"");
        sb.append(product.getCode());
        sb.append("\", ");
        sb.append("\"color\": \"");
        sb.append(product.getColorFor());
        sb.append("\", ");

        if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
            sb.append("\"size\": \"");
            sb.append(product.getSizeFor());
            sb.append("\", ");
        }

        sb.append("\"price\": ");
        sb.append(product.getPrice());
        sb.append(", ");
        sb.append("\"currency\": \"");
        sb.append(product.getCurrency());
        sb.append("\"}, ");
    }

}