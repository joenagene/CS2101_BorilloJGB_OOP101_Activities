import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] items = {
            "Chocolate Donut",
            "Xtreme Chocolate Crunch Donut",
            "Tokoyaki",
            "Pizza",
            "Cheese Fries",
            "Sour Cream Fries",
            "BBQ Fries",
            "Fried Noodles"
        };

        double[] prices = {
            35.00,
            45.00,
            80.00,
            120.00,
            70.00,
            70.00,
            75.00,
            65.00
        };

        int totalQuantity = 0;
        double totalBeforeDiscount = 0.00;
        double totalDiscount = 0.00;

        char orderAgain = 'Y';

        System.out.println("===== MENU =====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-30s - $%.2f%n",
                    i + 1, items[i], prices[i]);
        }

        System.out.println();

        while (orderAgain == 'Y') {

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > items.length
                    || quantity < 1 || quantity > 10) {

                System.out.println();
                System.out.println(
                        "Invalid order! Please enter a valid item and quantity.");
                System.out.println();

                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().toUpperCase().charAt(0);

            double subtotal = prices[itemNumber - 1] * quantity;
            double discountRate = 0.00;

            if (student == 'Y' && subtotal >= 500) {
                discountRate = 0.15;
            } else if (student == 'Y') {
                discountRate = 0.10;
            } else if (subtotal >= 500) {
                discountRate = 0.05;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            totalQuantity += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            System.out.printf("%nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            System.out.print(
                    "\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);

            System.out.println();
        }

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);
        System.out.printf("Final amount: $%.2f%n",
                finalAmount);
        System.out.println("Thank you for ordering!");

        input.close();
    }
}