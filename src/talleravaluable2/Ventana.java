/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleravaluable2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author AlejandroRodriguezB
 */
public class Ventana extends JFrame implements ActionListener {

    private JPanel jtpMain;
    private JButton jbtDerecha;
    private JButton jbtFINALIZAR;
    private JButton jbtFicheros;
    private JButton jbtIzquierda;
    private PanelIcono jpPanelDeIcono;
    private JLabel jpPanelDeImg;
    private JTextField jtfTexto;
    
    
    
    //ponemos los parametros de la entana que iniciaremos
    public Ventana() {
        setSize(800, 580);
        setTitle("Visualitzador de imatges imágenes- TALLER II -  2019/20");
        setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        initComponents();
        this.pack();
    }

    private void initComponents() {
        jtpMain = new JPanel();
        GroupLayout jtpMainLayout = new GroupLayout(jtpMain);
        jtpMain.setLayout(jtpMainLayout);
        jtpMainLayout.setHorizontalGroup(
                jtpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(100, 100, Short.MAX_VALUE)
        );
        jtpMainLayout.setVerticalGroup(
                jtpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(100, 100, Short.MAX_VALUE)
        );
        
        //Creamos un panel de la classe PanelIcono
        jpPanelDeIcono = new PanelIcono();
        jpPanelDeIcono.setMaximumSize(new java.awt.Dimension(450, 450));
        jpPanelDeIcono.setMinimumSize(new java.awt.Dimension(450, 450));
        jpPanelDeIcono.setPreferredSize(new java.awt.Dimension(450, 450));
        jpPanelDeIcono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               PanelDeIconoMouseClicked(evt);
            }
        });
        
        GroupLayout jpPanelDeIconoLayout = new GroupLayout(jpPanelDeIcono);
        jpPanelDeIcono.setLayout(jpPanelDeIconoLayout);
        jpPanelDeIconoLayout.setHorizontalGroup(
                jpPanelDeIconoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPanelDeIconoLayout.setVerticalGroup(
                jpPanelDeIconoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        
        //Creamos el panel de la imagen principal y le damos la imagen default
        ImageIcon imagenLogo = new ImageIcon(new ImageIcon("IMAGENES/logoTaller.jpg").getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
        jpPanelDeImg = new JLabel();
        jpPanelDeImg.setMaximumSize(new java.awt.Dimension(450, 450));
        jpPanelDeImg.setMinimumSize(new java.awt.Dimension(450, 450));
        jpPanelDeImg.setPreferredSize(new java.awt.Dimension(450, 450));
        jpPanelDeImg.setIcon(imagenLogo);

        GroupLayout jpPanelDeImgLayout = new GroupLayout(jpPanelDeImg);
        jpPanelDeImg.setLayout(jpPanelDeImgLayout);
        jpPanelDeImgLayout.setHorizontalGroup(
                jpPanelDeImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );
        jpPanelDeImgLayout.setVerticalGroup(
                jpPanelDeImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );

        //iniciamos un botón y le damos su acción(mover uno a la derecha)
        jbtDerecha = new JButton();
        jbtDerecha.setText(">");
        jbtDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechaActionPerformed(evt);
            }
        });
        //iniciamos un botón y le damos su acción(mover uno a la izquierda)
        jbtIzquierda = new JButton();
        jbtIzquierda.setText("<");
        jbtIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzquierdaActionPerformed(evt);
            }
        });
        //iniciamos un botón y le damos su acción(finalizar el programa)
        jbtFINALIZAR = new JButton();
        jbtFINALIZAR.setText("FINALIZAR");
        jbtFINALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZARActionPerformed(evt);
            }
        });

        //iniciamos un botón y le damos su acción(elgir que fichero de imagenes abrir)
        jbtFicheros = new JButton();
        jbtFicheros.setText("ABRIR LIBRERÍA IMÁGENES");
        jbtFicheros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LIBRERÍAActionPerformed(evt);
            }
        });

        //iniciamos el texto, le ponemos uno defalut que luego cambiara y evitamos que el usuario pueda cambiarlo
        jtfTexto = new JTextField();
        jtfTexto.setText("SELECCIONA LIBRERÍA DE IMÁGENES");
        jtfTexto.setEditable(false);

        //Creamos el layout de la ventana
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfTexto)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(115, 115, 115)
                                                                .addComponent(jbtFicheros))
                                                        .addComponent(jpPanelDeIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jpPanelDeImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(jbtIzquierda)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jbtDerecha)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jbtFINALIZAR)
                                                                .addGap(87, 87, 87)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jpPanelDeImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jpPanelDeIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jbtFicheros))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jbtDerecha)
                                                                .addComponent(jbtIzquierda))
                                                        .addComponent(jbtFINALIZAR))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    }

    public static void main(String[] args) {
        //iniciamos la ventana y la hacemos visible
        new Ventana().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void FINALIZARActionPerformed(java.awt.event.ActionEvent evt) {
        //si clickamos en finalizar cerramos el programa
        System.exit(0);
    }

    private void LIBRERÍAActionPerformed(java.awt.event.ActionEvent evt) {
        //si clickamos Librerias nos sale un file chooseer listando las imagenes
        JFileChooser fileChooser = new JFileChooser("IMAGENES/", FileSystemView.getFileSystemView()); //seleccionamos donde empezara a buscar
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //solo se puede guardar directorios
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            //guardamos una string de la ruta relativa para posterior uso
            String n = "IMAGENES/" + fichero.getName();
            String aux= jpPanelDeIcono.sobreescribe(n);
            ImageIcon imgdef = new ImageIcon(new ImageIcon(aux).getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
            jpPanelDeImg.setIcon(imgdef); //Actualizamos la imagen principal con el primer icono
            jtfTexto.setText("SELECCIONA EL ICONO A VISUALIZAR CON EL RATÓN O CON LOS BOTONES < Y >"); //actualizamos el texto
            
        }

    }
    private void DerechaActionPerformed(java.awt.event.ActionEvent evt) {
        //si clickamos en finalizar cerramos el programa
        String aux =jpPanelDeIcono.muevedereecha();
        if(aux!=null){
            ImageIcon imgdef = new ImageIcon(new ImageIcon(aux).getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
            jpPanelDeImg.setIcon(imgdef);
        }
    }
    private void IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {
        //si clickamos en finalizar cerramos el programa
        String aux =jpPanelDeIcono.mueveizquierda();
        if(aux!=null){
            ImageIcon imgdef = new ImageIcon(new ImageIcon(aux).getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
            jpPanelDeImg.setIcon(imgdef);
        }
    }
    
    private void PanelDeIconoMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // detectamos la posicion del click del raton
        
        int yep = evt.getY();
        int xep = evt.getX();
        String aux =jpPanelDeIcono.clickmouse(yep,xep);
        if(aux!=null){
            ImageIcon imgdef = new ImageIcon(new ImageIcon(aux).getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT));
            jpPanelDeImg.setIcon(imgdef);
        }
        else{
            jtfTexto.setText("ICONO SELECCIONADO NO REPRESENTA IMAGEN <<SELECCIONA OTRO ICONO");
        }
    }  

    
            
}
