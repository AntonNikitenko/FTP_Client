import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Максим Гусев
 */
public class FTP_GUI extends javax.swing.JFrame {

    public static SimpleFTP ftp;
    public static String start;

    /**
     * Creates new form FTP_GUI
     */
    public FTP_GUI() {
        initComponents();
    }

    private void showMassageDialog() {
        int reply = JOptionPane.showConfirmDialog(null, "Создать новое подключение?", "Connection Error", JOptionPane.YES_NO_OPTION);
        // В зависимости от решения пльзователя: 
        if (reply == JOptionPane.NO_OPTION) {
            Frame[] open;
            open = FTP_GUI.getFrames();
            open[0].dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myLabel_serverName = new javax.swing.JLabel();
        myLabel_login = new javax.swing.JLabel();
        myLabel_password = new javax.swing.JLabel();
        myTextField_serverName = new javax.swing.JTextField();
        myTextField_login = new javax.swing.JTextField();
        myTextField_password = new javax.swing.JTextField();
        myButton_connect = new javax.swing.JButton();
        myLabel_port = new javax.swing.JLabel();
        myTextField_port = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FTP Client");
        setResizable(false);

        myLabel_serverName.setText("Server name:");

        myLabel_login.setText("Login:");

        myLabel_password.setText("Password:");

        myTextField_serverName.setText("ftp.funet.fi");

        myTextField_login.setText("username");

        myTextField_password.setText("password");

        myButton_connect.setText("Connect");
        myButton_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton_connectActionPerformed(evt);
            }
        });

        myLabel_port.setText("Port:");

        myTextField_port.setText("21");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(myButton_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myLabel_serverName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myTextField_serverName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(myLabel_port)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myTextField_port))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(myLabel_password)
                            .addComponent(myLabel_login))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myTextField_login)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(myTextField_password)
                                .addGap(6, 6, 6)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel_serverName)
                    .addComponent(myTextField_serverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel_port)
                    .addComponent(myTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel_login)
                    .addComponent(myTextField_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel_password)
                    .addComponent(myTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton_connect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton_connectActionPerformed
        try {
            ftp = new SimpleFTP();

            //start = ftp.connect("localhost", 21, "username", "password");
            start = ftp.connect(myTextField_serverName.getText(), Integer.parseInt(myTextField_port.getText()), myTextField_login.getText(), myTextField_password.getText());

            this.setVisible(false);
            Connection myConnection = new Connection();
            myConnection.setVisible(true);
        } catch (Exception ex) {
            showMassageDialog();
        }
    }//GEN-LAST:event_myButton_connectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FTP_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTP_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTP_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTP_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTP_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton myButton_connect;
    private javax.swing.JLabel myLabel_login;
    private javax.swing.JLabel myLabel_password;
    private javax.swing.JLabel myLabel_port;
    private javax.swing.JLabel myLabel_serverName;
    private javax.swing.JTextField myTextField_login;
    private javax.swing.JTextField myTextField_password;
    private javax.swing.JTextField myTextField_port;
    private javax.swing.JTextField myTextField_serverName;
    // End of variables declaration//GEN-END:variables
}