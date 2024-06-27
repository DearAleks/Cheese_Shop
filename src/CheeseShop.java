/*
1. gives access for the shop owner to add/remove different cheeses,
2. gives access for the customer to buy different cheeses,
3. gives access for the customer remove cheese from cart
4. get all the cheeses from the cart or available cheeses in the store
 */

import java.math.RoundingMode;
import java.util.ArrayList;
import java.math.BigDecimal;

public class CheeseShop {
    private ArrayList<Cheese> cheeseList = new ArrayList<>();
    private ArrayList<Cheese> cart = new ArrayList<>();

    public ArrayList<Cheese> getCheeseList() {
        return cheeseList;
    }

    public void addCheeseToShop(Cheese cheese) {
        for (Cheese cheeseInInventory : cheeseList) {
            if (cheeseInInventory.getId() == cheese.getId()) {
                System.out.println("Cheese with ID " + cheese.getId() + " already exists in the inventory.");
                return;
            }
        }
        cheeseList.add(cheese);
        System.out.println("Cheese with the ID " + cheese.getId() + " added to the inventory.");
    }

    public void removeCheeseFromShop(int id) {
        ArrayList<Cheese> found = new ArrayList<>();
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

    public void updateCheese(int id, String name, double price, double quantity) {
        for (Cheese cheese : cheeseList) {
            if (cheese.getId() == id) {
                cheese.setName(name);
                cheese.setPrice(price);
                cheese.setQuantity(quantity);
                return;
            }
        }
    }
    public boolean addCheeseToCart(int id, double boughtQuantity) {
        for (Cheese cheese : cheeseList) {
            if (cheese.getId() == id && cheese.getQuantity() >= boughtQuantity) {
                Cheese cheeseToCart = new Cheese(cheese.getId(), cheese.getName(), cheese.getPrice(), boughtQuantity);
                cheeseToCart.setQuantity(boughtQuantity);
                cheese.setQuantity(cheese.getQuantity() - boughtQuantity);
                cart.add(cheeseToCart);
                return true;
            }
        }
        return false;
    }

    public void removeCheeseFromCart(int id) {
        boolean foundInCart = false;
        Cheese cheeseToRemove = null;

        for (Cheese cheese : cart) {
            if (cheese.getId() == id) {
                cheeseToRemove = cheese;
                foundInCart = true;
                break;
            }
        }
            if (foundInCart) {
                double quantityToAddToInventory = cheeseToRemove.getQuantity();
                cart.remove(cheeseToRemove);
                System.out.println("Removed cheese with ID " + id + " from the cart.");

                for (Cheese cheese : cheeseList) {
                    if (cheese.getId() == id) {
                        cheese.setQuantity(cheese.getQuantity() + quantityToAddToInventory);
                        break;
                    }
                }
            } else {
                System.out.println("Cheese with ID " + id + " not found in the cart.");
            }
    }

    public void printCheeseList() {
        System.out.println("Cheeses in the inventory: ");
        for (Cheese cheese : cheeseList){
            System.out.println(cheese);
        }
    }

    public void printCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            System.out.println("Items in your cart: ");
            for (Cheese cheese : cart) {
                System.out.println(cheese);
            }
        }
    }

    public BigDecimal checkout() {
        double totalCost = 0.0d;
        BigDecimal roundedTotalCost = null;
        for (Cheese cheese : cart) {
            totalCost += cheese.getQuantity() * cheese.getPrice();
            roundedTotalCost = new BigDecimal(totalCost).setScale(2, RoundingMode.HALF_UP);
        }
        return roundedTotalCost;
    }

    public void clearCart() {
        cart.clear();
    }
}
