/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import java.util.*;
import konektor.Konektordb;
import model.*;
import implemen.Lombaimplemen;
import javax.swing.JTable;
import frame.Main;
import lombaDAO.LombaDAO;
/**
 *
 * @author Lab Informatika
 */
public class Lombacontroller {
    Main main;
    Lombaimplemen pimplemen;
    List<datalomba> data;
    
    public Lombacontroller(Main main){
        this.main = main;
        pimplemen = new LombaDAO();
        data = pimplemen.getAll();
    }
    
    public void isitabel(){
        data = pimplemen.getAll();
        modeltabeldata mu = new modeltabeldata(data);
        main.getjTable1().setModel(mu);
    }
    public void insert(){
        datalomba data = new datalomba();
        data.setJudul(main.getjTextField1().getText());
        data.setAlur(Integer.parseInt(main.getjTextField2().getText()));
        data.setOrisinalitas(Integer.parseInt(main.getjTextField3().getText()));
        data.setPemilihan(Integer.parseInt(main.getjTextField4().getText()));
        pimplemen.insert(data);
    }
    public void update(){
        datalomba data = new datalomba();
        data.setJudul(main.getjTextField1().getText());
        data.setAlur(Integer.parseInt(main.getjTextField2().getText()));
        data.setOrisinalitas(Integer.parseInt(main.getjTextField3().getText()));
        data.setPemilihan(Integer.parseInt(main.getjTextField4().getText()));
        pimplemen.update(data);
    }
    public void delete(){
        int id = Integer.parseInt(main.getjTextField3().getText());
        pimplemen.delete(id);
    }
}
