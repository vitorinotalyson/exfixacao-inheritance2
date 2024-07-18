import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxes = new ArrayList<>();
        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for (int i = 1;i<=n;i++){
            System.out.printf("Tax payer #%d data:\n",i);
            System.out.print("Individual or Company? (i/c) ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();
            if (type == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxes.add(new Individual(name,anualIncome,healthExpenditures));
            } else if (type == 'c') {
                System.out.print("Number of Employees: ");
                int numberOfEmployees = sc.nextInt();
                taxes.add(new Company(name,anualIncome,numberOfEmployees));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        double sum = 0;
        for (TaxPayer payer: taxes){
            System.out.printf("%s: $ %.2f\n",payer.getName(),payer.tax());
            sum += payer.tax();
        }
        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f",sum);
        sc.close();
        
    }
}
