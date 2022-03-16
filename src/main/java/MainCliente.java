
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raith
 */
public class MainCliente {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            System.out.println("-->  Ingrese Bienvenido al Banco A:");

            boolean salir = false;
            while (!salir) {
                System.out.println(">> Eliga una opción:");
                System.out.println(">> 1) Operaciones de manera Local");
                System.out.println(">> 2) Operaciones en Banco B");
                System.out.println(">> 3) Operaciones en Banco C");
                System.out.println(">> 4) Salir");

                int opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        Cliente clienteA = new Cliente("192.168.0.18", 50001);
                        clienteA.start();
                        clienteA.join();
                        break;
                    case 2:
                        Cliente clienteB = new Cliente("192.168.0.25", 50002);
                        clienteB.start();
                        clienteB.join();
                        break;
                    case 3:
                        Cliente clienteC = new Cliente("192.168.0.55", 50003);
                        clienteC.start();
                        clienteC.join();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
