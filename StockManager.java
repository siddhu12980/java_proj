import java.util.ArrayList;
import java.util.Scanner;

class StockManager {
    private ArrayList<Product> products;

    public StockManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price, int initialQuantity) {
        Product product = new Product(name, price, initialQuantity);
        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void displayStock() {
        System.out.println("Stock:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() +
                    ", Price: " + product.getPrice() +
                    ", Quantity: " + product.getQuantity());
        }
    }

    private Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

      public boolean updateStock(String name) {
    
        Product product = findProduct(name);
        Scanner scanner = new Scanner(System.in);
        if (product != null) {

                System.out.println("1: for adding Stock");
            System.out.println("2: for subtracting Stock");


            int choice=scanner.nextInt();
        

            System.out.println("Enter the quantity to change");

            int quantity=scanner.nextInt();
            
          if (choice==1) {
            int newQuantity=product.getQuantity()+quantity;
            product.setQuantity(newQuantity);
            return true;     
            }
          
             if (quantity > 0 && quantity <= product.getQuantity()) {

                int newQuantity = product.getQuantity() - quantity;
                product.setQuantity(newQuantity);
                System.out.println("Stock updated successfully.");
                return true;
            } else {
                System.out.println("Invalid quantity. Please enter a valid quantity.");
                return false;
            }   
        
        }
        else{
           
            System.out.println("Product not found.");
            System.out.println("Please Add the product in Stock first");
            return false;       
        }
        
 }

}
