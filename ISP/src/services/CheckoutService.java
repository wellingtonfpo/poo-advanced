package services;

import contracts.PaymentProcessor;

public class CheckoutService {
    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void execute(double amount) {
        System.out.println("Iniciando Transação de Checkout...");
        boolean success = paymentProcessor.processPayment(amount);

        if (success) {
            System.out.println("Transação de Checkout concluída com sucesso!");
        } else {
            System.out.println("Transação de Checkout falhou.");
        }
    }
}
