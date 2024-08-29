package tests;
import enums.GameGenreEnum;
import models.Game;
import dao.GameDao;

import java.util.Scanner;


public class Tests {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Menu" +
                "\n0- Exit" +
                "\n1- Register" +
                "\n2- Listar" +
                "\n3- Consultar por codigo" +
                "\n4- Consult by xxxx" +
                "\n5- Alterar" +
                "\n6- Excluir" +
                "\nDigite a operação desejada: ");
        int option = leitor.nextInt();
        switch (option){
            case 0:
                System.out.println("Sair");
                break;
            case 1:
                System.out.println("\n1- Cadastrar");
                break;
            case 2:
                System.out.println("\n2- Listar");
                break;
            case 3:
                System.out.println("\n3- Consultar por codigo");
                break;
            case 4:
                System.out.println("\n4- Consult by :"
                        +"\n Gener == 1" +
                                "\n year == 2" +
                                "\n Title == 3" +
                                "\n developer == 4" +
                                "\n id == 5" +
                                "\n publisher == 6" +
                                "\nDigite a operação desejada: "
                        );
                int option2 = leitor.nextInt();
                switch (option2){
                    case 1:
                        System.out.println("\n Gener == 1");
                        break;
                    case 2:
                        System.out.println("\n year == 2");
                        break;
                    case 3:
                        System.out.println("\n Title == 3");
                        break;
                    case 4:
                        System.out.println( "\n developer == 4");
                        break;
                    case 5:
                        System.out.println("\n id == 5");
                        break;
                    case 6:
                        System.out.println("\n publisher == 6");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                break;
            case 5:
                System.out.println("\n5- Alterar");

                break;
            case 6:
                System.out.println("\n6- Excluir");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}

//SUS
