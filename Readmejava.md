## Item Structure
```bash
class  Product { 
	private String name;
	private  double price;
	private  int quantity;
	// ... constructors, getters, setters, etc. 
	 }
```
## Add Product
```bash
public void addProduct(String name, double price, int initialQuantity) {
    Product product = new Product(name, price, initialQuantity);
    products.add(product);
    System.out.println("Product added successfully.");
}
```
## Show Inventory
```bash
public  void  displayStock() {
		System.out.println("-------------------------------------------------");
        System.out.printf("| %-20s | %-10s | %-8s |\n", "Name", "Price", "Quantity");
        System.out.println("-------------------------------------------------");
        for (Product product : products) {
            System.out.printf("| %-20s | %-10.2f | %-8d |\n", product.getName(), product.getPrice(), product.getQuantity());     
        }
        System.out.println("-------------------------------------------------");
 }
 ```
 ##  Find Product
 ```bash
private Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
 ```
 
## Update Product

```bash
public  boolean  updateStock(String name)throws StockManager.ItemNotFoundException, NotEnoughItemsForSaleException { 
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

```
## Clear Screen
```bash
 private static void clearScreen() {
        try {
            System.out.println("Press Enter to continue...");
            new Scanner(System.in).nextLine(); // Wait for the user to press Enter

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // ANSI escape code for clearing the screen
                System.out.flush();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
```
## Welcome Screen
```bash
public static void welcome() {
        System.out.println("--------------------------------:");
        System.out.println("Welcome");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println(" ");

        System.out.println("Stock Managment System");
        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println("@2023 JU");
        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println("-------------------------------");

    }
```
## Display options
```bash
public static void disp() {
        System.out.println("Options:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Stock");
        System.out.println("3. Display Stock");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
    }
```



## Main Function
```bash
public  static  void  main(String[] args) { 
StockManager stockManager = new StockManager();

        Scanner scanner = new Scanner(System.in);
        clearScreen();

        welcome();
        clearScreen();

        while (true) {
            clearScreen();

            disp();

            int choice = scanner.nextInt();

       

            

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter initial quantity: ");
                    int initialQuantity = scanner.nextInt();
                    stockManager.addProduct(name, price, initialQuantity);
                    break;
                case 2:
                    stockManager.displayStock();
                    System.out.print("Enter product name to update stock: ");
                    String productName = scanner.next();
                    try {
                        stockManager.updateStock(productName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    stockManager.displayStock();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        }

}
```

