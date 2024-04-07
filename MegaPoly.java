package megapoly;
/**
 *
 * @author Byron Aurelio Panimboza Urresto
 */
public class MegaPoly {

    private static Inicio screen;
    private static Pantalla pt;      

    // Metodo que se ejecuta cuando en la pantalla de inicio le damos al boton de nueva partida
    public static void nuevaPartida(String texto1, String texto2) {

        int dado;
        int posicion1, posicion2, posInicial;

        pt = new Pantalla(texto1, texto2);
        pt.setVisible(true);
        pt.setTitle("MegaPoly");

        pt.mensajeInicio();
        
        
        Jugador player1 = new Jugador(pt.getPlayer1(), pt.getMoney1(), 0);
        Jugador player2 = new Jugador(pt.getPlayer2(), pt.getMoney2(), 0);

        
        //Array donde se van a situar las casillas del tablero
        Casilla[] casillas = new Casilla[16];

        casillas[0] = new Casilla("0: Inicio", "Negro");
        casillas[1] = new Casilla("1: Getafe", "Rojo");
        casillas[2] = new Casilla("2: Impuesto", "Amarillo");
        casillas[3] = new Casilla("3: Valdemoro", "Rojo");
        casillas[4] = new Casilla("4: Carcel", "Azul");
        casillas[5] = new Casilla("5: Ciempozuelos", "Rojo");
        casillas[6] = new Casilla("6: Suerte", "Morado");
        casillas[7] = new Casilla("7: Aranjuez", "Rojo");
        casillas[8] = new Casilla("8: Parking", "Blanco");
        casillas[9] = new Casilla("9: Fuenlabrada", "Rojo");
        casillas[10] = new Casilla("10: Impuesto", "Amarillo");
        casillas[11] = new Casilla("11: Parla", "Rojo");
        casillas[12] = new Casilla("12: Ve a la Carcel", "Azul");
        casillas[13] = new Casilla("13: Pinto", "Rojo");
        casillas[14] = new Casilla("14: Suerte", "Morado");
        casillas[15] = new Casilla("15: Alcalá de Henares", "Rojo");

        
        //Turnos
        for (int i = 1; !player1.checkBancarrota() && !player2.checkBancarrota(); i++) {
            
            //System.out.println("\n--- Turno " + i + " ---");
            pt.setTurno(i);
           

            //Jugador 1
            
            //System.out.println("- Jugador 1 - ");
            pt.turnoJugador(1);
            //Azul - Carcel
            if (player1.posicionJugador == 4 && player1.enCarcel == true) {
                /*System.out.println("Carcel!. No puedes salir hasta que saques un 5");*/
                pt.MensajeCarcel();
                
                //Tiramos dado para tratar de salir de la carcel
                dado = tirarDado();
                pt.setDado(dado);
                //System.out.println("Tiramos dado y sale un: " + dado);
                if (dado == 5) {
                    //System.out.println("¡Has sacado un 5!. Puedes salir de la carcel");
                    pt.puedesSalirCarcel();
                    player1.enCarcel = false;
                    
                } else {
                    //System.out.println("¡Mala suerte, espera el próximo turno!");
                    pt.noSalesCarcel();
                }
            }
            
            //Inicio turno
            if (player1.enCarcel == false) {
                
                pt.tiraElDado();
                /*
                try{
                    dadoLatch.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                */
                dado = tirarDado();
                pt.setDado(dado);
              
                //System.out.println("El jugador " + player1.nombreJugador + " obtiene un " + dado);
                //System.out.println("*Se mueve la ficha por el tablero*");
                

                //Negro - Inicio
                if ((player1.posicionJugador + dado) >= 16 && i != 1) {
                    //System.out.println("Has pasado por la casilla de Inicio. Obtienes 20 MM");
                    pt.casillaSalida();
                    player1.dineroJugador += 20;
                    pt.setMoney1(player1.dineroJugador);
                    
                }
                
                // Ubicar en la nueva posicion la ficha
                posInicial = player1.posicionJugador;
                player1.posicionJugador = (player1.posicionJugador + dado) % 16;
                posicion1 = player1.posicionJugador;
                pt.movimientoFicha1(posInicial, posicion1);

                //Amarillo - Impuesto
                if (posicion1 == 2 || posicion1 == 10) {
                    //System.out.println("Impuesto!. Paga 10MM a la Banca");
                    pt.casillaImpuesto();
                    player1.dineroJugador -= 10;
                    pt.setMoney1(player1.dineroJugador);
                }
                //Morado - Suerte
                if (posicion1 == 6 || posicion1 == 14) {
                    //System.out.println("Suerte!.");
                    
                    
                    //Accion de sacar tarjeta suerte
                    switch (pt.casillaSuerte()) {
                        case 0:
                            player1.dineroJugador += 20;
                            pt.setMoney1(player1.dineroJugador);
                            break;
                        case 1:
                            player1.dineroJugador += 10;
                             pt.setMoney1(player1.dineroJugador);
                            player2.dineroJugador -= 10;
                             pt.setMoney2(player2.dineroJugador);
                            break;
                        case 2:
                            player1.dineroJugador -= 10;
                            pt.setMoney1(player1.dineroJugador);
                            break;
                        default:
                            System.out.println("Error al obtener casilla Suerte");
                            break;
                    }
                }
                if (posicion1 == 12) {
                    //System.out.println("Vas a la carcel");
                    pt.casillaVasCarcel();
                    player1.posicionJugador = 4;
                    player1.enCarcel = true;
                    pt.movimientoFicha1(12,4);
                }
                if (posicion1 == 4) {
                    player1.enCarcel = true;
                }
                
                //Rojo - Apartamentos
                if (casillas[posicion1].colorCasilla.equals("Rojo") && casillas[posicion1].dueño && casillas[posicion1].id_dueño != 1) {
                    //System.out.println("La calle " + casillas[posicion1].nombreCasilla + " ya tiene dueño. Paga 40 MM a su dueño");
                    pt.casillaCalleDueño();
                    player1.dineroJugador -= 40;
                    pt.setMoney1(player1.dineroJugador);
                    player2.dineroJugador += 40;
                    pt.setMoney2(player2.dineroJugador);
                } else if (casillas[posicion1].colorCasilla.equals("Rojo") && !casillas[posicion1].dueño) {
                    //System.out.println("La calle " + casillas[posicion1].nombreCasilla + " no tiene dueño. ¿Quieres comprarla: Y o N?   (Dinero restante " + player1.dineroJugador + ")");
                    //pt.casillaCalleLibre();
                    if(pt.casillaCalleLibre() == 0){
                    //System.out.println("Eres dueño de la calle: " + casillas[posicion1].nombreCasilla);
                    casillas[posicion1].dueño = true;
                    casillas[posicion1].id_dueño = 1;
                    player1.dineroJugador -= 20;
                    pt.setMoney1(player1.dineroJugador);
                    }
                

                }
                /*
                //Final Turno Jugador 1
                //System.out.println(casillas[player1.posicionJugador].toString());
                System.out.println("Dinero " + player1.nombreJugador + ": " + player1.dineroJugador);
                */
                if(player1.checkBancarrota())
                    pt.bancarrota();

            }
            
            /////////////
            //Jugador 2//
            /////////////
          
             //System.out.println("- Jugador 2 - ");
            pt.turnoJugador(2);
            //Azul - Carcel
            if (player2.posicionJugador == 4 && player2.enCarcel == true) {
                /*System.out.println("Carcel!. No puedes salir hasta que saques un 5");*/
                pt.MensajeCarcel();
                
                //Tiramos dado para tratar de salir de la carcel
               dado = tirarDado();
               pt.setDado(dado);
                //System.out.println("Tiramos dado y sale un: " + dado);
                if (dado == 5) {
                    //System.out.println("¡Has sacado un 5!. Puedes salir de la carcel");
                    pt.puedesSalirCarcel();
                    player2.enCarcel = false;
                    
                } else {
                    //System.out.println("¡Mala suerte, espera el próximo turno!");
                    pt.noSalesCarcel();
                }
            }
            
            //Inicio turno
            if (player2.enCarcel == false) {
                
                pt.tiraElDado();
                /*
                try{
                    dadoLatch.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                */
                
                
                
                dado = tirarDado();
                pt.setDado(dado);
                
                //dado = getDado();
              
                //System.out.println("El jugador " + player2.nombreJugador + " obtiene un " + dado);
                //System.out.println("*Se mueve la ficha por el tablero*");
                

                //Negro - Inicio
                if ((player2.posicionJugador + dado) >= 16 && i != 1) {
                    //System.out.println("Has pasado por la casilla de Inicio. Obtienes 20 MM");
                    pt.casillaSalida();
                    player2.dineroJugador += 20;
                    pt.setMoney2(player2.dineroJugador);
                    
                }
                
                // Ubicar en la nueva posicion la ficha
                posInicial = player2.posicionJugador;
                player2.posicionJugador = (player2.posicionJugador + dado) % 16;
                posicion2 = player2.posicionJugador;
                pt.movimientoFicha2(posInicial, posicion2);

                //Amarillo - Impuesto
                if (posicion2 == 2 || posicion2 == 10) {
                    //System.out.println("Impuesto!. Paga 10MM a la Banca");
                    pt.casillaImpuesto();
                    player2.dineroJugador -= 10;
                    pt.setMoney2(player2.dineroJugador);
                }
                //Morado - Suerte
                if (posicion2 == 6 || posicion2 == 14) {
                    //System.out.println("Suerte!.");
                    
                    
                    //Accion de sacar tarjeta suerte
                    switch (pt.casillaSuerte()) {
                        case 0:
                            player2.dineroJugador += 20;
                            pt.setMoney2(player2.dineroJugador);
                            break;
                        case 1:
                            player2.dineroJugador += 10;
                             pt.setMoney2(player2.dineroJugador);
                            player2.dineroJugador -= 10;
                             pt.setMoney1(player1.dineroJugador);
                            break;
                        case 2:
                            player2.dineroJugador -= 10;
                            pt.setMoney2(player2.dineroJugador);
                            break;
                        default:
                            System.out.println("Error al obtener casilla Suerte");
                            break;
                    }
                }
                if (posicion2 == 12) {
                    //System.out.println("Vas a la carcel");
                    pt.casillaVasCarcel();
                    player2.posicionJugador = 4;
                    player2.enCarcel = true;
                    pt.movimientoFicha2(12,4);
                }
                if (posicion2 == 4) {
                    player1.enCarcel = true;
                }
                
                //Rojo - Apartamentos
                if (casillas[posicion2].colorCasilla.equals("Rojo") && casillas[posicion2].dueño && casillas[posicion2].id_dueño != 1) {
                    //System.out.println("La calle " + casillas[posicion2].nombreCasilla + " ya tiene dueño. Paga 40 MM a su dueño");
                    pt.casillaCalleDueño();
                    player2.dineroJugador -= 40;
                    pt.setMoney2(player2.dineroJugador);
                    player1.dineroJugador += 40;
                    pt.setMoney1(player1.dineroJugador);
                } else if (casillas[posicion2].colorCasilla.equals("Rojo") && !casillas[posicion2].dueño) {
                    //System.out.println("La calle " + casillas[posicion1].nombreCasilla + " no tiene dueño. ¿Quieres comprarla: Y o N?   (Dinero restante " + player2.dineroJugador + ")");
                    pt.casillaCalleLibre();
                    //if(sc.nextLine().equals("Y")){
                    //System.out.println("Eres dueño de la calle: " + casillas[posicion2].nombreCasilla);
                    casillas[posicion2].dueño = true;
                    casillas[posicion2].id_dueño = 2;
                    player2.dineroJugador -= 20;
                    pt.setMoney2(player2.dineroJugador);
                    //}

                }
                /*
                //Final Turno Jugador 2
                //System.out.println(casillas[player1.posicionJugador].toString());
                System.out.println("Dinero " + player1.nombreJugador + ": " + player1.dineroJugador);
                */
                if(player2.checkBancarrota())
                    pt.bancarrota();

            }
            
            
        }

    }

