import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

        Scanner sn = new Scanner(System.in);

        String mensaje;
        int opcion = 0;
        boolean salir = false;
        while (!salir) {

            try {
                System.out.println("1. Ingresar Datos de Cuenta, Monto y OP");
                System.out.println("6. Salir");

                opcion = sn.nextInt();
                out.writeInt(opcion);

                switch (opcion) {
                    case 1:

                        String numeroCuenta;
                        double monto;
                        String tipo;

                        System.out.println("Enviare datos al Servidor");
                        //Envio al ServidorHilo 003
                        System.out.println("Ingrese el numero de cuenta");
                        numeroCuenta = sn.next();
                        out.writeUTF(numeroCuenta);
                        //Envio al ServidorHilo 004
                        System.out.println("Ingrese el monto");
                        monto = sn.nextDouble();
                        out.writeDouble(monto);
                        //Envio al Servidor 005
                        System.out.println("Ingrese el tipo de operacion");
                        tipo = sn.next();
                        out.writeUTF(tipo);

                        mensaje = in.readUTF();
                        System.out.println(mensaje);

                        break;
                    case 6:
                        salir = true;

                        break;
                    default:
                        mensaje = in.readUTF();
                        System.out.println(mensaje);

                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
