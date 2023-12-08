package entities;

public class Empregado {

    private int id;
    private String nome;
    private float salario;

    public Empregado(int id, String nome, float salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentarSalario(float aumento) {
        this.salario += aumento;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return (id + ", " + nome + ", " + salario);
    }
}
