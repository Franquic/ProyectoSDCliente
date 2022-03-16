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
        sn.useDelimiter("\n");

        String numeroCuenta = sn.next();
        try {
            out.writeUTF(numeroCuenta);
        } catch (IOException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

        int opcion = 0;
        boolean salir = false;
        while (!salir) {

            try {
                // Menu de opciones del cliente de un banco
                
                System.out.println("1. Retiro");
                System.out.println("2. Deposito");
                System.out.println("3. Transferencia mismo banco");
                System.out.println("4. Transferencia a otros bancos");
                System.out.println("5. Operaciones Banco B");
                System.out.println("6. Operaciones Banco C");
                System.out.println("7. Salir");

                opcion = sn.nextInt();
                out.writeInt(opcion);
               
                switch (opcion) {
                    case 1:
                        double monto;
                        System.out.println("Ingrese el monto a retirar");
                        monto = sn.nextDouble();
                        out.writeDouble(monto);
                        System.out.println(in.readUTF());
                        System.out.println(in.readUTF());
                        break;
                    case 2:
                        double montoDeposito;
                        System.out.println("Ingrese el monto a depositar");
                        montoDeposito = sn.nextDouble();
                        out.writeDouble(montoDeposito);
                        System.out.println(in.readUTF());
                        System.out.println(in.readUTF());
                        break;
                    case 3:
                        double montoTransferencia;
                        String numeroCuenta2;
                        System.out.println("Ingrese el monto a transferir");
                        montoTransferencia = sn.nextDouble();
                        out.writeDouble(montoTransferencia);
                        System.out.println("Ingrese el numero de cuenta a transferir");
                        numeroCuenta2 = sn.next();
                        out.writeUTF(numeroCuenta2);
                        System.out.println(in.readUTF());
                        System.out.println(in.readUTF());
                        break;
                    case 4:
                        double montoTransferenciaOt;
                        String numeroCuentaOt;
                        System.out.println("Ingrese el monto a transferir");
                        montoTransferenciaOt = sn.nextDouble();
                        out.writeDouble(montoTransferenciaOt);
                        System.out.println("Ingrese el numero de cuenta a transferir");
                        numeroCuentaOt = sn.next();
                        out.writeUTF(numeroCuentaOt);
                        break;
                    case 5:
                        String numeroCuentaB;
                        System.out.println("Ingrese su numero de cuenta de Banco B");
                        numeroCuentaB = sn.next();
                        out.writeUTF(numeroCuentaB);
                        break;
                    case 6:
                        String numeroCuentaC;
                        System.out.println("Ingrese su numero de cuenta de Banco C");
                        numeroCuentaC = sn.next();
                        out.writeUTF(numeroCuentaC);
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
