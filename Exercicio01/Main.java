import java.util.ArrayList;
import java.util.Scanner;

import entities.Empregado;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos empregados serão registrados?: ");
        int qtd = sc.nextInt();
        
        ArrayList<Empregado> colaboradores = new ArrayList<>();

        for(int i = 0; i < qtd; i++) {
            System.out.print("Digite o id do funcionario: ");
            int id = sc.nextInt();

            sc.nextLine();
      
            System.out.print("Digite o nome do funcionario: ");
            String nome = sc.nextLine();
            
            System.out.print("Digite o salario do funcionario: ");
            float salario = sc.nextFloat();

            Empregado e = new Empregado(id, nome, salario);

            colaboradores.add(e);
        }

        System.out.print("Digite o id do funcionario que vai ter um aumento de salario: ");
        int id = sc.nextInt();

        boolean verif = false;
        for(Empregado e : colaboradores) {
            
            if(e.getId() == id) {
                verif = true;
            }
        }

        if(verif) {
            System.out.print("Digite o aumento do funcionario: ");
            float aumento = sc.nextFloat();

            for(Empregado e : colaboradores) {
            
                if(e.getId() == id) {
                    e.aumentarSalario(aumento);
                }
            }
        }else {
            System.out.println("Não existe funcionario com o id especificado!");
        }
        
        sc.close();

        for(Empregado e : colaboradores) {
            
            System.out.println(e);
        }

    }
    
}

