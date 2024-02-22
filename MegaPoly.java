/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package megapoly;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class MegaPoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int dado;
        boolean bancarrota = false;
        
        //Pedimos los nombres de los jugadores
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombnre del primer jugador: ");
        //String player1 = sc.nextLine();
        Jugador player1 = new Jugador(sc.nextLine(), 100, 0);
        System.out.println("Introduce el nombnre del segundo jugador: ");
        //String player2 = sc.nextLine();
        Jugador player2 = new Jugador(sc.nextLine(), 100, 0);
        
        System.out.println("Jugador 1: " + player1.nombreJugador);
        System.out.println("Jugador 2: " + player2.nombreJugador);
        
        //System.out.println("Dado:" + tirarDado());
        
        //Array donde se van a situar las casillas del tablero
        Casilla [] casillas = new Casilla[16];
        
        casillas [0] = new Casilla("0: Inicio", "Negro");
        casillas [1] = new Casilla("1: Getafe", "Rojo");
        casillas [2] = new Casilla("2: Impuesto", "Amarillo");
        casillas [3] = new Casilla("3: Valdemoro", "Rojo");
        casillas [4] = new Casilla("4: Carcel", "Azul");
        casillas [5] = new Casilla("5: Ciempozuelos", "Rojo");
        casillas [6] = new Casilla("6: Suerte", "Morado");
        casillas [7] = new Casilla("7: Aranjuez", "Rojo");
        casillas [8] = new Casilla("8: Parking", "Blanco");
        casillas [9] = new Casilla("9: Fuenlabrada", "Rojo");
        casillas [10] = new Casilla("10: Impuesto", "Amarillo");
        casillas [11] = new Casilla("11: Parla", "Rojo");
        casillas [12] = new Casilla("12: Ve a la Carcel", "Azul");
        casillas [13] = new Casilla("13: Pinto", "Rojo");
        casillas [14] = new Casilla("14: Suerte", "Morado");
        casillas [15] = new Casilla("15: Alcalá de Henares", "Rojo");

         
        //Turnos
        for(int i = 1; !bancarrota; i++){
            System.out.println("\n--- Turno " + i + " ---");
            
            //Jugador 1
            dado = tirarDado();
            System.out.println("El jugador " + player1.nombreJugador + " obtiene un " + dado);
            System.out.println("*Se mueve la ficha por el tablero*");
            
             if((player1.posicionJugador + dado) > 16 && i != 1){
                System.out.println("Has pasado por la casilla de Inicio. Obtienes 20 MM");
                player1.dineroJugador += 20;
            }
            
            player1.posicionJugador = (player1.posicionJugador + dado) % 16;
            
            if(player1.posicionJugador == 2 || player1.posicionJugador == 10){
                System.out.println("Impuesto!. Paga 10MM a la Banca");
                player1.dineroJugador -= 10;
            }
                
            
            System.out.println(casillas[player1.posicionJugador].nombreCasilla);
            System.out.println("Dinero " + player1.nombreJugador + ": " + player1.dineroJugador);
            if(player1.dineroJugador <= 0){
                System.out.println("Estas en bancarrota! ¿Game Over!");
                bancarrota = true;
            }
                    
            //Jugador 2
            dado = tirarDado();
            System.out.println("El jugador " + player2.nombreJugador + " obtiene un " + dado);
            System.out.println("*Se mueve la ficha por el tablero*");
            
            if((player2.posicionJugador + dado) > 16 && i != 1){
                System.out.println("Has pasado por la casilla de Inicio. Obtienes 20 MM");
                player2.dineroJugador += 20;
            }
            
            player2.posicionJugador = (player2.posicionJugador + dado) % 16;
            
             if(player2.posicionJugador == 2 || player2.posicionJugador == 10){
                System.out.println("Impuesto!. Paga 10MM a la Banca");
                player2.dineroJugador -= 10;
            }
           
            System.out.println(casillas[player2.posicionJugador].nombreCasilla);
            System.out.println("Dinero " + player2.nombreJugador + ": " + player2.dineroJugador);
            if(player2.dineroJugador <= 0){
                System.out.println("Estas en bancarrota! ¿Game Over!");
                bancarrota = true;
            }
        }
    }
    //Método tirar el dado que utilzará cada jugador en cada turno
    public static int tirarDado(){
        return (int) ((Math.random() * 6)+1);
    }
    
    //public static int 
    
}
