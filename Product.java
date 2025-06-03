// Clase Product que implementa Prototype
class Product implements Prototype {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters y Setters
    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }

    // Clonación superficial (comparte referencias)
    @Override
    public Prototype clone() {
        return new Product(this.name, this.price);
    }

    // Clonación profunda (Equivalente a clone() aquí)
    @Override
    public Prototype deepClone() {
        return clone(); 
    }

    @Override
    public String toString() {
        return "Referencia de Memoria: " + System.identityHashCode(this)+ 
        "  Name: " + getName() + 
        " - Price: " +  getPrice();
    }
}
