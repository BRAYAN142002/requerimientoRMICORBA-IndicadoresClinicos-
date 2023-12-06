
package cliente.servicios;
import static cliente.Utilidades.UtilidadesConsola.leerCadena;
import static cliente.Utilidades.UtilidadesConsola.leerEntero;
import cliente.Utilidades.UtilidadesRegistroC;
import cliente.controladores.ControladorCallBackImpl;
import java.rmi.RemoteException;
import servidoralertas.controladores.ControladorGestorNotificacionInt;
/**
 *
 * @author brayan
 */
public class ClienteDeObjetos {

    public static void main(String[] args) throws RemoteException {
      int numPuertoRMIRegistry = 0;
      String direccionIpRMIRegistry = "";     
      
      
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry =leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = leerEntero(); 
        
         ControladorCallBackImpl objRemoto= new ControladorCallBackImpl();
         ControladorGestorNotificacionInt objRemotoServidor=
                (ControladorGestorNotificacionInt)
                UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorNotificacion");
        objRemotoServidor.registrarReferenciaRemota(objRemoto);
        System.out.println("Esperando notificaciones");
    }
}
