package gen_lab04_refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    public String getOrderContent(){
        StringBuffer result = new StringBuffer();

        result.append(String.format("{\"id\": %d, \"products\": [", id));

        for (int j = 0; j < products.size(); j++) {

            result.append(products.get(j).getProductContent());
        }

        if (products.size() > 0) {
            result.delete(result.length() - 2, result.length());
        }

        result.append("]}, ");

        return result.toString();
    }
}
