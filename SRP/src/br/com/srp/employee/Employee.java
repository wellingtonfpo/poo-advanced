package br.com.srp.employee;

public class Employee {

    // Dados do funcionário
    private String nome;
    private double salarioBase;
    private int horasTrabalhadas;

    public Employee(String nome, double salarioBase, int horasTrabalhadas) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    // =========================================================
    // RESPONSABILIDADE 1: Regras de Negócio do RH (Pagamento)
    // =========================================================
    public double calculatePay() {
        System.out.println("Calculando pagamento com base nas regras do RH...");
        // Se a regra de cálculo mudar, esta classe precisa ser alterada.
        return this.salarioBase * this.horasTrabalhadas; // Lógica simplificada
    }

    // =========================================================
    // RESPONSABILIDADE 2: Regras da Operação (Relatórios)
    // =========================================================
    public void reportHours() {
        System.out.println("Formatando e gerando relatório para os gestores...");
        // Se o formato do relatório mudar, esta classe precisa ser alterada.
    }

    // =========================================================
    // RESPONSABILIDADE 3: Infraestrutura (Banco de Dados)
    // =========================================================
    public void saveEmployee() {
        System.out.println("Conectando ao banco de dados e salvando registro...");
        // Se mudarmos de MySQL para PostgreSQL, esta classe precisa ser alterada.
    }
}
