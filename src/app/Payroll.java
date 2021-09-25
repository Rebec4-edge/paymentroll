package app;

import app.employeeMenu.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.employees.*;
import model.payments.*;


public class PayrollSystem {
    public static void main(String[] args){
        int op = 13;
        Scanner input = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<Employee>();
        PaymentSchedule paySchedule = new PaymentSchedule();

        while(op!=0){
            
            System.out.println("\n\n*****SISTEMA DE FOLHA DE PAGAMENTO**********\n");
            System.out.println("Selecione uma opção ");
            System.out.println("1 - Adicionar um empregado");
            System.out.println("2 - Remover um empregado");
            System.out.println("3 - Lançar um cartão de ponto");
            System.out.println("4 - Lançar um resultado de venda");
            System.out.println("5 - Lançar uma taxa de serviço");
            System.out.println("6 - Editar um empregado");
            System.out.println("7 - Rodar folha de pagamento para hoje");
            System.out.println("8 - Undo/redo\n");
            System.out.println("9 - Criar nova agenda de pagamento\n");
            System.out.println("0 - Sair.\n");


            op = SystemInputs.readInt(input, "");


            switch(op){
                case 1:
                    employeeList.add(EmployeeConf.newEmployee(input, paySchedule));
                    break;
                    
                case 2:
                    EmployeeConf.removeEmployee(input, employeeList);
                    break;

                case 3:
                    List<Employee> hourlyList = EmployeeType.isHourly(input, employeeList);
                    if(hourlyList.isEmpty()){
                        System.out.println("\nNão existem horistas na lista\n");
                    }else{
                        EmployeeConf.addTimeCard(input, hourlyList);
                    }
                    break;
                case 4:
                    List<Employee> commissionedList = EmployeeType.isCommissioned(input, employeeList);
                    if(commissionedList.isEmpty()){
                        System.out.println("\n Não existem comissionados na lista\n");
                    }else{
                        EmployeeConf.addSaleReport(input, commissionedList);
                    }
                    break;
                case 5:
                    List<Employee> syndicateList = EmployeeType.isSyndicateMember(input, employeeList);
                    if(syndicateList.isEmpty()){
                        System.out.println("\n Não existem membros do sindicato na lista\n");
                    }else{
                        EmployeeConf.addServiceFee(input, syndicateList);
                    }
                    break;
                case 6:
                    if(employeeList.isEmpty()){
                        System.out.println("\nLista de empregados está vazia\n");
                    }else{
                        EditEmployeeInfos.editEmployee(input, employeeList);
                    }
                    break;
                case 7:
                    if(employeeList.isEmpty()){
                        System.out.println("\nA lista de empregados está vazia\n");
                    }else{
                        PaymentConf.TodayPayroll(input, employeeList);
                    }
                    break;

                case 8:
                    if(employeeList.isEmpty()){
                        System.out.println("\nA lista de empregados está vazia\n");
                    }else{
                        PaymentConf.TodayPayroll(input, employeeList);
                    }
                    break;

                case 9:
                    if(employeeList.isEmpty()){
                        System.out.println("\nA lista de empregados está vazia\n");
                    }else{
                        PaymentConf.TodayPayroll(input, employeeList);
                    }
                    break;
                default:
                    break;
            }
        }

    }
}