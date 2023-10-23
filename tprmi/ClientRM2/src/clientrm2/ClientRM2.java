/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrm2;

import daao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ClientRM2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            IDao<Machine> dao1 = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao1");
            IDao<Salle> dao2 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
            Salle c1=new Salle("c1");
            Salle c2=new Salle("c2");
            Salle c3=new Salle("c3");
            dao2.create(c3);
            dao2.create(c1);
            dao2.create(c2);
            for(Salle s:dao2.findAll()){
                System.out.println(s);
            }
            dao1.create(new Machine("M1","DELL",5900,c3));
            dao1.create(new Machine("M2","HP",3900,c2));
            dao1.create(new Machine("M3","THINKPAD",5500,c1));
            
            for(Machine  m  : dao1.findAll())
                System.out.println(m);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRM2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRM2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRM2.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

}
