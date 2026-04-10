import contracts.PaymentGateway;
import gateways.PagarMeGateway;
import services.CheckoutService;
import services.HealthMonitorService;
import services.TaxCalculatorService;

void main() {
    PaymentGateway pagarMe = new PagarMeGateway();

    CheckoutService checkoutService = new CheckoutService(pagarMe);
    TaxCalculatorService taxCalculatorService = new TaxCalculatorService();
    HealthMonitorService healthMonitorService = new HealthMonitorService(List.of(pagarMe));

    // Verificar saúde dos gateways
    healthMonitorService.checkGatewaysHealth();
    System.out.println();

    double valorCarrinho = 100.00;
    double custoTotal = taxCalculatorService.calculateTotalCost(pagarMe, valorCarrinho);
    System.out.println("Custo total a ser pago: R$ " + custoTotal);
    System.out.println();

    checkoutService.execute(custoTotal);
}
