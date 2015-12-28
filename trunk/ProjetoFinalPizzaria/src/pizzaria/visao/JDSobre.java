package pizzaria.visao;


import pizzaria.modelo.Login;
import pizzaria.modeloDao.LoginDAO;

public class JDSobre extends javax.swing.JDialog {

    /** Creates new form JDCnsEstado */
    private LoginDAO logindao;
    private Login login = null;

    public JDSobre() {
        super();
        initComponents();

    // Inicializa padrões da tabela
    logindao = new LoginDAO();

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpOpcao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre Pizzaria Tá na Mesa");
        setMinimumSize(null);

        jpOpcao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpOpcao.setLayout(null);

        jLabel1.setText("Desenvolvido por");
        jpOpcao.add(jLabel1);
        jLabel1.setBounds(30, 130, 100, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22));
        jLabel3.setText("Sistema Pizzaria Tá na Mesa");
        jpOpcao.add(jLabel3);
        jLabel3.setBounds(30, 30, 278, 30);

        jLabel5.setText("Copyright © System Space - Todos os direitos reservados");
        jpOpcao.add(jLabel5);
        jLabel5.setBounds(90, 180, 350, 20);
        jpOpcao.add(jSeparator1);
        jSeparator1.setBounds(0, 90, 510, 10);

        jLabel6.setText("v.1.0");
        jpOpcao.add(jLabel6);
        jLabel6.setBounds(460, 190, 34, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/SS_TCC.png"))); // NOI18N
        jpOpcao.add(jLabel2);
        jLabel2.setBounds(120, 100, 180, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/PT_logo.png"))); // NOI18N
        jpOpcao.add(jLabel4);
        jLabel4.setBounds(350, 10, 150, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpOpcao, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpOpcao, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-529)/2, (screenSize.height-254)/2, 529, 254);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDSobre dialog = new JDSobre();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }  



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpOpcao;
    // End of variables declaration//GEN-END:variables

}
