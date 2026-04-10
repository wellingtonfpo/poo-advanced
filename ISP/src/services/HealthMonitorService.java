package services;

import contracts.PaymentGateway;

import java.util.List;

public class HealthMonitorService {
    private final List<PaymentGateway> gateways;

    public HealthMonitorService(List<PaymentGateway> gateways) {
        this.gateways = gateways;
    }

    public void checkGatewaysHealth() {
        System.out.println("Executando Health Check para os gateways de pagamento...");
        for (PaymentGateway gateway : gateways) {
            if (!gateway.isAvailable())
                System.out.println("ALERTA: Gateway " + gateway.getClass().getSimpleName() + " está offline!");
        }
    }
}
