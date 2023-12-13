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
        System.out.println("-------------------------------------------------");
        System.out.printf("| %-20s | %-10s | %-8s |\n", "Name", "Price", "Quantity");
        System.out.println("-------------------------------------------------");
    
        for (Product product : products) {
            System.out.printf("| %-20s | %-10.2f | %-8d |\n", product.getName(), product.getPrice(), product.getQuantity());
            
        }
    
        System.out.println("-------------------------------------------------");
    }
    

    private Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public class ItemNotFoundException extends Exception {
        public ItemNotFoundException(String itemName) {
            super("Item not found: " + itemName);
           
        }
    }

    public class NotEnoughItemsForSaleException extends Exception {
        public NotEnoughItemsForSaleException(String itemName, int availableQuantity, int requestedQuantity) {
            super("\n"+"Not enough items for sale." + "\n"+" Item: " + itemName + ", Available Quantity: " + availableQuantity + ", Requested Quantity: " + requestedQuantity);
        }
    }
    
    

      public boolean updateStock(String name) throws StockManager.ItemNotFoundException,NotEnoughItemsForSaleException {
    
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
               throw new NotEnoughItemsForSaleException(name,product.getQuantity(),(product.getQuantity() - quantity));
            }   
        
        }
        else{
            throw new ItemNotFoundException(name.toString());
           
                        }
        
 }

}
