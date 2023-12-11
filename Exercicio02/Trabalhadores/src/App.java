import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import classes.ContratoHora;
import classes.Departamento;
import classes.Trabalhador;
import enums.Cargo;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        System.out.print("Digite o nome do departamento: ");
        Departamento dept = new Departamento(sc.nextLine());

        System.out.println("Insira os dados do trabalhador:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.print("Salario: ");
        Double salario = sc.nextDouble();

        Trabalhador t = new Trabalhador(nome, Cargo.valueOf(cargo), salario, dept);

        System.out.print("Quantos contratos para este trabalhador?: ");
        int i = sc.nextInt();

        for(int l = 0; l<i; l++) {
            System.out.printf("Insira os dados do contrato #%d: \n", l+1);
            System.out.print("Data (DD/MM/YYY): ");
            sc.nextLine();
            Date data = sdf.parse(sc.next());
            System.out.print("Valor por Hora: ");
            Double valor = sc.nextDouble();
            System.out.print("Quantidade de Horas: ");
            int horas = sc.nextInt();

            ContratoHora contrato = new ContratoHora(data, valor, horas);
            t.adicionarContrato(contrato);
        }

        SimpleDateFormat fref = new SimpleDateFormat("MM/yyy");
        sc.nextLine();
        System.out.print("Insira o mes e ano para calcular o valor total (MM/YYY): ");
        Date ref = fref.parse(sc.next());
        cal.setTime(ref);

        int ano = cal.get(Calendar.YEAR);
        int mes = 1 + cal.get(Calendar.MONTH);

        System.out.printf("Nome: %s \n", t.getNome());
        System.out.printf("Departamento: %s \n", t.getDepartamento());
        System.out.printf("Total para %d/%d: %.2f \n", mes, ano, t.salarioTotal(ano, mes));

        sc.close();
    }
}
