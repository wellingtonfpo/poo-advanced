import br.com.srp.employee.EmployeeData;
import br.com.srp.employee.EmployeeFacade;

public class Main {
    public static void main(String[] args) {

        // 1. Criamos a estrutura de dados com as informações do funcionário
        EmployeeData dadosJoao = new EmployeeData("João Silva", 50.0, 160);

        // 2. Entregamos os dados para a nossa Fachada (Facade)
        EmployeeFacade funcionarioFacade = new EmployeeFacade(dadosJoao);

        System.out.println("--- Iniciando rotinas do sistema ---");

        // 3. O cliente (esta classe Main) interage apenas com os métodos simples da Facade!

        // O RH pede para calcular o pagamento:
        double pagamento = funcionarioFacade.calculatePay();
        System.out.println("Valor a ser pago: R$ " + pagamento);
        System.out.println("------------------------------------");

        // O Gestor pede o relatório de horas:
        funcionarioFacade.reportHours();
        System.out.println("------------------------------------");

        // O sistema precisa salvar os dados no fim do dia:
        funcionarioFacade.save();
    }
}