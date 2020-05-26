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

                result.append(getOrderForWriter(i).getProduct(j).getProductContent());
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

}