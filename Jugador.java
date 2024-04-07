package megapoly;

/**
 *
 * @author Byron Aurelio Panimboza Urresto
 */
public class Jugador {
    
    String nombreJugador;
    int dineroJugador;
    int posicionJugador;
    boolean enCarcel, bancarrota = false;
    
    //Constructor 
    public Jugador(String nombreJugador, int dineroJugador, int posicionJugador){
        this.nombreJugador = nombreJugador;
        this.dineroJugador = dineroJugador;
        this.posicionJugador = posicionJugador;
        enCarcel = false;
    }
    
    //Métodos
    
     //Metodo para comprobar si el jugador está en bancarrota
    public boolean checkBancarrota(){
        if(dineroJugador <= 0){
                System.out.println("Estas en bancarrota! ¡Game Over!");
                bancarrota = true;
            }
        return bancarrota;
    }
    
    
    
    
}
