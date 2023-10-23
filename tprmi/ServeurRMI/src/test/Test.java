/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import daao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String[] args) {
        try {
           // HibernateUtil.getSessionFactory();
            
            IDao<Machine> dao1 =new MachineService();
             IDao<Salle> dao2 =new SalleService();
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
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
        
    
}
