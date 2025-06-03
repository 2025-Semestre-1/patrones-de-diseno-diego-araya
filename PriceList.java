import java.util.ArrayList;
import java.util.List;
// Clase PriceList que implementa Prototype

class PriceList implements Prototype {
    
    private String name;
    private List<Product> products;  

    public PriceList(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Getters
    public String getName() { 
        return name; 
    }
    public List<Product> getProducts() { 
        return products;
    }
    
    public void setName(String name){
        this.name = name;
    }

    // Clonación SUPERFICIAL (Comparte la lista de productos)
    @Override
    public Prototype clone() {
        PriceList cloned = new PriceList(this.name);
        cloned.products = this.products; // Misma lista de referencias
        return cloned;
    }

    // Clonación PROFUNDA (Copia independiente de todos los productos)
    @Override
    public Prototype deepClone() {
        PriceList cloned = new PriceList(this.name);
        for (Product product : this.products) {
            cloned.addProduct((Product) product.clone()); // Clona cada producto
        }
        return cloned;
    }

    @Override
    public String toString() {
        return "Referencia de Memoria: " + System.identityHashCode(this) +
        "\nName: " + getName() + 
        "\nProducts: " + getProducts();
    }
}