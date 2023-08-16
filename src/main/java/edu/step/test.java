package edu.step;

import java.util.Scanner;

public class test {

    //    public void getEmployeeById (int id, String nume,String departament,double salariu){
//        try {
//            Connection connection = getConnection();
//
//            String sql = "SELECT * FROM employees WHERE  id = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1,id);//
//
//            ResultSet rezultatulInterogarii = statement.executeQuery();
//
//            while(rezultatulInterogarii.next()){
//
//                id = rezultatulInterogarii.getInt(id);
//
//                System.out.println("Persoana cautata dupa id = "+id+" :: "+nume+" "+departament+" "+salariu+" ");
//                connection.close();
//
//            }
//
//
//        }catch (SQLException ex){
//            System.out.println("nu am putut executa operatia de cautare \n"+ex.getMessage());
//        }
//    }
//
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("1. Afișează ceva");
                    System.out.println("2. Curăță ecranul");
                    System.out.println("0. Ieși");

                    System.out.print("Alege o opțiune: ");
                    int option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            // Afisare normala
                            System.out.println("Afișez ceva...");
                            break;
                        case 2:
                            // "Curatare" prin afisare de linii goale
                            for (int i = 0; i < 50; i++) {
                                System.out.println();
                            }
                            System.out.println("Ecranul a fost curățat.");
                            break;
                        case 0:
                            System.out.println("La revedere!");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Opțiune invalidă!");
                            break;
                    }
                }
            }
        }



