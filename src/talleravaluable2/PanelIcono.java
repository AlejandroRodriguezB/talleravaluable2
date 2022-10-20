
package talleravaluable2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AlejandroRodriguezB
 */
public class PanelIcono extends JPanel {

    private static final int DIMENSIOX = 7;
    private static final int DIMENSIOY = 4;
    private static final int MAXIM = 520;
    private static final int COSTAT = 52;
    private JLabel t[][] = new JLabel[DIMENSIOX][DIMENSIOY];
    String[] aoe = new String[28];
    int poss = 0;
    int flex = 0;
    int fley = 0;
    int ulty= 0;
    int ultx=0;
    int ultposs=0;

    public PanelIcono() {
        //bucle que crea los Jlabels "Iconos" del panel de iconos
        int y = 0;
        for (int i = 0; i < DIMENSIOX; i++) {
            int x = 0;
            for (int j = 0; j < DIMENSIOY; j++) {
                int pa = 65;
                int po = 65;
                pa = (pa * i) + 10;
                po = (po * j) + 10;

                t[i][j] = new JLabel();
                t[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                t[i][j].setBounds(po, pa, 60, 60);
                ImageIcon imagenLogo = new ImageIcon(new ImageIcon("IMAGENES/imagenVacia.jpg").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
                t[i][j].setIcon(imagenLogo);
                this.add(t[i][j]);
                x += COSTAT;
            }

            y += COSTAT;
        }
    }

    public String sobreescribe(String n) {
        File fichero2 = new File(n);
        Arrays.fill(aoe, null); // limpiamos la array
        int count = 0;
        int qwety = 0;
        //bucle para sacar los rautas de las imagenes
        for (final File abcd : fichero2.listFiles()) {
            try {
                //BufferedImage img = null;
                //img = ImageIO.read(abcd);
                String ope = n + "/" + abcd.getName();
                //System.out.println(ope);
                aoe[count] = ope;

                count++;
            } catch (Exception e) {
            }
        }
        //reseteo variables que indican la posición de la ultima imagen 
        ulty= 0;
        ultx=0;
        ultposs=0;
        //bucle para poner las imagenes en los JLabels
        for (int i = 0; i < t.length; i++) {
            
            for (int j = 0; j < t[i].length; j++) {
                t[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); //reseteamos todos los requadros
                t[0][0].setBorder(BorderFactory.createLineBorder(Color.RED, 3)); //ponemos el primer requadro en rojo
                    if(aoe[qwety]!=null){
                        //pintamos la imagen si la array no esta nula
                        ImageIcon Logo = new ImageIcon(new ImageIcon(aoe[qwety]).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
                        t[i][j].setIcon(Logo);
                        // augmentamos las posiciones para saber la ultima imagen no nula
                        ulty++;
                        ultposs++;
                        if(ulty==4){
                            ulty=0;
                            ultx++;
                        }
                    }
                    else{
                        //pintamos la imagen vacia si la array esta nula por si las casillas estaban ocupadas anteriormente
                        ImageIcon Logo = new ImageIcon(new ImageIcon("IMAGENES/imagenVacia.jpg").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
                        t[i][j].setIcon(Logo);
                    }
                
                this.add(t[i][j]);
                qwety++;

            }

        }
        //reseteamos la posición y devolvemos el path de la imagen
        fley = 0;
        flex = 0;
        poss = 0;
        return aoe[0];

    }

    public String muevedereecha() {
        //augmentamos en 1 la posicion y de la matriz y el contador global 
        fley++;
        poss++;
        for (int i = 0; i < DIMENSIOX; i++) {
            //si llega a la ultima casilla y de la matriz ponemos y a 0 e bajamos un escalon de la matriz
            if (fley == 4) {
                flex++;
                fley = 0;
            }
            // si la matriz llega al final o a la ultima foto no nula volvemos al principio
            if ( flex == 7 || aoe[poss] == null) {
                fley = 0;
                flex = 0;
                poss = 0;
            }
            for (int j = 0; j < DIMENSIOY; j++) {

                t[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                if(aoe[poss] != null){
                    //para evitar que te ponga el requadro en rojo quando no hayas habierto ninguna libreria pero le des a las flechas
                    t[flex][fley].setBorder(BorderFactory.createLineBorder(Color.RED, 3)); 
                }
            }

        }
        return aoe[poss];

    }
    public String mueveizquierda() {
        //disminuimos en 1 la posicion y de la matriz y el contador global 
        fley--;
        poss--;
        for (int i = 0; i < DIMENSIOX; i++) {
            //si llega a la ultima casilla y de la matriz ponemos y a 3 e subimos un escalon de la matriz
            if (fley == -1) {
                flex--;
                
                // si la matriz llega al principio la mandamos al final
                if(flex==-1){
                    flex = 6;
                    poss= 27;
                }
                fley = 3;
                //si el final no tiene imagen lo mandamos a la ultima imagen
                if(aoe[poss] == null){
                    flex = ultx;
                    poss= ultposs-1;
                    fley = ulty-1;
                }
                
            }
            

            for (int j = 0; j < DIMENSIOY; j++) {

                t[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                if(aoe[poss] != null){
                    //para evitar que te ponga el requadro en rojo quando no hayas habierto ninguna libreria pero le des a las flechas
                    t[flex][fley].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                }
            }

        }
        return aoe[poss];
    }
    public String clickmouse(int ylong, int xhalt) {
        //filtro para encontar donde hemos clicado
        if(ylong<68 && ylong >12){
            flex=0;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 0;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 1;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 2;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 3;
            }
            
        }
        if(ylong<132 && ylong >76){
            flex=1;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 4;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 5;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 6;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 7;
            }
        }
        if(ylong<198 && ylong >140){
            flex=2;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 8;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 9;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 10;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 11;
            }
        }
        if(ylong<264 && ylong >206){
            flex=3;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 12;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 13;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 14;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 15;
            }
        }
        if(ylong<328 && ylong >270){
            flex=4;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 16;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 17;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 18;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 19;
            }
        }
        if(ylong<394 && ylong >336){
            flex=5;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 20;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 21;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 22;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 23;
            }
        }
        if(ylong<460 && ylong >400){
            flex=6;
            if(xhalt<68 && xhalt >12){
                fley=0;
                poss = 24;
            }
            if(xhalt<132 && xhalt >76){
                 fley=1;
                 poss = 25;
            }
            if(xhalt<198 && xhalt >140){
                 fley=2;
                 poss = 26;
            }
            if(xhalt<264 && xhalt >206){
                 fley=3;
                 poss = 27;
            }
        }
        //ponemos todas las casillas a borde negro menos la que hemos clickado
        for (int i = 0; i < DIMENSIOX; i++) {    
            for (int j = 0; j < DIMENSIOY; j++) {
                t[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                if(aoe[poss] != null){
                    //para evitar que te ponga el requadro en rojo quando no hayas habierto ninguna libreria pero le des a las flechas
                    t[flex][fley].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                }
            }
        }
        return aoe[poss];
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < DIMENSIOX; i++) {
            for (int j = 0; j < DIMENSIOY; j++) {
                t[i][j].paintComponents(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIM, MAXIM);
    }
    
    
}
