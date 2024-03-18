/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author byron
 */
public class Jugador {
    
    String nombreJugador;
    int dineroJugador;
    int posicionJugador;
    boolean enCarcel;
    
    //Constructor 
    public Jugador(String nombreJugador, int dineroJugador, int posicionJugador){
        this.nombreJugador = nombreJugador;
        this.dineroJugador = dineroJugador;
        this.posicionJugador = posicionJugador;
    }
    
    //Métodos
    
     //Metodo para comprobar si el jugador está en bancarrota
    public boolean checkBancarrota(){
        boolean result = false;
        if(dineroJugador <= 0){
                System.out.println("Estas en bancarrota! ¡Game Over!");
                result = true;
            }
        return result;
    }
    
    
    
    
}
