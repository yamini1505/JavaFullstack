@FunctionalInterface
interface ShopWelcome {
    void showMessage();
}

@FunctionalInterface
interface TaxCalculator {
    double getGST(double price);
}

@FunctionalInterface
interface BillCalculator {
    double getTotal(double price, int quantity);
}

@FunctionalInterface
interface DiscountCalculator {
    double getDiscount(double amount);
}

@FunctionalInterface
interface PaymentCalculator {
    double getFinalAmount(double total, double discount);
}

class Day2 {
    public static void main(String[] args) {

        ShopWelcome message = () ->
                System.out.println("Welcome to Shopping Application!");

        TaxCalculator tax = price -> price * 18 / 100;

        BillCalculator total = (price, quantity) -> price * quantity;

        DiscountCalculator offer = amount -> amount * 10 / 100;

        PaymentCalculator payment = (bill, discount) -> {
            double finalPrice = bill - discount;
            return finalPrice;
        };

        double price = 1000;
        int quantity = 2;

        message.showMessage();

        double gst = tax.getGST(price);
        System.out.println("GST Amount: " + gst);

        double bill = total.getTotal(price, quantity);
        System.out.println("Total Bill: " + bill);

        double discount = offer.getDiscount(bill);
        System.out.println("Discount Amount: " + discount);

        double finalBill = payment.getFinalAmount(bill, discount);
        System.out.println("Final Payable Amount: " + finalBill);
    }
}