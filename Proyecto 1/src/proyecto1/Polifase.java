
package proyecto1;
import Polifase.ordenamientoPol;
public class Polifase extends javax.swing.JFrame {
    String textoObtenido, texto;
    Ficheros fichero = new Ficheros();
    ordenamientoPol polifase=new ordenamientoPol();
    public Polifase() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        U_Direccion = new javax.swing.JTextField();
        ObTexto = new javax.swing.JButton();
        B_Ordenar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoArchivo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 440));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1(1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 100));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2(1).png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 600, 100));

        U_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_DireccionActionPerformed(evt);
            }
        });
        jPanel1.add(U_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 270, 30));

        ObTexto.setText("Obtener Texo");
        ObTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObTextoActionPerformed(evt);
            }
        });
        jPanel1.add(ObTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        B_Ordenar.setText("Ordenar");
        B_Ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_OrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(B_Ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        TextoArchivo.setColumns(20);
        TextoArchivo.setRows(5);
        jScrollPane1.setViewportView(TextoArchivo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 270, 130));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Texto del archivo:");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dirección:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_OrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_OrdenarActionPerformed
           /* String direccion = U_Direccion.getText();
            String texto = fichero.Read(direccion);
            this.textoObtenido=texto;
            System.out.println(texto);*/
            U_Direccion.setText("");
            TextoArchivo.setText("");
            
                    
            
            
    }//GEN-LAST:event_B_OrdenarActionPerformed

    private void U_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_U_DireccionActionPerformed

    private void ObTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObTextoActionPerformed
            String direccion = U_Direccion.getText();
            texto = fichero.Read(direccion);
            TextoArchivo.setText(texto);
            textoObtenido=direccion;
            
            polifase.fase1(texto);
    }//GEN-LAST:event_ObTextoActionPerformed

    public String getTextoObtenido() {
        return textoObtenido;
    }

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Polifase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Ordenar;
    private javax.swing.JButton ObTexto;
    private javax.swing.JTextArea TextoArchivo;
    private javax.swing.JTextField U_Direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
