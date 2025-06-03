public class PrototypeDemo {
    public static void main(String[] args) {
        PriceList priceList = new PriceList("Lista Normal");
        priceList.addProduct(new Product("Laptop",500));
        priceList.addProduct(new Product("Audifonos",50));
        //priceList.addProduct(new Product("Mouse",25));
        //priceList.addProduct(new Product("Monitor",150));
        //priceList.addProduct(new Product("Teclado",500));
        //priceList.addProduct(new Product("CPU",300));
        
        System.out.println(priceList);
        
        // Normal Clone de Lista con escuento (Erroneo)
        PriceList clone = (PriceList) priceList.clone();
        clone.setName("Lista con Descuento");
        //System.out.println("\n" + clone);
        
        
        // Deep Clone de lista con descuento 
        PriceList deepClone = (PriceList) priceList.deepClone();
        deepClone.setName("Lista en Liquidacion");
        //System.out.println("\n" + deepClone);
        
        
        for (Product product: deepClone.getProducts()){
            product.setPrice(product.getPrice() * 0.9);
        }
        System.out.println("\n" + deepClone);
        
        
    }
}