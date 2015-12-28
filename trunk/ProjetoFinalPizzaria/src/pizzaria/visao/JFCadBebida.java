package pizzaria.visao;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import pizzaria.modelo.Bebida;
import pizzaria.modeloDao.BebidaDAO;

public class JFCadBebida extends javax.swing.JFrame {

    private BebidaDAO bebidadao;
    private boolean novo = true;
    private Bebida bebida = null;
    private JDCnsBebida jdbebida;
    private DecimalFormat pzPreco = new DecimalFormat("##0.00");
    private DecimalFormat pzPreco2 = new DecimalFormat("#0.00");

    // private JDCnsBairro jdBairro;
    /** Classe Construtora **/
    public JFCadBebida() {
        initComponents();
        bebidadao = new BebidaDAO();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtValor = new javax.swing.JTextField();
        jtTamanho = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Bebidas");

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cadastro de Bebida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setLayout(null);

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 0, 15, 14);

        jLabel3.setText("Descrição:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 50, 90, 14);

        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });
        jPanel2.add(jtId);
        jtId.setBounds(30, 20, 40, 20);
        jPanel2.add(jtNome);
        jtNome.setBounds(30, 70, 320, 20);

        btProcura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraActionPerformed(evt);
            }
        });
        jPanel2.add(btProcura);
        btProcura.setBounds(80, 20, 50, 20);

        jLabel5.setText("Tamanho:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 100, 90, 14);

        jLabel6.setText("Valor:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(240, 100, 60, 14);

        jtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtValorFocusLost(evt);
            }
        });
        jtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtValorKeyTyped(evt);
            }
        });
        jPanel2.add(jtValor);
        jtValor.setBounds(240, 120, 80, 20);
        jPanel2.add(jtTamanho);
        jtTamanho.setBounds(30, 120, 140, 20);

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
                .addContainerGap(75, Short.MAX_VALUE)
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-455)/2, (screenSize.height-348)/2, 455, 348);
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
                bebida = new Bebida();
                if (!jtId.getText().isEmpty()) {
                    bebida.setBeb_id(Integer.parseInt(jtId.getText()));
                }
            }
            bebida.setBeb_desc(jtNome.getText());
            bebida.setBeb_preco(pzPreco.parse(jtValor.getText()).doubleValue());
            bebida.setBeb_tam(jtTamanho.getText());
            if (JOptionPane.showConfirmDialog(null, "Gravar dados de Bebida ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                if (novo) {
                    bebidadao.incluir(bebida);
                } else {
                    bebidadao.alterar(bebida);
                }
                novo = false;
                exibir();
                JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso !", "Bebida", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Excluir Bebida ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                bebidadao.excluir(bebida);
                bebida = null;
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
      String numeros = "0123456789\n\b";
      if (numeros.indexOf(evt.getKeyChar()) == -1) {
        evt.consume();
        return;
      }

      if (!jtId.getText().isEmpty() && evt.getKeyChar() == '\n') {
        try {
          bebida = bebidadao.selecionarPorId(Integer.parseInt(jtId.getText()));
          if (bebida == null) {
            JOptionPane.showMessageDialog(null, "Bebida não Cadastrada !", "Atenção", JOptionPane.WARNING_MESSAGE);
          }
          exibir();
          jtId.selectAll();


        } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_jtIdKeyTyped

    private void btProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraActionPerformed
        if (jdbebida == null) {
            jdbebida = new JDCnsBebida(this, true);
        }
        bebida = jdbebida.exibeConsulta();
        if (bebida != null) {
            exibir();
        }
}//GEN-LAST:event_btProcuraActionPerformed

private void jtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtValorFocusGained
      try {
        jtValor.setText(pzPreco2.format(pzPreco.parse(jtValor.getText()).floatValue()));
      } catch (Exception e) {
        jtValor.setText("0,00");
      }
      jtValor.selectAll();
}//GEN-LAST:event_jtValorFocusGained

private void jtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtValorFocusLost
      try {
        jtValor.setText(pzPreco.format(pzPreco.parse(jtValor.getText()).floatValue()));
      } catch (Exception e) {
        jtValor.setText("0,00");
      }
      jtValor.selectAll();
}//GEN-LAST:event_jtValorFocusLost

private void jtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtValorKeyTyped
      String numeros = "0123456789.,\n\b";
      if (numeros.indexOf(evt.getKeyChar()) == -1) {
        evt.consume();
        return;
      }
      if (".,".indexOf(evt.getKeyChar()) >= 0) {
        if (jtValor.getText().indexOf(',') == -1) {
          evt.setKeyChar(',');
        } else {
          evt.consume();
        }
      }
}//GEN-LAST:event_jtValorKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCadBebida().setVisible(true);
            }
        });
    }

    private void limpar() {
        jtId.setText("");
        jtNome.setText("");
        jtValor.setText("");
        jtTamanho.setText("");
    }

    private void exibir() {
        if (bebida != null) {
            jtId.setText("" + bebida.getBeb_id());
            jtNome.setText(bebida.getBeb_desc());
            jtValor.setText(pzPreco.format(bebida.getBeb_preco()));
            jtTamanho.setText(bebida.getBeb_tam());
            novo = false;
        } else {
            limpar();
            novo = true;
        }
        mudaEstado();
        jtId.requestFocus();
    }

    private void mudaEstado() {
        if (bebida == null || novo) {
            btExcluir.setEnabled(false);
        } else if (bebida != null) {
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtTamanho;
    private javax.swing.JTextField jtValor;
    // End of variables declaration//GEN-END:variables
}
