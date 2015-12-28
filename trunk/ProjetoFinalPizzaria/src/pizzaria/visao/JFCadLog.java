package pizzaria.visao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import pizzaria.modelo.Bairro;
import pizzaria.modelo.Cidade;
import pizzaria.modelo.Logradouro;
import pizzaria.modelo.TipoLog;
import pizzaria.modeloDao.LogradouroDAO;
import pizzaria.modeloDao.TipoLogDAO;

public class JFCadLog extends javax.swing.JFrame {

    private Logradouro log;
    private LogradouroDAO logdao;
    private boolean novo = true;
    private JDCnsCidade jdcidade;
    private JDCnsBairro jdbairro;
    private JDCnsLogradouro jdLog;
    private Cidade cidade;
    private Bairro bairro;
    DefaultComboBoxModel dcmTipoLog;
    TipoLogDAO tipologdao;

    // private JDCnsBairro jdBairro;
    /** Classe Construtora **/
    public JFCadLog() {
        initComponents();
        tipologdao = new TipoLogDAO();
        try {
            dcmTipoLog = new DefaultComboBoxModel(tipologdao.selecionarPorNome("").toArray());
        } catch (Exception ex) {
            dcmTipoLog = new DefaultComboBoxModel();
            dcmTipoLog.addElement("Erro");
        }
        jcTipo.setModel(dcmTipoLog);
        logdao = new LogradouroDAO();
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
        btBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtIdBai = new javax.swing.JTextField();
        btBuscaBairro = new javax.swing.JButton();
        jtNomeCid = new javax.swing.JTextField();
        jcEstado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jtNomeBai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtCep = new javax.swing.JFormattedTextField();
        jcTipo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Logradouro");

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Logradouro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel2.setLayout(null);

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 0, 15, 14);

        jLabel3.setText("Nome:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 50, 40, 14);

        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });
        jPanel2.add(jtId);
        jtId.setBounds(40, 20, 40, 20);
        jPanel2.add(jtNome);
        jtNome.setBounds(40, 70, 320, 20);

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btBuscar);
        btBuscar.setBounds(90, 20, 40, 20);

        jLabel4.setText("Cidade:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 100, 50, 14);

        jLabel5.setText("Bairro:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 150, 50, 14);
        jPanel2.add(jtIdBai);
        jtIdBai.setBounds(40, 170, 50, 20);

        btBuscaBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btBuscaBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaBairroActionPerformed(evt);
            }
        });
        jPanel2.add(btBuscaBairro);
        btBuscaBairro.setBounds(100, 170, 40, 20);
        jPanel2.add(jtNomeCid);
        jtNomeCid.setBounds(40, 120, 320, 20);

        jPanel2.add(jcEstado);
        jcEstado.setBounds(370, 120, 70, 20);

        jLabel6.setText("Estado:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(370, 100, 50, 14);
        jPanel2.add(jtNomeBai);
        jtNomeBai.setBounds(170, 170, 230, 20);

        jLabel7.setText("CEP:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(370, 50, 30, 14);

        try {
            jtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(jtCep);
        jtCep.setBounds(370, 70, 70, 20);

        jPanel2.add(jcTipo);
        jcTipo.setBounds(190, 20, 170, 20);

        jLabel8.setText("Tipo:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(190, 0, 40, 14);

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
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravar)
                .addGap(18, 18, 18)
                .addComponent(btCanc)
                .addGap(56, 56, 56))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-493)/2, (screenSize.height-410)/2, 493, 410);
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
                log = new Logradouro();
                if (!jtId.getText().isEmpty()) {
                    log.setLog_id(Integer.parseInt(jtId.getText()));
                }
            }

            log.setLog_nome(jtNome.getText());
            log.setLog_cep(jtCep.getText());
            log.setBairro(bairro);
            log.setTipolog((TipoLog) jcTipo.getModel().getSelectedItem());


            if (JOptionPane.showConfirmDialog(null, "Gravar dados de Logradouro ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                if (novo) {
                    logdao.incluir(log);
                } else {
                    logdao.alterar(log);
                }
                novo = false;
                exibir();
                JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso !", "Logradouro", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Excluir Logradouro ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                logdao.excluir(log);
                log = null;
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
                log = logdao.selecionarPorId(Integer.parseInt(jtId.getText()));
                if (log == null) {
                    JOptionPane.showMessageDialog(null, "Logradouro não Cadastrado !", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                exibir();
                jtId.selectAll();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtIdKeyTyped

    private void btBuscaBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaBairroActionPerformed
        if (jdbairro == null) {
            jdbairro = new JDCnsBairro(this, true);
        }

        bairro = jdbairro.exibeConsulta();
        if (bairro != null) {
            exibirBairro();
        }
    }//GEN-LAST:event_btBuscaBairroActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (jdLog == null) {
            jdLog = new JDCnsLogradouro(this, true);
        }
        Logradouro tmp = jdLog.exibeConsulta();
        if (tmp != null) {
            log = tmp;
            exibir();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCadLog().setVisible(true);
            }
        });
    }

    private void limpar() {
        jtId.setText("");
        jtNome.setText("");
        jtCep.setText("");
        jtNomeCid.setText("");
        jtIdBai.setText("");
        jtNomeBai.setText("");
        jcTipo.getModel().setSelectedItem(null);
        jcEstado.getModel().setSelectedItem(null);

    }

    private void exibir() {
        if (log != null) {
            jtId.setText("" + log.getLog_id());
            jtNome.setText(log.getLog_nome());
            jtCep.setText(log.getLog_cep());
            jcTipo.getModel().setSelectedItem(log.getTipolog());
            jcEstado.getModel().setSelectedItem(log.getBairro().getCidade().getEstado());
            jtNomeCid.setText(log.getBairro().getCidade().getCid_nome());
            jtNomeBai.setText(log.getBairro().getBai_Nome());
            jtIdBai.setText("" + log.getBairro().getBai_Id());

            novo = false;
        } else {
            limpar();
            novo = true;
        }
        mudaEstado();
        jtId.requestFocus();
    }

    private void mudaEstado() {
        if (log == null || novo) {
            btExcluir.setEnabled(false);
        } else if (log != null) {
            btExcluir.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscaBairro;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCanc;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JComboBox jcTipo;
    private javax.swing.JFormattedTextField jtCep;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtIdBai;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtNomeBai;
    private javax.swing.JTextField jtNomeCid;
    // End of variables declaration//GEN-END:variables

    private void exibirCidade() {
        if (cidade != null) {
            jtNomeCid.setText(cidade.getCid_nome());
            jcEstado.getModel().setSelectedItem(cidade.getEstado());
        } else {
            jtNomeCid.setText("");
            jcEstado.getModel().setSelectedItem(null);
        }
    }

    private void exibirBairro() {
        if (bairro != null) {
            jtIdBai.setText("" + bairro.getBai_Id());
            jtNomeBai.setText(bairro.getBai_Nome());
            cidade = bairro.getCidade();
            exibirCidade();
        } else {
            jtIdBai.setText("");
            jtNomeBai.setText("");
        }
    }
}
