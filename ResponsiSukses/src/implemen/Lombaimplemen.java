/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implemen;

/**
 *
 * @author Lab Informatika
 */

import java.util.List;
import model.datalomba;
public interface Lombaimplemen {
    public void insert(datalomba data);
    public void update(datalomba data);
    public void delete(int id);
    public List<datalomba> getAll();
    public List<datalomba> cariJudul(datalomba data);
    public List<datalomba> cariAlur(datalomba data);
    public List<datalomba> cariOrisinalitas(datalomba data);
    public List<datalomba> cariPemilihan(datalomba data);
    public List<datalomba> cariNilai(datalomba data);
}
