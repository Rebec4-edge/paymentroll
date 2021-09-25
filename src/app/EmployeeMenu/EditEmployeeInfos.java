package app.employeeMenu;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import app.*;
import model.employees.Commissioned;
import model.employees.Employee;
import model.employees.Hourly;
import model.employees.Salaried;
import model.employees.Syndicate;
import model.payments.PayMethods;

public class EditEmployeeInfos {
    public static void editEmployee(Scanner input, List<Employee> employeeList){
	    int op = 12;
	    Employee e = employeeList.get(SystemInputs.getIndiceDaLista(input, employeeList));
	
	    while(op!=0){
	        System.out.println("\nPor favor, selecione uma opção ");
            System.out.println("1 - Nome");
            System.out.println("2 - Endereço");
            System.out.println("3 - Tipo");
            System.out.println("4 - Método de pagamento");
            System.out.println("5 - Status do sindicato");
            System.out.println("6 - Id do sindicato");
            System.out.println("7 - Taxa do sindicato");
            System.out.println("0 - Sair.\n");
	
	
	        op = SystemInputs.readInt(input, "");
	
	
	        switch(op){
	        case 1:
	            editName(input, e);
	            break;

	        case 2:
	            editAddress(input, e);
	            break;

	        case 3:
                System.out.println("Selecione o tipo de empregado: ");
                System.out.println("1 - Assalariado\n2 - Commissionado\n3 - Horista\n");
	            editType(input, e, SystemInputs.readInt(input, ""));
	            break;

	        case 4:
	            int a = 1;
	            System.out.println("Selecione o método de pagamento");
	            for(PayMethods method : PayMethods.values()){
	                System.out.println(a + " - " + method.getMethod());
	                a++;
	            }
                editPaymentMethod(input, e, input.nextInt());
	            break;

	        case 5: 
	            editSyndicateInfo(input, e);
	            break;

	        case 6:
	            if(e.getSyndicate()!=null){
	                e.getSyndicate().setIdEmployee(UUID.randomUUID());
	                System.out.println(e.toString());                    
	            }else{
	                System.out.println("O empregado não é um sindicalista");
	            }
	            break;

	        case 7:
	            if(e.getSyndicate()!=null){
	                double syndFees = SystemInputs.readDouble(input, "Digite a nova taxa ");
	                e.getSyndicate().setFees(syndFees);
	                System.out.println(e.toString());                  
	            }else{
	                System.out.println("O empregado não é sindicalista");
	            }
	            
	        }
	    }
	}    
    
    public static void editName(Scanner input, Employee employee){
        String name = SystemInputs.readString(input, "Nome do empregado ");
        employee.setName(name);
    }

    public static void editAddress(Scanner input, Employee employee){
        String address = SystemInputs.readString(input, "Endereço do empregado'");
	    employee.setAddress(address);
    }

    public static void editType(Scanner input, Employee employee, int i){
        switch(i){
            case 1:
                if(!(employee instanceof Salaried)){
                    double salary = SystemInputs.readDouble(input, "Salário ");
                    employee = new Salaried(salary);
                }else{
                    System.out.println("O empregado já é assalariado");
                }
                break;
        
            case 2:
                if(!(employee instanceof Commissioned)){ 
                    double salaryC = SystemInputs.readDouble(input, "Salário ");
                    double commissionPay = SystemInputs.readDouble(input, "Porcentagem da comissão ");
                    employee = new Commissioned(salaryC, commissionPay);
                }else{
                    System.out.println("O empregado já é comissionado");
                }
                break;

            case 3:
                if(!(employee instanceof Hourly)){
                    double hourPay = SystemInputs.readDouble(input, "Hora trabalhada ");
                    employee = new Hourly(hourPay);
                }else{
                    System.out.println("O empregado já é horista");
                }
                break;

            default:
                break;
        }

    }
	
    public static void editPaymentMethod(Scanner input, Employee employee, int i){
        switch(i){
            case 1:
                employee.getPayInfo().setPayMethod(PayMethods.values()[i-1]);
                System.out.println("Mudança feita com sucesso\n" + employee.toString());
                break;
            case 2:
                employee.getPayInfo().setPayMethod(PayMethods.values()[i-1]);
                System.out.println("Mudança feita com sucesso\n" + employee.toString());
                break;
            case 3:
                employee.getPayInfo().setPayMethod(PayMethods.values()[i-1]);
                System.out.println("Mudança feita com sucesso.\n" + employee.toString());
                break;
            default:
                System.out.println("Opção inválida.\n");
                break;
        }
    }
    
    public static void editSyndicateInfo(Scanner input, Employee employee){
        if(employee.getSyndicate()==null || !employee.getSyndicate().getActive()){
            System.out.println("O empregado não é sindicalista, gostaria de adicionar? 1- Sim\n 2- Não\n");
            int o = SystemInputs.readInt(input, "");
            if(o == 1){                        
                double syndFees = SystemInputs.readDouble(input, "Taxa por membro ");
                Syndicate syndicateMember = new Syndicate(employee.getId(), syndFees, true);
                employee.setSyndicate(syndicateMember);
            }else{
                return;
            }
        }else{            
            System.out.println("O empregado é sindicalista, gostaria desligar? 1- Sim\n 2- Não\n");
            int o = SystemInputs.readInt(input, "");
            if(o == 1){                        
                employee.getSyndicate().setActive(false);
            }else{
                return;
            }

        }
        
    }
    
}