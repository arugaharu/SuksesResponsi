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
public class datalomba {
    private String judul;
    private Integer alur ;
    private Integer orisinalitas;
    private Integer pemilihan_kata;
    private Integer nilai;

    
    public Integer getAlur() {
        return alur;
    }

    public void setAlur(Integer alur) {
        this.alur = alur;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Integer getOrisinalitas() {
        return orisinalitas;
    }

    public void setOrisinalitas(Integer orisinalitas) {
        this.orisinalitas = orisinalitas;
    }
    
    public Integer getPemilihan() {
        return pemilihan_kata;
    }

    public void setPemilihan(Integer pemilihan_kata) {
        this.pemilihan_kata = pemilihan_kata;
    }
    
     public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }
    
}
