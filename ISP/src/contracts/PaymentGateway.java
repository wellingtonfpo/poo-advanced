package contracts;

public interface PaymentGateway extends PaymentProcessor {
     double checkTax(double amount);
     boolean isAvailable();
}
