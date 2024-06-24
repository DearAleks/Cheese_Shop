/*
User UI, accesses CheeseService and CheeseShop to buy or to add different cheeses.
 */
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CheeseShop cheeseShop = new CheeseShop();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo add an item to the shop - 1");
            System.out.println("To delete an item from the shop - 2");
            System.out.println("To update an item - 3");
            System.out.println("To check the stock - 4");
            System.out.println("To add an item to the cart - 5");
            System.out.println("To delete an item from the cart - 6");
            System.out.println("To review the items in the cart - 7");
            System.out.println("To checkout - 8");
            System.out.println("To exit the shop - 9");

            int action = scanner.nextInt();
            if (action == 1) {
                addCheese();
            } else if (action == 2) {
               deleteCheese();
            } else if (action == 3) {
                ;
            } else if (action == 4) {
                printInventory();
            } else if (action == 5) {
                ;
            } else if (action == 6) {
                ;
            } else if (action == 7) {
                ;
            } else if (action == 8) {
                ;
            } else if (action == 9) {
                break;
            }

        }

    }
    public static void addCheese() {
        System.out.println("Provide cheese id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Provide cheese name");
        String name = scanner.nextLine();
        System.out.println("Provide cheese price");
        double price = scanner.nextDouble();
        System.out.println("Provide cheese quantity in kg");
        int quantity = scanner.nextInt();
        var cheese = new Cheese(id, name, price, quantity);
        cheeseShop.addCheeseToShop(cheese);
    }
    public static void deleteCheese(){
        System.out.println("Provide cheese id to delete: ");
        int id = scanner.nextInt();
        cheeseShop.removeCheeseFromShop(id);
    }
    public static void printInventory(){
        System.out.println("These are the cheeses in the inventory: ");
        var inventory = cheeseShop.getCheeseList();
        for (var cheese : inventory){
            System.out.println("ID: " + cheese.getId() + ", Name: " + cheese.getName() + ", Price: " + cheese.getPrice() + ", Quantity: " + cheese.getQuantity() + "kg");
        }
    }
}