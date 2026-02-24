package br.com.srp.employee;

// Classe que atua apenas como uma estrutura de dados (Data Transfer Object)
public class EmployeeData {
    // O diagrama não especifica os atributos, mas na prática
    // esta classe conteria os dados do funcionário.
    private String nome;
    private double salarioBase;
    private int horasTrabalhadas;

    public EmployeeData(String nome, double salarioBase, int horasTrabalhadas) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    // Construtores, Getters e Setters (omitidos para brevidade)
}

