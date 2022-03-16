import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {
    
    private String direccionIP;
    private int puerto;
    
    public Cliente(String IP,int puerto){
        this.direccionIP = IP;
        this.puerto = puerto;
    }

    /**
     *
     */
    public void run() {
          System.out.println("No entro al Try");
        try {
            System.out.println("Entre al Try");
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            
            Socket sc = new Socket(direccionIP, puerto);
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            // Leer mensaje del servidor
            String mensaje = in.readUTF();
            System.out.println(mensaje);

            System.out.println(in.readUTF());
            
            // Escribe el numero de cuenta y se lo manda al servidor
    
            
            // ejecutamos el hilo
            ClienteHilo hilo = new ClienteHilo(in, out);
            hilo.start();
            hilo.join();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }
    
}
