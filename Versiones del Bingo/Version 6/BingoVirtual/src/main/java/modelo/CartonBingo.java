/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author dylan
 */
public class CartonBingo {
    private final int[][] matrizNumeros;
    private final String identificador;
    private static final List<String> identificadoresGenerados = new ArrayList<>();
    
    public CartonBingo() {
        this.matrizNumeros = new int[5][5];
        this.identificador = generarIdentificadorUnico();
        generarCarton();
    }

    // Método para obtener la matriz de números del cartón
    public int[][] getMatrizNumeros() {
        return matrizNumeros;
    }

    // Método para obtener el identificador del cartón
    public String getIdentificador() {
        return identificador;
    }    
    
    private String generarIdentificadorUnico() {
        String nuevoIdentificador;
        do {
            nuevoIdentificador = generarIdentificador();
        } while (identificadoresGenerados.contains(nuevoIdentificador));

        identificadoresGenerados.add(nuevoIdentificador);
        return nuevoIdentificador;
    }

    private String generarIdentificador() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Cadena de letras
        String numeros = "0123456789"; // Cadena de números
        StringBuilder id = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            char letra = letras.charAt(random.nextInt(letras.length()));
            id.append(letra);
        }

        for (int i = 0; i < 3; i++) {
            char numero = numeros.charAt(random.nextInt(numeros.length()));
            id.append(numero);
        }    

        return id.toString();
        }

    private void generarCarton() {
        Random random = new Random();


        // Llena la columna "B" con números aleatorios del 1 al 15
        for (int i = 0; i < 5; i++) {
            matrizNumeros[i][0] = random.nextInt(15) + 1;
        }

        // Llena la columna "I" con números aleatorios del 16 al 30
        for (int i = 0; i < 5; i++) {
            matrizNumeros[i][1] = random.nextInt(15) + 16;
        }

        // Llena la columna "N" con números aleatorios del 31 al 45 (dejando el centro en blanco)
        for (int i = 0; i < 5; i++) {
            matrizNumeros[i][2] = random.nextInt(15) + 31;
        }
        matrizNumeros[2][2] = 0; // Deja el centro en blanco

        // Llena la columna "G" con números aleatorios del 46 al 60
        for (int i = 0; i < 5; i++) {
            matrizNumeros[i][3] = random.nextInt(15) + 46;
        }

        // Llena la columna "O" con números aleatorios del 61 al 75
        for (int i = 0; i < 5; i++) {
            matrizNumeros[i][4] = random.nextInt(15) + 61;
        }
        
        // Lógica para generar la imagen del cartón en formato PNG
        int width = 350;  // Ancho de la imagen
        int height = 350;  // Alto de la imagen

        // Crear una imagen en blanco con fondo blanco
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Dibujar el borde negro
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1); // -1 para que el borde esté completamente dentro de la imagen

        // Dibujar la estructura del cartón
        int cellWidth = width / 5;
        int cellHeight = (height - 50) / 6;
        g.setColor(Color.BLACK);

        // Dibujar las líneas horizontales
        for (int i = 0; i <= 6; i++) {
            g.drawLine(0, i * cellHeight, width, i * cellHeight);
        }

        // Dibujar las líneas verticales
        for (int i = 0; i <= 5; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, height - 50);
        }

        // Dibujar las letras "B I N G O" en la primera fila
        String[] letras = {"B", "I", "N", "G", "O"};
        for (int i = 0; i < 5; i++) {
            String letra = letras[i];
            int x = i * cellWidth + cellWidth / 2 - 5; // Ajusta el valor -5 para centrar mejor
            int y = cellHeight - 20; // Ajusta el valor -10 para escribir una fila más abajo
            g.drawString(letra, x, y);
        }

        // Dibujar los números en cada celda
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numero = matrizNumeros[j][i];
                String numeroStr = numero == 0 ? " " : String.valueOf(numero);  // "F" en lugar de 0
                int x = i * cellWidth + cellWidth / 2 - 5; // Ajusta el valor -5 para centrar mejor
                int y = (j + 1) * cellHeight + cellHeight / 2 + 5; // Ajusta el valor +5 para centrar mejor y una fila más abajo
                g.drawString(numeroStr, x, y);
            }
        }
        
        // Dibujar el identificador en la última fila
        g.drawString("Identificador: " + identificador, 100, height - 20);

        // Guardar la imagen en formato PNG
        try {
            File imagenFile = new File("src/main/java/modelo/Cartones/Imagenes/" + identificador + ".png");
            ImageIO.write(image, "png", imagenFile);
        } catch (IOException e) {
            e.printStackTrace();
        }     
    } 
}


