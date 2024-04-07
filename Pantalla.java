package megapoly;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Byron Aurelio Panimboza Urresto
 */
public class Pantalla extends javax.swing.JFrame {

    private String jugador1, jugador2;
    private int dinero1, dinero2, dado, posicion1, posicion2;
    boolean dadoTirado = false;

    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
        this.setSize(900, 1000);
        this.setResizable(false);
        lPlayer1.setText("Jugador 1");
        lPlayer2.setText("Jugador 2");
    }

    public Pantalla(String jugador1, String jugador2) {
        initComponents();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.dinero1 = 100;
        this.dinero2 = 100;
        this.posicion1 = 0;
        this.posicion2 = 0;

        // Mostramos en pantalla los nombres introducidos en la pantalla anterior junto con el dinero inicial
        lPlayer1.setText(jugador1);
        lPlayer2.setText(jugador2);
        lDinero1.setText(String.valueOf(dinero1));
        lDinero2.setText(String.valueOf(dinero2));

        // Ajustamos a un tamaño concreto la ventana y la bloquemaos
        this.setSize(900, 1000);
        this.setResizable(false);

        // Al aparecer por defecto todos los tokens o fichas en el tablero, lo que buscamos con esto es esconderlos todos en todas las posiciones menos la inciial
        // de manera que cuando la ficha caiga sobre cierta casilla, esta se volverá visible y la ficha que se encontraba inicialmente en otra posicion no sería visible 
        lCasilla_1_Coche.setVisible(false);
        lCasilla_1_Perro.setVisible(false);
        lCasilla_2_Coche.setVisible(false);
        lCasilla_2_Perro.setVisible(false);
        lCasilla_3_Coche.setVisible(false);
        lCasilla_3_Perro.setVisible(false);
        lCasilla_4_Coche.setVisible(false);
        lCasilla_4_Perro.setVisible(false);
        lCasilla_5_Coche.setVisible(false);
        lCasilla_5_Perro.setVisible(false);
        lCasilla_6_Coche.setVisible(false);
        lCasilla_6_Perro.setVisible(false);
        lCasilla_7_Coche.setVisible(false);
        lCasilla_7_Perro.setVisible(false);
        lCasilla_8_Coche.setVisible(false);
        lCasilla_8_Perro.setVisible(false);
        lCasilla_9_Coche.setVisible(false);
        lCasilla_9_Perro.setVisible(false);
        lCasilla_10_Coche.setVisible(false);
        lCasilla_10_Perro.setVisible(false);
        lCasilla_11_Coche.setVisible(false);
        lCasilla_11_Perro.setVisible(false);
        lCasilla_12_Coche.setVisible(false);
        lCasilla_12_Perro.setVisible(false);
        lCasilla_13_Coche.setVisible(false);
        lCasilla_13_Perro.setVisible(false);
        lCasilla_14_Coche.setVisible(false);
        lCasilla_14_Perro.setVisible(false);
        lCasilla_15_Coche.setVisible(false);
        lCasilla_15_Perro.setVisible(false);

    }

    //Método tirar el dado que utilzará cada jugador en cada turno
    public int tirarDado() {
        return (int) ((Math.random() * 6) + 1);
    }

    public String getPlayer1() {
        return jugador1;
    }

    public String getPlayer2() {
        return jugador2;
    }

    public int getMoney1() {
        return dinero1;
    }

    public int getMoney2() {
        return dinero2;
    }

    public void setMoney1(int money1) {
        this.dinero1 = money1;
        lDinero1.setText(String.valueOf(dinero1));

    }

    public void setMoney2(int money2) {
        this.dinero2 = money2;
        lDinero2.setText(String.valueOf(dinero2));
    }

    public void setTurno(int i) {
        lTurno.setText("Turno " + String.valueOf(i));
    }
    

    public void mensajeInicio() {
        String msg = "Hola Bienvenido a Megapoly";
        JOptionPane.showMessageDialog(this, msg);
    }

    public void turnoJugador(int i) {
        String msg;
        dadoTirado = false;
        if (i == 1) {
            msg = "Es el turno del jugador 1. Tira el dado";
            JOptionPane.showMessageDialog(this, msg);

        } else {
            msg = "Es el turno del jugador 2. Tira el dado";
            JOptionPane.showMessageDialog(this, msg);
        }
    }

    public void MensajeCarcel() {
        String mensaje = "Carcel!. No puedes salir hasta que saques un 5";
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean checkDadoTirado() {
        return dadoTirado;
    }

    public void tiraElDado() {
        String dado_icono = "dado.png";
        ImageIcon icono = new ImageIcon(getClass().getResource(dado_icono));
        JOptionPane.showMessageDialog(this, "Tirar el dado", "Dado", JOptionPane.INFORMATION_MESSAGE, icono);
        
    }

    public void puedesSalirCarcel() {
        String msg = "Puedes salir de la carcel";
        JOptionPane.showMessageDialog(this, msg);
    }

    public void noSalesCarcel() {
        String msg = "¡Mala suerte, espera el próximo turno!";
        JOptionPane.showMessageDialog(this, msg);
    }

    public void casillaSalida() {
        String msg = "Has pasado por la casilla de Inicio. Obtienes 20 MM";
        JOptionPane.showMessageDialog(this, msg);
    }

    public void movimientoFicha1(int posInicial, int posFinal) {
        // En primer lugar ocultamos la ficha que se encuentra en la posicion inicial
        switch (posInicial) {
            case 0:
                lCasilla_0_Coche.setVisible(false);
                break;
            case 1:
                lCasilla_1_Coche.setVisible(false);
                break;
            case 2:
                lCasilla_2_Coche.setVisible(false);
                break;
            case 3:
                lCasilla_3_Coche.setVisible(false);
                break;
            case 4:
                lCasilla_4_Coche.setVisible(false);
                break;
            case 5:
                lCasilla_5_Coche.setVisible(false);
                break;
            case 6:
                lCasilla_6_Coche.setVisible(false);
                break;
            case 7:
                lCasilla_7_Coche.setVisible(false);
                break;
            case 8:
                lCasilla_8_Coche.setVisible(false);
                break;
            case 9:
                lCasilla_9_Coche.setVisible(false);
                break;
            case 10:
                lCasilla_10_Coche.setVisible(false);
                break;
            case 11:
                lCasilla_11_Coche.setVisible(false);
                break;
            case 12:
                lCasilla_12_Coche.setVisible(false);
                break;
            case 13:
                lCasilla_13_Coche.setVisible(false);
                break;
            case 14:
                lCasilla_14_Coche.setVisible(false);
                break;
            case 15:
                lCasilla_15_Coche.setVisible(false);
                break;
        }

        // Posteriormente hacemos que aparezca la ficha en la posicion final
        switch (posFinal) {
            case 0:
                lCasilla_0_Coche.setVisible(true);
                break;
            case 1:
                lCasilla_1_Coche.setVisible(true);
                break;
            case 2:
                lCasilla_2_Coche.setVisible(true);
                break;
            case 3:
                lCasilla_3_Coche.setVisible(true);
                break;
            case 4:
                lCasilla_4_Coche.setVisible(true);
                break;
            case 5:
                lCasilla_5_Coche.setVisible(true);
                break;
            case 6:
                lCasilla_6_Coche.setVisible(true);
                break;
            case 7:
                lCasilla_7_Coche.setVisible(true);
                break;
            case 8:
                lCasilla_8_Coche.setVisible(true);
                break;
            case 9:
                lCasilla_9_Coche.setVisible(true);
                break;
            case 10:
                lCasilla_10_Coche.setVisible(true);
                break;
            case 11:
                lCasilla_11_Coche.setVisible(true);
                break;
            case 12:
                lCasilla_12_Coche.setVisible(true);
                break;
            case 13:
                lCasilla_13_Coche.setVisible(true);
                break;
            case 14:
                lCasilla_14_Coche.setVisible(true);
                break;
            case 15:
                lCasilla_15_Coche.setVisible(true);
                break;
        }
    }

    public void movimientoFicha2(int posInicial, int posFinal) {
        // En primer lugar ocultamos la ficha que se encuentra en la posicion inicial
        switch (posInicial) {
            case 0:
                lCasilla_0_Perro.setVisible(false);
                break;
            case 1:
                lCasilla_1_Perro.setVisible(false);
                break;
            case 2:
                lCasilla_2_Perro.setVisible(false);
                break;
            case 3:
                lCasilla_3_Perro.setVisible(false);
                break;
            case 4:
                lCasilla_4_Perro.setVisible(false);
                break;
            case 5:
                lCasilla_5_Perro.setVisible(false);
                break;
            case 6:
                lCasilla_6_Perro.setVisible(false);
                break;
            case 7:
                lCasilla_7_Perro.setVisible(false);
                break;
            case 8:
                lCasilla_8_Perro.setVisible(false);
                break;
            case 9:
                lCasilla_9_Perro.setVisible(false);
                break;
            case 10:
                lCasilla_10_Perro.setVisible(false);
                break;
            case 11:
                lCasilla_11_Perro.setVisible(false);
                break;
            case 12:
                lCasilla_12_Perro.setVisible(false);
                break;
            case 13:
                lCasilla_13_Perro.setVisible(false);
                break;
            case 14:
                lCasilla_14_Perro.setVisible(false);
                break;
            case 15:
                lCasilla_15_Perro.setVisible(false);
                break;
        }

        // Posteriormente hacemos que aparezca la ficha en la posicion final
        switch (posFinal) {
            case 0:
                lCasilla_0_Perro.setVisible(true);
                break;
            case 1:
                lCasilla_1_Perro.setVisible(true);
                break;
            case 2:
                lCasilla_2_Perro.setVisible(true);
                break;
            case 3:
                lCasilla_3_Perro.setVisible(true);
                break;
            case 4:
                lCasilla_4_Perro.setVisible(true);
                break;
            case 5:
                lCasilla_5_Perro.setVisible(true);
                break;
            case 6:
                lCasilla_6_Perro.setVisible(true);
                break;
            case 7:
                lCasilla_7_Perro.setVisible(true);
                break;
            case 8:
                lCasilla_8_Perro.setVisible(true);
                break;
            case 9:
                lCasilla_9_Perro.setVisible(true);
                break;
            case 10:
                lCasilla_10_Perro.setVisible(true);
                break;
            case 11:
                lCasilla_11_Perro.setVisible(true);
                break;
            case 12:
                lCasilla_12_Perro.setVisible(true);
                break;
            case 13:
                lCasilla_13_Perro.setVisible(true);
                break;
            case 14:
                lCasilla_14_Perro.setVisible(true);
                break;
            case 15:
                lCasilla_15_Perro.setVisible(true);
                break;
        }
    }

    public void casillaImpuesto() {
        String msg = "Impuesto!. Paga 10MM a la Banca";
        JOptionPane.showMessageDialog(this, msg);
    }

    public int casillaSuerte() {
        String msg1 = "Has ganado un premio en el concurso de belleza. Recibe 20 MM";
        String msg2 = "Hoy es tu cumpleaños. Recibe 10 MM de tu oponente";
        String msg3 = "Recibes una multa de tráfico. Paga 10 MM";
        int num = (int) (Math.random() * 3);

        switch (num) {
            case 0:
                JOptionPane.showMessageDialog(this, msg1);
                break;
            case 1:
                JOptionPane.showMessageDialog(this, msg2);
                break;
            case 2:
                JOptionPane.showMessageDialog(this, msg3);
                break;
        }

        return num;

    }

    public void casillaVasCarcel(){
        String msg = "Vas a la carcel";
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public void casillaCalleDueño(){
        String msg = "La calle ya tiene dueño. Paga 40 MM a su dueño";
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public int casillaCalleLibre(){
        Object[] opciones = {"Si", "No"};
        int respuesta = JOptionPane.showOptionDialog(this, "¿Quieres comprar la calle? Coste: 20 MM", "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        return  respuesta;
    }
    
    public void bancarrota(){
        String msg = "Estas en bancarrota. Pierdes!";
        JOptionPane.showMessageDialog(this, msg);
        System.exit(WIDTH);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        pCasilla_0 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lCasilla_0_Coche = new javax.swing.JLabel();
        lCasilla_0_Perro = new javax.swing.JLabel();
        pCasilla_1 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lCasilla_1_Coche = new javax.swing.JLabel();
        lCasilla_1_Perro = new javax.swing.JLabel();
        pCasilla_2 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lCasilla_2_Perro = new javax.swing.JLabel();
        lCasilla_2_Coche = new javax.swing.JLabel();
        pCasilla_3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lCasilla_3_Perro = new javax.swing.JLabel();
        lCasilla_3_Coche = new javax.swing.JLabel();
        pCasilla_4 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lCasilla_4_Perro = new javax.swing.JLabel();
        lCasilla_4_Coche = new javax.swing.JLabel();
        pCasilla_5 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lCasilla_5_Perro = new javax.swing.JLabel();
        lCasilla_5_Coche = new javax.swing.JLabel();
        pCasilla_6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lCasilla_6_Perro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lCasilla_6_Coche = new javax.swing.JLabel();
        pCasilla_7 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        lCasilla_7_Perro = new javax.swing.JLabel();
        lCasilla_7_Coche = new javax.swing.JLabel();
        pCasilla_8 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        lCasilla_8_Perro = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lCasilla_8_Coche = new javax.swing.JLabel();
        pCasilla_9 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lCasilla_9_Perro = new javax.swing.JLabel();
        lCasilla_9_Coche = new javax.swing.JLabel();
        pCasilla_10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lCasilla_10_Perro = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lCasilla_10_Coche = new javax.swing.JLabel();
        pCasilla_11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lCasilla_11_Perro = new javax.swing.JLabel();
        lCasilla_11_Coche = new javax.swing.JLabel();
        pCasilla_12 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        lCasilla_12_Perro = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lCasilla_12_Coche = new javax.swing.JLabel();
        pCasilla_13 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lCasilla_13_Perro = new javax.swing.JLabel();
        lCasilla_13_Coche = new javax.swing.JLabel();
        pCasilla_14 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        lCasilla_14_Perro = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lCasilla_14_Coche = new javax.swing.JLabel();
        pCasilla_15 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        lCasilla_15_Perro = new javax.swing.JLabel();
        lCasilla_15_Coche = new javax.swing.JLabel();
        pAcciones = new javax.swing.JPanel();
        bDado = new javax.swing.JButton();
        bMovimiento = new javax.swing.JButton();
        lLogo = new javax.swing.JLabel();
        pInfoJugadores = new javax.swing.JPanel();
        lPlayer1 = new javax.swing.JLabel();
        lDinero1 = new javax.swing.JLabel();
        lPlayer2 = new javax.swing.JLabel();
        lDinero2 = new javax.swing.JLabel();
        lTurno = new javax.swing.JLabel();
        lDado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mPartida = new javax.swing.JMenu();
        mGuardarPartida = new javax.swing.JMenuItem();
        Menu_Inicio = new javax.swing.JMenu();
        mInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pCasilla_0.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_0.setForeground(new java.awt.Color(0, 0, 0));

        jPanel31.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Salida");

        lCasilla_0_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        lCasilla_0_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_0Layout = new javax.swing.GroupLayout(pCasilla_0);
        pCasilla_0.setLayout(pCasilla_0Layout);
        pCasilla_0Layout.setHorizontalGroup(
            pCasilla_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_0Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lCasilla_0_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_0_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pCasilla_0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCasilla_0Layout.setVerticalGroup(
            pCasilla_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_0Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pCasilla_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_0_Coche)
                    .addComponent(lCasilla_0_Perro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_1.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel21.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setText("Getafe");

        lCasilla_1_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        lCasilla_1_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_1Layout = new javax.swing.GroupLayout(pCasilla_1);
        pCasilla_1.setLayout(pCasilla_1Layout);
        pCasilla_1Layout.setHorizontalGroup(
            pCasilla_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCasilla_1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lCasilla_1_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_1_Coche)
                .addContainerGap())
            .addGroup(pCasilla_1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pCasilla_1Layout.setVerticalGroup(
            pCasilla_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_1Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_1_Coche)
                    .addComponent(lCasilla_1_Perro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_2.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel19.setBackground(new java.awt.Color(250, 252, 175));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Impuesto");

        lCasilla_2_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_2_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_2Layout = new javax.swing.GroupLayout(pCasilla_2);
        pCasilla_2.setLayout(pCasilla_2Layout);
        pCasilla_2Layout.setHorizontalGroup(
            pCasilla_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCasilla_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCasilla_2Layout.createSequentialGroup()
                        .addComponent(lCasilla_2_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_2_Coche)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCasilla_2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pCasilla_2Layout.setVerticalGroup(
            pCasilla_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_2Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pCasilla_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_2_Perro)
                    .addComponent(lCasilla_2_Coche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_3.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_3.setForeground(new java.awt.Color(0, 0, 0));

        jPanel15.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Valdemoro");

        lCasilla_3_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_3_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_3Layout = new javax.swing.GroupLayout(pCasilla_3);
        pCasilla_3.setLayout(pCasilla_3Layout);
        pCasilla_3Layout.setHorizontalGroup(
            pCasilla_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCasilla_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCasilla_3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lCasilla_3_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_3_Coche)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pCasilla_3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pCasilla_3Layout.setVerticalGroup(
            pCasilla_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_3Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_3_Perro)
                    .addComponent(lCasilla_3_Coche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_4.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_4.setForeground(new java.awt.Color(0, 0, 0));

        jPanel25.setBackground(new java.awt.Color(176, 194, 242));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Ve a la carcel");

        lCasilla_4_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_4_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_4Layout = new javax.swing.GroupLayout(pCasilla_4);
        pCasilla_4.setLayout(pCasilla_4Layout);
        pCasilla_4Layout.setHorizontalGroup(
            pCasilla_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pCasilla_4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lCasilla_4_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_4_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pCasilla_4Layout.setVerticalGroup(
            pCasilla_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_4Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCasilla_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_4_Perro)
                    .addComponent(lCasilla_4_Coche))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pCasilla_5.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_5.setForeground(new java.awt.Color(0, 0, 0));

        jPanel29.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Ciempozuelos");

        lCasilla_5_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_5_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_5Layout = new javax.swing.GroupLayout(pCasilla_5);
        pCasilla_5.setLayout(pCasilla_5Layout);
        pCasilla_5Layout.setHorizontalGroup(
            pCasilla_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCasilla_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCasilla_5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lCasilla_5_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_5_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pCasilla_5Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pCasilla_5Layout.setVerticalGroup(
            pCasilla_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_5Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_5_Perro)
                    .addComponent(lCasilla_5_Coche))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pCasilla_6.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_6.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(233, 176, 242));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lCasilla_6_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Suerte!");

        lCasilla_6_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_6Layout = new javax.swing.GroupLayout(pCasilla_6);
        pCasilla_6.setLayout(pCasilla_6Layout);
        pCasilla_6Layout.setHorizontalGroup(
            pCasilla_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCasilla_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCasilla_6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lCasilla_6_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_6_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pCasilla_6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pCasilla_6Layout.setVerticalGroup(
            pCasilla_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_6Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_6_Perro)
                    .addComponent(lCasilla_6_Coche))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pCasilla_7.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_7.setForeground(new java.awt.Color(0, 0, 0));

        jPanel43.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Aranjuez");

        lCasilla_7_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_7_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_7Layout = new javax.swing.GroupLayout(pCasilla_7);
        pCasilla_7.setLayout(pCasilla_7Layout);
        pCasilla_7Layout.setHorizontalGroup(
            pCasilla_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCasilla_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCasilla_7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lCasilla_7_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_7_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pCasilla_7Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pCasilla_7Layout.setVerticalGroup(
            pCasilla_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_7Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_7_Perro)
                    .addComponent(lCasilla_7_Coche))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pCasilla_8.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_8.setForeground(new java.awt.Color(0, 0, 0));

        jPanel45.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lCasilla_8_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Parking");

        lCasilla_8_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_8Layout = new javax.swing.GroupLayout(pCasilla_8);
        pCasilla_8.setLayout(pCasilla_8Layout);
        pCasilla_8Layout.setHorizontalGroup(
            pCasilla_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pCasilla_8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lCasilla_8_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_8_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pCasilla_8Layout.setVerticalGroup(
            pCasilla_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_8Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addGroup(pCasilla_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_8_Perro)
                    .addComponent(lCasilla_8_Coche))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pCasilla_9.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_9.setForeground(new java.awt.Color(0, 0, 0));

        jPanel27.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Fuenlabrada");

        lCasilla_9_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_9_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_9Layout = new javax.swing.GroupLayout(pCasilla_9);
        pCasilla_9.setLayout(pCasilla_9Layout);
        pCasilla_9Layout.setHorizontalGroup(
            pCasilla_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
            .addGroup(pCasilla_9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lCasilla_9_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_9_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pCasilla_9Layout.setVerticalGroup(
            pCasilla_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_9Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_9_Perro)
                    .addComponent(lCasilla_9_Coche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_10.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_10.setForeground(new java.awt.Color(0, 0, 0));

        jPanel6.setBackground(new java.awt.Color(250, 252, 175));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lCasilla_10_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Impuesto");

        lCasilla_10_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_10Layout = new javax.swing.GroupLayout(pCasilla_10);
        pCasilla_10.setLayout(pCasilla_10Layout);
        pCasilla_10Layout.setHorizontalGroup(
            pCasilla_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_10Layout.createSequentialGroup()
                .addGroup(pCasilla_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCasilla_10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lCasilla_10_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_10_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pCasilla_10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pCasilla_10Layout.setVerticalGroup(
            pCasilla_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_10Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addGroup(pCasilla_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_10_Perro)
                    .addComponent(lCasilla_10_Coche))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pCasilla_11.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_11.setForeground(new java.awt.Color(0, 0, 0));

        jPanel10.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Parla");

        lCasilla_11_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_11_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_11Layout = new javax.swing.GroupLayout(pCasilla_11);
        pCasilla_11.setLayout(pCasilla_11Layout);
        pCasilla_11Layout.setHorizontalGroup(
            pCasilla_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lCasilla_11_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_11_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(pCasilla_11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCasilla_11Layout.setVerticalGroup(
            pCasilla_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_11Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pCasilla_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_11_Perro)
                    .addComponent(lCasilla_11_Coche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_12.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_12.setForeground(new java.awt.Color(0, 0, 0));

        jPanel33.setBackground(new java.awt.Color(176, 194, 242));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lCasilla_12_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Cárcel");

        lCasilla_12_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_12Layout = new javax.swing.GroupLayout(pCasilla_12);
        pCasilla_12.setLayout(pCasilla_12Layout);
        pCasilla_12Layout.setHorizontalGroup(
            pCasilla_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCasilla_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pCasilla_12Layout.createSequentialGroup()
                        .addComponent(lCasilla_12_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_12_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pCasilla_12Layout.setVerticalGroup(
            pCasilla_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_12Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_12_Perro)
                    .addComponent(lCasilla_12_Coche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCasilla_13.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_13.setForeground(new java.awt.Color(0, 0, 0));

        jPanel35.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Pinto");
        jLabel33.setToolTipText("");

        lCasilla_13_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N
        lCasilla_13_Perro.setToolTipText("");

        lCasilla_13_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_13Layout = new javax.swing.GroupLayout(pCasilla_13);
        pCasilla_13.setLayout(pCasilla_13Layout);
        pCasilla_13Layout.setHorizontalGroup(
            pCasilla_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lCasilla_13_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_13_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pCasilla_13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pCasilla_13Layout.setVerticalGroup(
            pCasilla_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_13Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(pCasilla_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lCasilla_13_Perro)
                    .addComponent(lCasilla_13_Coche))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pCasilla_14.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_14.setForeground(new java.awt.Color(0, 0, 0));

        jPanel41.setBackground(new java.awt.Color(233, 176, 242));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lCasilla_14_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Suerte!");

        lCasilla_14_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_14Layout = new javax.swing.GroupLayout(pCasilla_14);
        pCasilla_14.setLayout(pCasilla_14Layout);
        pCasilla_14Layout.setHorizontalGroup(
            pCasilla_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lCasilla_14_Perro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCasilla_14_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
            .addGroup(pCasilla_14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCasilla_14Layout.setVerticalGroup(
            pCasilla_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_14Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_14_Perro)
                    .addComponent(lCasilla_14_Coche))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pCasilla_15.setBackground(new java.awt.Color(255, 255, 255));
        pCasilla_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pCasilla_15.setForeground(new java.awt.Color(0, 0, 0));

        jPanel39.setBackground(new java.awt.Color(255, 182, 174));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Alcalá de Henares");

        lCasilla_15_Perro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Perro.png"))); // NOI18N

        lCasilla_15_Coche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/Ficha_Coche.png"))); // NOI18N

        javax.swing.GroupLayout pCasilla_15Layout = new javax.swing.GroupLayout(pCasilla_15);
        pCasilla_15.setLayout(pCasilla_15Layout);
        pCasilla_15Layout.setHorizontalGroup(
            pCasilla_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pCasilla_15Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pCasilla_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addGroup(pCasilla_15Layout.createSequentialGroup()
                        .addComponent(lCasilla_15_Perro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCasilla_15_Coche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pCasilla_15Layout.setVerticalGroup(
            pCasilla_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCasilla_15Layout.createSequentialGroup()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCasilla_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCasilla_15_Perro)
                    .addComponent(lCasilla_15_Coche))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bDado.setText("Accion lanzar dado");
        bDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDadoActionPerformed(evt);
            }
        });

        bMovimiento.setText("Accion movimiento");
        bMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMovimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAccionesLayout = new javax.swing.GroupLayout(pAcciones);
        pAcciones.setLayout(pAccionesLayout);
        pAccionesLayout.setHorizontalGroup(
            pAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAccionesLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(bDado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(bMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pAccionesLayout.setVerticalGroup(
            pAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAccionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMovimiento)
                    .addComponent(bDado))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/megapoly/MegaPoly_icon.jpg"))); // NOI18N
        lLogo.setToolTipText("");

        pInfoJugadores.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        lPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPlayer1.setText("Jugador 1");
        pInfoJugadores.add(lPlayer1);

        lDinero1.setText("Dinero 1");
        pInfoJugadores.add(lDinero1);

        lPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPlayer2.setText("Jugador 2 ");
        pInfoJugadores.add(lPlayer2);

        lDinero2.setText("Dinero 2");
        pInfoJugadores.add(lDinero2);

        lTurno.setText("Turno");

        lDado.setText("Dado");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(pAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lTurno)
                        .addGap(64, 64, 64)
                        .addComponent(pInfoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(lDado)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pCasilla_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pCasilla_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pCasilla_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pCasilla_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(pCasilla_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pCasilla_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pCasilla_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(pCasilla_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(pCasilla_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pCasilla_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pCasilla_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pCasilla_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCasilla_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCasilla_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCasilla_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pCasilla_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(250, 250, 250))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pInfoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTurno)
                    .addComponent(lDado))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pCasilla_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCasilla_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCasilla_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCasilla_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pCasilla_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(pCasilla_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pCasilla_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCasilla_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(pCasilla_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pCasilla_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCasilla_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pCasilla_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCasilla_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCasilla_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCasilla_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCasilla_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
        );

        mPartida.setText("Partida");

        mGuardarPartida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mGuardarPartida.setForeground(new java.awt.Color(0, 0, 0));
        mGuardarPartida.setText("Guardar Partida");
        mGuardarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuardarPartidaActionPerformed(evt);
            }
        });
        mPartida.add(mGuardarPartida);

        jMenuBar1.add(mPartida);

        Menu_Inicio.setText("Inicio");
        Menu_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_InicioActionPerformed(evt);
            }
        });

        mInicio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mInicio.setText("Ir al inicio");
        mInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInicioActionPerformed(evt);
            }
        });
        Menu_Inicio.add(mInicio);

        jMenuBar1.add(Menu_Inicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Menu_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_InicioActionPerformed

    }//GEN-LAST:event_Menu_InicioActionPerformed

    private void mInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInicioActionPerformed
        // TODO add your handling code here:
        Inicio in = new Inicio();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mInicioActionPerformed

    // Boton que permite lanzar el dado y conocer su resultado
    private void bDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDadoActionPerformed
        dado = tirarDado();
        String resultado_dado = "El dado ha sacado: " + String.valueOf(dado);
        JOptionPane.showMessageDialog(this, resultado_dado);
        dadoTirado = true;
        setDado(dado);
        //MegaPoly.dadoPresionado();
    }//GEN-LAST:event_bDadoActionPerformed

    // Una vez sabemos el resultado del dado con este boton podemos mover las fichas
    private void bMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMovimientoActionPerformed
        // Suponiendo que el jugador no se encuentra dentro de la carcel
        JOptionPane.showMessageDialog(this, String.valueOf(dado));
        

    }//GEN-LAST:event_bMovimientoActionPerformed
    // Guardar Partida en un fichero
    private void mGuardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuardarPartidaActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("fichero.txt"));
        fileChooser.setDialogTitle("Seleciona un fichero donde guardar la partida");
        int resultado = fileChooser.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_mGuardarPartidaActionPerformed

    public int getDado() {
        return this.dado;
    }
    public void setDado(int dado){
        this.dado = dado;
        lDado.setText("Dado: " + String.valueOf(dado));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_Inicio;
    private javax.swing.JButton bDado;
    private javax.swing.JButton bMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lCasilla_0_Coche;
    private javax.swing.JLabel lCasilla_0_Perro;
    private javax.swing.JLabel lCasilla_10_Coche;
    private javax.swing.JLabel lCasilla_10_Perro;
    private javax.swing.JLabel lCasilla_11_Coche;
    private javax.swing.JLabel lCasilla_11_Perro;
    private javax.swing.JLabel lCasilla_12_Coche;
    private javax.swing.JLabel lCasilla_12_Perro;
    private javax.swing.JLabel lCasilla_13_Coche;
    private javax.swing.JLabel lCasilla_13_Perro;
    private javax.swing.JLabel lCasilla_14_Coche;
    private javax.swing.JLabel lCasilla_14_Perro;
    private javax.swing.JLabel lCasilla_15_Coche;
    private javax.swing.JLabel lCasilla_15_Perro;
    private javax.swing.JLabel lCasilla_1_Coche;
    private javax.swing.JLabel lCasilla_1_Perro;
    private javax.swing.JLabel lCasilla_2_Coche;
    private javax.swing.JLabel lCasilla_2_Perro;
    private javax.swing.JLabel lCasilla_3_Coche;
    private javax.swing.JLabel lCasilla_3_Perro;
    private javax.swing.JLabel lCasilla_4_Coche;
    private javax.swing.JLabel lCasilla_4_Perro;
    private javax.swing.JLabel lCasilla_5_Coche;
    private javax.swing.JLabel lCasilla_5_Perro;
    private javax.swing.JLabel lCasilla_6_Coche;
    private javax.swing.JLabel lCasilla_6_Perro;
    private javax.swing.JLabel lCasilla_7_Coche;
    private javax.swing.JLabel lCasilla_7_Perro;
    private javax.swing.JLabel lCasilla_8_Coche;
    private javax.swing.JLabel lCasilla_8_Perro;
    private javax.swing.JLabel lCasilla_9_Coche;
    private javax.swing.JLabel lCasilla_9_Perro;
    private javax.swing.JLabel lDado;
    private javax.swing.JLabel lDinero1;
    private javax.swing.JLabel lDinero2;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lPlayer1;
    private javax.swing.JLabel lPlayer2;
    private javax.swing.JLabel lTurno;
    private javax.swing.JMenuItem mGuardarPartida;
    private javax.swing.JMenuItem mInicio;
    private javax.swing.JMenu mPartida;
    private javax.swing.JPanel pAcciones;
    private javax.swing.JPanel pCasilla_0;
    private javax.swing.JPanel pCasilla_1;
    private javax.swing.JPanel pCasilla_10;
    private javax.swing.JPanel pCasilla_11;
    private javax.swing.JPanel pCasilla_12;
    private javax.swing.JPanel pCasilla_13;
    private javax.swing.JPanel pCasilla_14;
    private javax.swing.JPanel pCasilla_15;
    private javax.swing.JPanel pCasilla_2;
    private javax.swing.JPanel pCasilla_3;
    private javax.swing.JPanel pCasilla_4;
    private javax.swing.JPanel pCasilla_5;
    private javax.swing.JPanel pCasilla_6;
    private javax.swing.JPanel pCasilla_7;
    private javax.swing.JPanel pCasilla_8;
    private javax.swing.JPanel pCasilla_9;
    private javax.swing.JPanel pInfoJugadores;
    // End of variables declaration//GEN-END:variables
}
