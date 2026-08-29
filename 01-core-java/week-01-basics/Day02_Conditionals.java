// package week_01_basics;

public class Day02_Conditionals {
    public static void main(String[] args) {

        // 1. User & Account State
        String username = "Nayan";
        String userRole = "ADMIN"; // Can be "ADMIN", "USER", or "GUEST"
        boolean isAccountActive = true;
        double accountBalance = 2500.0;
        double orderAmount = 1800.0;

        System.out.println("==========================================");
        System.out.println("     BACKEND PAYMENT AUTHORIZATION ENGINE ");
        System.out.println("==========================================");

        // 2. Check 1: Is Account Active?
        if (!isAccountActive) {
            System.out.println("ERROR: Account is deactivated. Transaction rejected.");
            return; // Stop execution immediately (Guard Clause)
        }

        // 3. Check 2: Balance Check & Role-Based Discount
        if (accountBalance >= orderAmount) {

            // Check if user is an ADMIN for special 10% discount
            if (userRole.equals("ADMIN")) {
                double discount = orderAmount * 0.10;
                double finalAmount = orderAmount - discount;
                System.out.println("Welcome Admin! 10% discount applied: -$" + discount);
                System.out.println("Payment of $" + finalAmount + " APPROVED for " + username);
            } else if (userRole.equals("USER")) {
                System.out.println("Standard Payment of $" + orderAmount + " APPROVED for " + username);
            } else {
                System.out.println("Guest user. Please sign in to complete checkout.");
            }

            // Deduct balance
            double remainingBalance = accountBalance - orderAmount;
            System.out.println("Remaining Balance: $" + remainingBalance);

        } else {
            // Not enough money
            double shortage = orderAmount - accountBalance;
            System.out.println("TRANSACTION DECLINED: Insufficient Balance!");
            System.out.println("Required: $" + orderAmount + " | Available: $" + accountBalance);
            System.out.println("You need $" + shortage + " more to complete this order.");
        }

        System.out.println("==========================================");
    }
}