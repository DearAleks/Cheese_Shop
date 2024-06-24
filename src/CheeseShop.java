/*
1. gives access for the shop owner to add/remove different cheeses,
2. gives access for the customer to buy different cheeses,
3. gives access for the customer remove cheese from cart
4. get all the cheeses from the cart or available cheeses in the store
 */

import java.util.ArrayList;
public class CheeseShop {
    private ArrayList<Cheese> cheeseList = new ArrayList<Cheese>();
    private ArrayList<Cheese> cart = new ArrayList<Cheese>();

    public ArrayList<Cheese> getCheeseList() {
        return cheeseList;
    }
    public ArrayList<Cheese> getCart() {
        return cart;
    }
    public void addCheeseToShop(Cheese cheese) {
        cheeseList.add(cheese);
    }
    public void removeCheeseFromShop(int id) {
        ArrayList<Cheese> found = new ArrayList<Cheese>();
        for (Cheese cheese : cheeseList) {
            if (cheese.getId() == id) {
                found.add(cheese);
            }
        }
        if (!found.isEmpty()) {
            cheeseList.removeAll(found);
            System.out.println("Removed cheese with ID : " + id);
        } else {
            System.out.println("Cheese with ID " + id + " not found");
        }
    }
//
//    public void updateCheese(int id, String name, double price) {
//        for (Cheese cheese : cheeseList) {
//            if (cheese.getId() == id) {
//                cheese.setName(name);
//                cheese.setPrice(price);
//                return;
//            }
//        }
//    }
//    public boolean addCheeseToCart(int id) {
//        for (Cheese cheese : cheeseList) {
//            if (cheese.getId() == id) {
//                cart.add(cheese);
//                System.out.println("Cheese " + cheese + " added to cart");
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean removeCheeseFromCart(int id) {
//        for (Cheese cheese : cheeseList) {
//            if (cheese.getId() == id) {
//                cart.remove(cheese);
//                System.out.println("Cheese " + cheese + " removed from cart");
//                return true;
//            }
//        }
//        return false;
//    }
//    public void printCheeseList() {
//        for (Cheese cheese : cheeseList) {
//            System.out.println("ID: " + cheese.getId() + "\nName: " + cheese.getName() + "\nPrice: " + cheese.getPrice());
//        }
//    }
//    public void printCart() {
//        for (Cheese cheese : cart) {
//            System.out.println("ID: " + cheese.getId() + "\nName: " + cheese.getName() + "\nPrice: " + cheese.getPrice());
//        }
//    }
}
