package gateways;

import contracts.PaymentGateway;

public class PagarMeGateway implements PaymentGateway {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("[Pagar.me] Processando pagamento de R$ " + amount);
        return true;
    }

    @Override
    public double checkTax(double amount) {
        double tax = amount * 0.05; // 2% de taxa
        System.out.println("[Pagar.me] Taxa para R$" + amount + ": R$ " + tax);
        return tax;
    }

    @Override
    public boolean isAvailable() {
        System.out.println("[Pagar.me] Verificando disponibilidade... Status: Online");
        return true;
    }
}
