package services;

import contracts.PaymentGateway;

public class TaxCalculatorService {
    public double calculateTotalCost(PaymentGateway gateway, double amount) {
        System.out.println("Calculando custo total para R$ " + amount);

        double tax = gateway.checkTax(amount);
        double totalCost = amount + tax;

        System.out.println("Custo total (valor + taxa): R$ " + totalCost);
        return totalCost;
    }
}
