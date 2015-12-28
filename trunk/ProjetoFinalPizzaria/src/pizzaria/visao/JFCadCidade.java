package pizzaria.visao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import pizzaria.modelo.Cidade;
import pizzaria.modelo.Estado;
import pizzaria.modeloDao.CidadeDAO;
import pizzaria.modeloDao.EstadoDAO;

public class JFCadCidade extends javax.swing.JFrame {

  private Cidade cidade;
  private CidadeDAO cidadedao;
  private boolean novo = true;
  private JDCnsCidade jdCidade;
  DefaultComboBoxModel dcmEstado;
  EstadoDAO estdao;

  /** Classe Construtora **/
  public JFCadCidade() {
    initComponents();
    estdao = new EstadoDAO();
    try {
      dcmEstado = new DefaultComboBoxModel(estdao.selecionarPorNome("").toArray());
    } catch (Exception ex) {
      dcmEstado = new DefaultComboBoxModel();
      dcmEstado.addElement("Erro");
    }
    jcEstado.setModel(dcmEstado);
    cidadedao = new CidadeDAO();
    limpar();
  }

  /**  Construtor da Tela **/
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtNome = new javax.swing.JTextField();
        btProcura = new javax.swing.JButton();
        jcEstado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidade");

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cadastro de Cidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setLayout(null);

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 20, 15, 14);

        jLabel3.setText("Nome:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 70, 40, 14);

        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });
        jPanel2.add(jtId);
        jtId.setBounds(40, 40, 40, 20);
        jPanel2.add(jtNome);
        jtNome.setBounds(40, 90, 220, 20);

        btProcura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraActionPerformed(evt);
            }
        });
        jPanel2.add(btProcura);
        btProcura.setBounds(90, 40, 40, 20);

        jPanel2.add(jcEstado);
        jcEstado.setBounds(270, 90, 60, 20);

        jLabel4.setText("UF:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(270, 70, 17, 14);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btCanc.setText("Cancelar");
        btCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravar)
                .addGap(18, 18, 18)
                .addComponent(btCanc)
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btExcluir)
                    .addComponent(btGravar)
                    .addComponent(btCanc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-430)/2, (screenSize.height-330)/2, 430, 330);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
      novo = true;
      limpar();
      mudaEstado();
      jtNome.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
      try {
        if (novo) // Incluir
        {
          cidade = new Cidade();
          if (!jtId.getText().isEmpty()) {
            cidade.setCid_id(Integer.parseInt(jtId.getText()));
          }
        }

        cidade.setCid_nome(jtNome.getText());
        cidade.setEstado((Estado) jcEstado.getModel().getSelectedItem());

        if (JOptionPane.showConfirmDialog(null, "Gravar dados de Cidade ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
          if (novo) {
            cidadedao.incluir(cidade);
          } else {
            cidadedao.alterar(cidade);
          }
          novo = false;
          exibir();
          JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso !", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }
      } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
      }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
      if (JOptionPane.showConfirmDialog(null, "Excluir Cidade ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
        try {
          cidadedao.excluir(cidade);
          cidade = null;
          exibir();
        } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancActionPerformed
      exibir();
    }//GEN-LAST:event_btCancActionPerformed

    private void jtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtIdKeyTyped
      if (!jtId.getText().isEmpty() && evt.getKeyChar() == '\n') {
        try {
          cidade = cidadedao.selecionarPorId(Integer.parseInt(jtId.getText()));
          if (cidade == null) {
            JOptionPane.showMessageDialog(null, "Cidade não Cadastrada !", "Atenção", JOptionPane.WARNING_MESSAGE);
          }
          exibir();
          jtId.selectAll();

        } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_jtIdKeyTyped

    private void btProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraActionPerformed
      if (jdCidade == null) {
        jdCidade = new JDCnsCidade(this, true);
      }
      Cidade tmp = jdCidade.exibeConsulta();
      if (tmp != null) {
        cidade = tmp;
        exibir();
      }
}//GEN-LAST:event_btProcuraActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new JFCadCidade().setVisible(true);
      }
    });
  }

  private void limpar() {
    jtId.setText("");
    jtNome.setText("");
    jcEstado.getModel().setSelectedItem(null);
  }

  private void exibir() {
    if (cidade != null) {
      jtId.setText("" + cidade.getCid_id());
      jtNome.setText(cidade.getCid_nome());
      jcEstado.getModel().setSelectedItem(cidade.getEstado());
      novo = false;
    } else {
      limpar();
      novo = true;
    }
    mudaEstado();
    jtId.requestFocus();
  }

  private void mudaEstado() {
    if (cidade == null || novo) {
      btExcluir.setEnabled(false);
    } else if (cidade != null) {
      btExcluir.setEnabled(true);
    }
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCanc;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProcura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables
}
