package br.com.srp.employee;

public class EmployeeFacade {

    // A Facade mantém as instâncias das classes especialistas e dos dados
    private EmployeeData employeeData;
    private PayCalculator payCalculator;
    private HourReporter hourReporter;
    private EmployeeSaver employeeSaver;

    // Construtor: Inicializa a Facade com os dados do funcionário
    public EmployeeFacade(EmployeeData employeeData) {
        this.employeeData = employeeData;
        this.payCalculator = new PayCalculator();
        this.hourReporter = new HourReporter();
        this.employeeSaver = new EmployeeSaver();
    }

    // Delega a responsabilidade para o PayCalculator
    public double calculatePay() {
        return this.payCalculator.calculatePay(this.employeeData);
    }

    // Delega a responsabilidade para o HourReporter
    public void reportHours() {
        this.hourReporter.reportHours(this.employeeData);
    }

    // Delega a responsabilidade para o EmployeeSaver
    public void save() {
        this.employeeSaver.saveEmployee(this.employeeData);
    }
}
