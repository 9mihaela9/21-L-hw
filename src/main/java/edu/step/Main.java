package edu.step;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EmployeesDB db = new EmployeesDB();

        System.out.println(" MENIU ::");
        System.out.println(" 1. Adaugă un angajat nou");
        System.out.println(" 2. Afisează detaliile unnui angajat dupa id");
        System.out.println(" 3. Actualizează detaliile unui angajat");
        System.out.println(" 4. Șterge un angajat dupa ID");
        System.out.println(" 0. Iesire");

        Scanner s = new Scanner(System.in);

        boolean shouldExit = false;
        while (!shouldExit) {

            int option = s.nextInt();
            s.nextLine();
            switch (option){
                case 1 :
                    System.out.println(" insereaza numele : ");
                    String numeCreat = s.nextLine();
                    //s.nextLine(); // Bufer -> ?
                    System.out.println(" insereaza departament : ");
                    String departamentCreat = s.nextLine();
                    System.out.println(" insereaza salariul : ");
                    double salariuCreat = s.nextDouble();

                    db.createEmployee(numeCreat,departamentCreat,salariuCreat);
                    break;

                case 2 :
                    System.out.println(" insereaza ID-ul dupa care se va efectua cautarea  persoanei : ");
                    int idSerchBy = s.nextInt();

                    db.getEmployeeById(idSerchBy);

                    break;

                case 3 :
                    System.out.println(" insereaza id ");
                    int idSet = s.nextInt();
                    // Consume the newline character left in the buffer:
                    s.nextLine(); // pentru Buferr -> ??

                    System.out.println(" insereaza actualizeaza NUMELE ");
                    String numeUpdate = s.nextLine();
                   // s.nextLine();  // pentru Buferr -> ?? -> case 1
                    System.out.println(" insereaza actualizeaza DEPARTAMENT ");
                    String depatamentUpdate = s.nextLine();
                    System.out.println(" insereaza actualizeaza SALARIUL ");
                    double salariuUpdate = s.nextDouble();

                    // UPDATE -????
                    db.updateEmployee(idSet,numeUpdate,depatamentUpdate,salariuUpdate);
                    break;

                case 4 :
                    System.out.println(" insereaza id-ul carui angajat doresti sa il stergi");
                    int idDelete = s.nextInt();

                    db.deleteEmployeById(idDelete);
                    break;

                case 0 :
                    System.out.println("Ieșire din aplicație.");
                    shouldExit = true;
                    break;

                default:
                    System.out.println("Introducerea datelor a eșuat :(");
            }

        }
//        db.create("dfdf","fdfd",55);
//        db.create("rtjy","yyt",55);

//        db.getEmployeeById(1);

//        db.updateEmployee(1,"Ann","manager",15677);

//        db.delete(2);

    }

}