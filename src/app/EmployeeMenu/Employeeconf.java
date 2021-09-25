package app.employee;

import model.payments.*;
import model.employees.*;
import model.employees.Salaried;
import app.*;


import java.time.*;
import java.util.*;

public class EmployeeConf{

    public static Employee newEmployee(Scanner input, PaymentSchedule schedule){
        Employee employee = null;
        Payments payment = null;
        Syndicate syndicateMember = null;

        int op;
        String optionSchedule = "";
        String name = SystemInputs.readString(input, "Nome ");
        String address = SystemInputs.readString(input, "Endereço ");

        System.out.println("Digite o tipo de empregado ");
        System.out.println("1 - Assalariado\n2 - Commissionado \n3 - Horista");

        op = input.nextInt();
        System.out.println();
        optionSchedule = schedule.getSchedule().get(op-1);
        switch(op){
            case 1:
            double salary = SystemInputs.readDouble(input, "Salário ");
            employee = new Salaried(name, address, UUID.randomUUID(), syndicateMember, payment, salary);
            break;
            
            case 2:
            double salaryC = SystemInputs.readDouble(input, "Salário ");
            double commissionPay = SystemInputs.readDouble(input, "Porcentagem da comissão ");
            employee = new Commissioned(name, address, UUID.randomUUID(), syndicateMember, payment, salaryC, commissionPay);
            break;
            
            case 3:
            double hourPay = SystemInputs.readDouble(input, " ");
            employee = new Hourly(name, address, UUID.randomUUID(), syndicateMember, payment, hourPay);
            break;
        }
        
        
        payment = PaymentConf.getPayInfo(input, optionSchedule);
        employee.setPayInfo(payment);

        System.out.println("O empregado é membro sindicalista? 1- Sim\n 2- Não\n");
        int synd = input.nextInt();
        if(synd == 1){
            double syndFees = SystemInputs.readDouble(input, " Digite a taxa do empregado ");
            syndicateMember = new Syndicate(employee.getId(), syndFees, true);
            employee.setSyndicate(syndicateMember);
        }else if (synd == 2){
            double syndFees = 0;
            syndicateMember = new Syndicate(employee.getId(),syndFees, false);
        }
        System.out.println("\nRegistrado");
        System.out.println(employee.toString() + "\n\n\n");
        return employee;
    }

    

    public static void removeEmployee(Scanner input, List<Employee> employeeList){
        if(!employeeList.isEmpty()){
            employeeList.remove(SystemInputs.getIndiceDaLista(input, employeeList));
            System.out.println("Empregado removido");
        }else{
            System.out.println("Vazio!!");
        }
       
       
    }

    public static void addTimeCard(Scanner input, List<Employee> hourlyList){
        LocalDate date = SystemInputs.readDate(input, "Digite a data ");
        Hourly employee = (Hourly) hourlyList.get(SystemInputs.getIndiceDaLista(input, hourlyList));

        System.out.println("Digite a hora da sua entrada");
        int INhours = SystemInputs.readInt(input, "Hora ");
        int INminutes = SystemInputs.readInt(input, "Minutos ");
        LocalTime tIN = LocalTime.of(INhours, INminutes);

        System.out.println("Digite a hora da sua saída");
        int OUThours = SystemInputs.readInt(input, "Horas: ");
        int OUTminutes = SystemInputs.readInt(input, "Minutos ");
        LocalTime tOUT = LocalTime.of(OUThours, OUTminutes);

        TimeCard tc = new TimeCard(date, tIN, tOUT);
        employee.getTimeCard().add(tc);

        System.out.println("Cartão de ponto adicionado com sucesso");
        }
        

    public static void addSaleReport(Scanner input, List<Employee> commissionedList){
        LocalDate date = SystemInputs.readDate(input, "Digite a data ");
        Commissioned employee = (Commissioned) commissionedList.get(SystemInputs.getIndiceDaLista(input, commissionedList));

        double saleValue = SystemInputs.readDouble(input, "Digite o valor da venda ");

        SalesReport sales = new SalesReport(saleValue, date);
        employee.getSalesReport().add(sales);
        System.out.println(" Relatório de vendas gerado com sucesso");
    }

    
    public static void addServiceFee(Scanner input, List<Employee> syndicateList){
        LocalDate date = SystemInputs.readDate(input, "Digite a data ");
        Employee employee = syndicateList.get(SystemInputs.getIndiceDaLista(input, syndicateList));
        double feesValue = SystemInputs.readDouble(input, "Digite o valor das taxas ");

        ServicesFees fees = new ServicesFees(feesValue, date);
        employee.getSyndicate().getServiceFees().add(fees);
        System.out.println("Taxas de serviço adicionadas.");
        
    }


}