    //Método tirar el dado que utilzará cada jugador en cada turno
    public static int tirarDado() {
        return (int) ((Math.random() * 6) + 1);
    }
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        screen = new Inicio();
        screen.setVisible(true);
        screen.setLocationRelativeTo(null);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Código del juego completo a traves de la terminal
        
        /*
        int dado;
        int posicion1, posicion2;
        */
        
        /*
        //Pedimos los nombres de los jugadores
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del primer jugador: ");
        //String player1 = sc.nextLine();
        Jugador player1 = new Jugador(sc.nextLine(), 100, 0);
        System.out.println("Introduce el nombre del segundo jugador: ");
        //String player2 = sc.nextLine();
        Jugador player2 = new Jugador(sc.nextLine(), 100, 0);
        
        System.out.println("Jugador 1: " + player1.nombreJugador);
        System.out.println("Jugador 2: " + player2.nombreJugador);
         */
        
        /*
        Jugador player1 = new Jugador(pt.getPlayer1(), pt.getMoney1(), 0);
        Jugador player2 = new Jugador(pt.getPlayer2(), pt.getMoney2(), 0);

        //Array donde se van a situar las casillas del tablero
        Casilla[] casillas = new Casilla[16];

        casillas[0] = new Casilla("0: Inicio", "Negro");
        casillas[1] = new Casilla("1: Getafe", "Rojo");
        casillas[2] = new Casilla("2: Impuesto", "Amarillo");
        casillas[3] = new Casilla("3: Valdemoro", "Rojo");
        casillas[4] = new Casilla("4: Carcel", "Azul");
        casillas[5] = new Casilla("5: Ciempozuelos", "Rojo");
        casillas[6] = new Casilla("6: Suerte", "Morado");
        casillas[7] = new Casilla("7: Aranjuez", "Rojo");
        casillas[8] = new Casilla("8: Parking", "Blanco");
        casillas[9] = new Casilla("9: Fuenlabrada", "Rojo");
        casillas[10] = new Casilla("10: Impuesto", "Amarillo");
        casillas[11] = new Casilla("11: Parla", "Rojo");
        casillas[12] = new Casilla("12: Ve a la Carcel", "Azul");
        casillas[13] = new Casilla("13: Pinto", "Rojo");
        casillas[14] = new Casilla("14: Suerte", "Morado");
        casillas[15] = new Casilla("15: Alcalá de Henares", "Rojo");

        //Turnos
        for (int i = 1; !player1.checkBancarrota() && !player2.checkBancarrota(); i++) {
            System.out.println("\n--- Turno " + i + " ---");
            pt.setTurno(i);

            //Jugador 1
            System.out.println("- Jugador 1 - ");
            //Azul - Carcel
            if (player1.posicionJugador == 4 && player1.enCarcel == true) {
                //System.out.println("Carcel!. No puedes salir hasta que saques un 5");
                pt.MensajeCarcel();

                //Tiramos dado para tratar de salir de la carcel
                dado = tirarDado();
                System.out.println("Tiramos dado y sale un: " + dado);
                if (dado == 5) {
                    System.out.println("¡Has sacado un 5!. Puedes salir de la carcel");
                    player1.enCarcel = false;
                } else {
                    System.out.println("¡Mala suerte, espera el próximo turno!");
                }
            }
            //Inicio turno
            if (player1.enCarcel == false) {

                dado = tirarDado();
                System.out.println("El jugador " + player1.nombreJugador + " obtiene un " + dado);
                System.out.println("*Se mueve la ficha por el tablero*");

                //Negro - Inicio
                if ((player1.posicionJugador + dado) >= 16 && i != 1) {
                    System.out.println("Has pasado por la casilla de Inicio. Obtienes 20 MM");
                    player1.dineroJugador += 20;
                }

                player1.posicionJugador = (player1.posicionJugador + dado) % 16;
                posicion1 = player1.posicionJugador;

                //Amarillo - Impuesto
                if (posicion1 == 2 || posicion1 == 10) {
                    System.out.println("Impuesto!. Paga 10MM a la Banca");
                    player1.dineroJugador -= 10;
                }
                //Morado - Suerte
                if (posicion1 == 6 || posicion1 == 14) {
                    System.out.println("Suerte!.");
                    //Accion de sacar tarjeta suerte
                    switch (casillas[posicion1].casillaSuerte()) {
                        case 0:
                            player1.dineroJugador += 20;
                            break;
                        case 1:
                            player1.dineroJugador += 10;
                            player2.dineroJugador -= 10;
                            break;
                        case 2:
                            player1.dineroJugador -= 10;
                        default:
                            System.out.println("Error al obtener casilla Suerte");
                            break;
                    }
                }
                if (posicion1 == 12) {
                    System.out.println("Vas a la carcel");
                    player1.posicionJugador = 4;
                    player1.enCarcel = true;
                }
                if (posicion1 == 4) {
                    player1.enCarcel = true;
                }

                //Rojo - Apartamentos
                if (casillas[posicion1].colorCasilla.equals("Rojo") && casillas[posicion1].dueño && casillas[posicion1].id_dueño != 1) {
                    System.out.println("La calle " + casillas[posicion1].nombreCasilla + " ya tiene dueño. Paga 40 MM a su dueño");
                    player1.dineroJugador -= 40;
                    player2.dineroJugador += 40;
                } else if (casillas[posicion1].colorCasilla.equals("Rojo") && !casillas[posicion1].dueño) {
                    System.out.println("La calle " + casillas[posicion1].nombreCasilla + " no tiene dueño. ¿Quieres comprarla: Y o N?   (Dinero restante " + player1.dineroJugador + ")");
                    //if(sc.nextLine().equals("Y")){
                    System.out.println("Eres dueño de la calle: " + casillas[posicion1].nombreCasilla);
                    casillas[posicion1].dueño = true;
                    casillas[posicion1].id_dueño = 1;
                    player1.dineroJugador -= 20;
                    //}

                }

                //Final Turno Jugador 1
                System.out.println(casillas[player1.posicionJugador].toString());
                System.out.println("Dinero " + player1.nombreJugador + ": " + player1.dineroJugador);
                player1.checkBancarrota();

            }
            /////////////
            //Jugador 2//
            /////////////
            System.out.println("- Jugador 2 -");
            //Azul - Carcel
            if (player2.posicionJugador == 4 && player2.enCarcel == true) {
                System.out.println("Carcel!. No puedes salir hasta que saques un 5");
                //Tiramos dado para tratar de salir de la carcel
                dado = tirarDado();
                System.out.println("Tiramos dado y sale un: " + dado);
                if (dado == 5) {
                    System.out.println("¡Has sacado un 5!. Puedes salir de la carcel");
                    player2.enCarcel = false;
                } else {
                    System.out.println("¡Mala suerte, espera el próximo turno!");
                }
            }
            if (player2.enCarcel == false) {
                dado = tirarDado();
                System.out.println("El jugador " + player2.nombreJugador + " obtiene un " + dado);
                System.out.println("*Se mueve la ficha por el tablero*");

                if ((player2.posicionJugador + dado) >= 16 && i != 1) {
                    System.out.println("Has pasado por la casilla de Inicio. Obtienes 20 MM");
                    player2.dineroJugador += 20;
                }

                player2.posicionJugador = (player2.posicionJugador + dado) % 16;
                posicion2 = player2.posicionJugador;

                //Amarillo - Impuesto
                if (posicion2 == 2 || posicion2 == 10) {
                    System.out.println("Impuesto!. Paga 10MM a la Banca");
                    player2.dineroJugador -= 10;
                }
                //Morado - Suerte
                if (posicion2 == 6 || posicion2 == 14) {
                    System.out.println("Suerte!.");
                    //Accion de sacar tarjeta suerte
                    switch (casillas[posicion2].casillaSuerte()) {
                        case 0:
                            player2.dineroJugador += 20;
                            break;
                        case 1:
                            player2.dineroJugador += 10;
                            player1.dineroJugador -= 10;
                            break;
                        case 2:
                            player2.dineroJugador -= 10;
                        default:
                            System.out.println("Error al obtener casilla Suerte");
                            break;
                    }
                }
                if (posicion2 == 12) {
                    System.out.println("Vas a la carcel");
                    player2.posicionJugador = 4;
                    player2.enCarcel = true;
                }
                if (posicion2 == 4) {
                    player2.enCarcel = true;
                }

                //Rojo - Apartamentos
                if (casillas[posicion2].colorCasilla.equals("Rojo") && casillas[posicion2].dueño && casillas[posicion2].id_dueño != 2) {
                    System.out.println("La calle " + casillas[posicion2].nombreCasilla + " ya tiene dueño. Paga 40 MM a su dueño");
                    player2.dineroJugador -= 40;
                    player1.dineroJugador += 40;
                } else if (casillas[posicion2].colorCasilla.equals("Rojo") && !casillas[posicion2].dueño) {
                    System.out.println("La calle " + casillas[posicion2].nombreCasilla + " no tiene dueño. ¿Quieres comprarla: Y o N?   (Dinero restante " + player2.dineroJugador + ")");
                    //if(sc.nextLine().equals("Y")){
                    System.out.println("Eres dueño de la calle: " + casillas[posicion2].nombreCasilla);
                    casillas[posicion2].dueño = true;
                    casillas[posicion2].id_dueño = 2;
                    player2.dineroJugador -= 20;

                    //}
                }

                //Final Turno Jugador 2 
                System.out.println(casillas[player2.posicionJugador].toString());
                System.out.println("Dinero " + player2.nombreJugador + ": " + player2.dineroJugador);
                player2.checkBancarrota();
            }
        }
        */
    }


}
