

package servidoralertas.controladores;
import cliente.controladores.ControladorCallBackInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author brayan
 */
public interface ControladorGestorNotificacionInt {
     public boolean registrarReferenciaRemota(ControladorCallBackInt referencia)throws RemoteException;
}
