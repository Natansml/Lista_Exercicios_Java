package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.Cargo;

public class Trabalhador {

    private String nome;
    private Cargo cargo;
    private Double salario;
    private Departamento departamento;
    private List<ContratoHora> contratos;

    public Trabalhador( String nome, Cargo cargo, Double salario, Departamento departamento) {

        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
        this.contratos = new ArrayList<>();
    }

    public void adicionarContrato(ContratoHora c) {
        contratos.add(c);
    }

    public void removerContrato(ContratoHora c) {
        contratos.remove(c);
    }

    public Double salarioTotal(int ano, int mes) {
        Double soma = salario;
        Calendar cal = Calendar.getInstance();

        for (ContratoHora contrato : contratos) {

            cal.setTime(contrato.getData());
            int anop = cal.get(Calendar.YEAR);
            int mesp = 1 + cal.get(Calendar.MONTH);

            if(anop == ano && mesp == mes) {
                soma += contrato.valorTotal();
            }
        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento.getDepartamento();
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }

}
