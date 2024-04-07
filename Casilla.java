/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Byron Aurelio Panimboza Urresto
 */
public class Casilla {
    
    String nombreCasilla;
    String colorCasilla;
    String [] casillaSuerte = {"Has ganado un premio en el concurso de belleza. Recibe 20 MM", "Hoy es tu cumpleaños. Recibe 10 MM de tu oponente", "Recibes una multa de tráfico. Paga 10 MM"};
    boolean dueño = false;
    int id_dueño;
    
    
    public Casilla(String nombreCasilla, String colorCasilla){
        this.nombreCasilla = nombreCasilla;
        this.colorCasilla = colorCasilla;
    }
    
    public int casillaSuerte(){
        int num = (int)Math.random()*3;
        System.out.println(casillaSuerte[num]);
        return num;
    }
    /*
    public String toString(){
        return "[" + nombreCasilla + "]";
    }
    */
    
    
    
    
}
