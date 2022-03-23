package proyecto1;

public class menuPrincipal extends javax.swing.JFrame {

    public menuPrincipal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonMezclaEq = new javax.swing.JLabel();
        BotonPolifase = new javax.swing.JLabel();
        BotonRadix = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleciona el algoritmo de ordenamiento que deseas realizar:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        BotonMezclaEq.setBackground(new java.awt.Color(233, 57, 26));
        BotonMezclaEq.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        BotonMezclaEq.setForeground(new java.awt.Color(255, 255, 255));
        BotonMezclaEq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonMezclaEq.setText("MEZCLA EQUILIBRADA");
        BotonMezclaEq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonMezclaEq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonMezclaEqMouseClicked(evt);
            }
        });
        jPanel3.add(BotonMezclaEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 150, 70));

        BotonPolifase.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        BotonPolifase.setForeground(new java.awt.Color(255, 255, 255));
        BotonPolifase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonPolifase.setText("POLIFASE");
        BotonPolifase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPolifase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonPolifaseMouseClicked(evt);
            }
        });
        jPanel3.add(BotonPolifase, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, 70));

        BotonRadix.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        BotonRadix.setForeground(new java.awt.Color(255, 255, 255));
        BotonRadix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotonRadix.setText("RADIX");
        BotonRadix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRadix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRadixMouseClicked(evt);
            }
        });
        jPanel3.add(BotonRadix, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 120, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 390, 440));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EDA II.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonPolifaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPolifaseMouseClicked
       Polifase p = new Polifase();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonPolifaseMouseClicked

    private void BotonRadixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRadixMouseClicked
        Radix radix = new Radix();
        radix.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonRadixMouseClicked

    private void BotonMezclaEqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMezclaEqMouseClicked
        MezclaEq mezcla=new MezclaEq();
        mezcla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonMezclaEqMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonMezclaEq;
    private javax.swing.JLabel BotonPolifase;
    private javax.swing.JLabel BotonRadix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
