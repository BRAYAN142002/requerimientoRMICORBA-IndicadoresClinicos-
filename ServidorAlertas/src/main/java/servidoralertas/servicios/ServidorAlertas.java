/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package servidoralertas.servicios;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidoralertas.controladores.ControladorGestorIndicadoresImpl;
import servidoralertas.controladores.ControladorGestorIndicadoresInt;
import servidoralertas.controladores.ControladorGestorNotificacionImpl;
import servidoralertas.repositorio.PacienteRepositorioImpl;
import servidoralertas.utilidadades.UtilidadesConsola;
import static servidoralertas.utilidadades.UtilidadesConsola.leerCadena;
import static servidoralertas.utilidadades.UtilidadesConsola.leerEntero;
import servidoralertas.utilidadades.UtilidadesRegistroS;

/**
 *
 * @author brayan
 */
public class ServidorAlertas {

    public static void main(String[] args)throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry ");
        direccionIpRMIRegistry = leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
        numPuertoRMIRegistry = leerEntero(); 
        
        //Crear el repositorio
        PacienteRepositorioImpl objPacienteRepositoryImpl=new PacienteRepositorioImpl();
       //crear objet remoto
        ControladorGestorNotificacionImpl objControladorGestorNotificaciones=new ControladorGestorNotificacionImpl ();
        ControladorGestorIndicadoresImpl objRemotoGestionIndicadres=new 
        ControladorGestorIndicadoresImpl(objPacienteRepositoryImpl,objControladorGestorNotificaciones);
        try{
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto((Remote)objRemotoGestionIndicadres, direccionIpRMIRegistry, numPuertoRMIRegistry, "objServicioGestionPacientes");
        UtilidadesRegistroS.RegistrarObjetoRemoto((Remote)objControladorGestorNotificaciones,direccionIpRMIRegistry, numPuertoRMIRegistry,"idGestorNotificacion" );
        }catch(Exception e){
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
