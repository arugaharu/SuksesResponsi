/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lab Informatika
 */

import java.util.List;
import javax.swing.table.AbstractTableModel;
public class modeltabeldata extends AbstractTableModel{
     List<datalomba> data;
   public modeltabeldata(List<datalomba> data) {
        this.data = data;
    }
    
     @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

     @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return data.get(row).getJudul();
            case 1:
                return data.get(row).getAlur();
            case 2:
                return data.get(row).getOrisinalitas();
            case 3:
                return data.get(row).getPemilihan();
            case 4:
                return data.get(row).getNilai();
            default:
                return null;
                
        }
    }
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Orisinalitas";
            case 3:
                return "Pemilihan";
            case 4:
                return "nilai";
            default:
                return null;
            
        }
    }
    
}
