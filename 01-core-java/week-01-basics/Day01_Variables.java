public class Day01_Variables {
    public static void main(String[] args) {

        // 1. storing customer information

        String customerName = "Nayan Deshmukh";
        int customerAge = 24;

        // 2. storing product detailes

        String productName = "Headphones";
        double unitPrice = 49.99;
        int quantityOrderd = 3;
        boolean inStock = true;
        char currencySymbool = '$';
        double discount = 10.0;

        // 3. Calculating Total Price ( math in Java)

        double totalPrice = unitPrice * quantityOrderd - discount;

        // 4. Printing the Order Reciept to the console

        System.out.println("=========================================");
        System.out.println("           ORDER RECIEPT                 ");
        System.out.println("=========================================");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Customer Age : " + customerAge);
        System.out.println("Product : " + productName);
        System.out.println("In Stock : " + inStock);
        System.out.println("Quantity: " + quantityOrderd);
        System.out.println("Unit Price: " + currencySymbool + unitPrice);
        System.out.println("Discount : " + currencySymbool + discount);
        System.out.println("=========================================");
        System.out.println("Total Amount: " + currencySymbool + totalPrice);
        System.out.println("=========================================");

    }
}