import java.util.ArrayList;
import java.util.List;

// Interfaz Prototype con ambos métodos de clonación
interface Prototype {
    Prototype clone();      // Clonación superficial
    Prototype deepClone();  // Clonación profunda
}

// Clase Product que implementa Prototype
class Product implements Prototype {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters y Setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Clonación superficial (comparte referencias)
    @Override
    public Prototype clone() {
        return new Product(this.name, this.price);
    }

    // Clonación profunda (Product es inmutable, equivalente a clone() aquí)
    @Override
    public Prototype deepClone() {
        return clone(); 
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f}", name, price);
    }
}

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
    public String getName() { return name; }
    public List<Product> getProducts() { return products; }

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
        return String.format("PriceList{name='%s', products=%s}", name, products);
    }
}


public class PrototypeDemo {
    public static void main(String[] args) {
        // Crear lista de precios original
        PriceList originalList = new PriceList("Electrónicos");
        originalList.addProduct(new Product("Laptop", 999.99));
        originalList.addProduct(new Product("Teléfono", 699.99));

        System.out.println("=== Original ===");
        System.out.println(originalList);

        // Clonación superficial 
        PriceList shallowCopy = (PriceList) originalList.clone();
        shallowCopy.getProducts().get(0).setPrice(799.99); // Modifica el producto en ambas listas

        System.out.println("\n=== Shallow Copy (modificada) ===");
        System.out.println(shallowCopy);
        System.out.println("=== Original después de modificar shallow copy ===");
        System.out.println(originalList); 

        // Clonación profunda
        PriceList deepCopy = (PriceList) originalList.deepClone();
        deepCopy.getProducts().get(1).setPrice(599.99); // Solo afecta a la copia

        System.out.println("\n=== Deep Copy (modificada) ===");
        System.out.println(deepCopy);
        System.out.println("=== Original después de modificar deep copy ===");
        System.out.println(originalList); // Original permanece intacto
    }
}