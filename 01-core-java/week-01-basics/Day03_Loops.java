// package week_01_basics;

public class Day03_Loops {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("    BATCH TRANSACTION PROCESSING ENGINE   ");
        System.out.println("==========================================");

        // An array of customer transaction amounts for today
        // Negative amount (-1.0) represents a corrupted/invalid record
        // Amount > 50000.0 represents a suspicious high-value fraud alert
        double[] transactions = { 1200.0, 450.50, -1.0, 8900.0, 55000.0, 2300.0 };

        double totalProcessedAmount = 0.0;
        int successfulCount = 0;
        int skippedCount = 0;

        // Enhanced for-each loop to iterate through every transaction
        for (double amount : transactions) {

            // Rule 1: Skip invalid/corrupted data using 'continue'
            if (amount <= 0) {
                System.out.println("Corrupted record detected (₹" + amount + "). Skipping...");
                skippedCount++;
                continue; // Skips to the next transaction immediately
            }

            // Rule 2: Emergency stop if fraud detected using 'break'
            if (amount >= 100000.0) {
                System.out.println("FRAUD ALERT: High-value transaction of ₹" + amount + " detected!");
                System.out.println("Emergency halt: Stopping batch processor for security review.");
                break; // Exits the entire loop immediately
            }

            // Normal processing
            totalProcessedAmount += amount; // Equivalent to: totalProcessedAmount = totalProcessedAmount + amount
            successfulCount++;
            System.out.println("Processed transaction #" + successfulCount + ": ₹" + amount);
        }

        // Summary Report
        System.out.println("------------------------------------------");
        System.out.println("BATCH SUMMARY REPORT:");
        System.out.println("Total Successful Transactions: " + successfulCount);
        System.out.println("Skipped Invalid Records       : " + skippedCount);
        System.out.println("Total Revenue Settled         : ₹" + totalProcessedAmount);
        System.out.println("==========================================");
    }
}