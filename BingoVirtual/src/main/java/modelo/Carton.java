/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dylan
 */
public class Carton {
  private int[][] matrizNumeros;
  private String identificador;
  private static final List<String> identificadoresGenerados = new ArrayList<>();
  

    public Carton(int[][] pMatrizNumeros, String pIdentificador) {
        setMatrizNumeros(pMatrizNumeros);
        setIdentificador(pIdentificador);
    }

    public int[][] getMatrizNumeros() {
        return matrizNumeros;
    }

    public void setMatrizNumeros(int[][] matrizNumeros) {
        this.matrizNumeros = new int[5][5];
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
  

  
}
