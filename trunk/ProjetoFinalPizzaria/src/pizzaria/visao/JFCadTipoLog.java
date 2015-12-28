package pizzaria.visao;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import pizzaria.modelo.TabelaTipoLog;
import pizzaria.modelo.TipoLog;
import pizzaria.modeloDao.TipoLogDAO;

public class JFCadTipoLog extends javax.swing.JFrame {

  private TipoLog tipoLog;
  private TipoLogDAO tipologdao;
  private boolean novo = true;
  private TabelaTipoLog tblTipLog = new TabelaTipoLog();

  // private JDCnsBairro jdBairro;
  /** Classe Construtora **/
  public JFCadTipoLog() {
    initComponents();
    jtbdados.setModel(tblTipLog);
    tipologdao = new TipoLogDAO();
    try {
      tipologdao.selecionarPorNome("");
      tblTipLog.setResultados(tipologdao.getLista());
    } catch (Exception ex) {
    }

    setTamColunas();
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
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbdados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipo de Logradouro");

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Tipo de Logradouro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setLayout(null);

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 0, 15, 14);

        jLabel3.setText("Nome:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(100, 0, 40, 14);

        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });
        jPanel2.add(jtId);
        jtId.setBounds(40, 20, 40, 20);
        jPanel2.add(jtNome);
        jtNome.setBounds(100, 20, 220, 20);

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
                .addGap(57, 57, 57)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravar)
                .addGap(18, 18, 18)
                .addComponent(btCanc)
                .addContainerGap(153, Short.MAX_VALUE))
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos"));

        jtbdados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbdados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbdados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbdados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbdadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbdados);
        jtbdados.getColumnModel().getColumn(0).setResizable(false);
        jtbdados.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtbdados.getColumnModel().getColumn(1).setResizable(false);
        jtbdados.getColumnModel().getColumn(1).setPreferredWidth(300);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-544)/2, (screenSize.height-381)/2, 544, 381);
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
          tipoLog = new TipoLog();
          if (!jtId.getText().isEmpty()) {
            tipoLog.setTplogra_id(Integer.parseInt(jtId.getText()));
          }
        }

        tipoLog.setTplogra_descr(jtNome.getText());

        if (JOptionPane.showConfirmDialog(null, "Gravar dados de Tipo de Logradouro ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
          if (novo) {
            tipologdao.incluir(tipoLog);
          } else {
            tipologdao.alterar(tipoLog);
          }
          novo = false;
          exibir();
          tipologdao.selecionarPorNome("");
          tblTipLog.setResultados(tipologdao.getLista());
          setTamColunas();
          JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso !", "Tipo de Logradouro", JOptionPane.INFORMATION_MESSAGE);
          btNovo.doClick();
        }
      } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
      }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
      if (JOptionPane.showConfirmDialog(null, "Excluir Tipo de Logradouro ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
        try {
          tipologdao.excluir(tipoLog);
          tipoLog = null;
          exibir();
          tipologdao.selecionarPorNome("");
          tblTipLog.setResultados(tipologdao.getLista());
          setTamColunas();
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
          tipoLog = tipologdao.selecionarPorId(Integer.parseInt(jtId.getText()));
          if (tipoLog == null) {
            JOptionPane.showMessageDialog(null, "Tipo de Logradouro não Cadastrado !", "Atenção", JOptionPane.WARNING_MESSAGE);
          }
          exibir();
          jtId.selectAll();

        } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_jtIdKeyTyped

    private void jtbdadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbdadosMouseClicked
      if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2 && tblTipLog.getRowCount() > 0) {
        tipoLog = tblTipLog.getTipoLog(jtbdados.getSelectedRow());
        exibir();
      }
    }//GEN-LAST:event_jtbdadosMouseClicked

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new JFCadTipoLog().setVisible(true);
      }
    });
  }

  private void limpar() {
    jtId.setText("");
    jtNome.setText("");

  }

  private void exibir() {
    if (tipoLog != null) {
      jtId.setText("" + tipoLog.getTplogra_id());
      jtNome.setText(tipoLog.getTplogra_descr());
      novo = false;
    } else {
      limpar();
      novo = true;
    }
    mudaEstado();
    jtId.requestFocus();
  }

  private void mudaEstado() {
    if (tipoLog == null || novo) {
      btExcluir.setEnabled(false);
    } else if (tipoLog != null) {
      btExcluir.setEnabled(true);
    }


  }

  private void setTamColunas() {
    for (int i = 0; i < jtbdados.getColumnCount(); i++) {
      jtbdados.getColumnModel().getColumn(i).setMinWidth(tblTipLog.getColumnSize(i));
    }
    jtbdados.getTableHeader().setResizingAllowed(false);
    jtbdados.getTableHeader().setReorderingAllowed(false);
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCanc;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTable jtbdados;
    // End of variables declaration//GEN-END:variables
}
