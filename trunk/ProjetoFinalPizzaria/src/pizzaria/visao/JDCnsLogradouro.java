package pizzaria.visao;

import java.text.ParseException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import pizzaria.modelo.Bairro;
import pizzaria.modelo.Cidade;
import pizzaria.modelo.Estado;
import pizzaria.modelo.Logradouro;
import pizzaria.modelo.TabelaLog;
import pizzaria.modeloDao.BairroDAO;
import pizzaria.modeloDao.CidadeDAO;
import pizzaria.modeloDao.EstadoDAO;
import pizzaria.modeloDao.LogradouroDAO;

public class JDCnsLogradouro extends javax.swing.JDialog {

    /** Creates new form JDCnsEstado */
    private TabelaLog tblLog = new TabelaLog();
    private LogradouroDAO logdao;
    private EstadoDAO estdao;
    private CidadeDAO ciddao;
    private BairroDAO baidao;
    private Logradouro log = null;
    private DefaultComboBoxModel dcEstado;
    private DefaultComboBoxModel dcCidade;
    private DefaultComboBoxModel dcBairro;

    public JDCnsLogradouro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         estdao = new EstadoDAO();
         ciddao = new CidadeDAO();
         baidao = new BairroDAO();
         dcCidade = new DefaultComboBoxModel();
         dcBairro =  new DefaultComboBoxModel();
         getRootPane().setDefaultButton(jbBuscar);

         carregarEstado();
        // Inicializa padrões da tabela
        jtbdados.setModel(tblLog);
        setTamColunas();
        logdao = new LogradouroDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpOpcao = new javax.swing.JPanel();
        jrEnd = new javax.swing.JRadioButton();
        jrCEP = new javax.swing.JRadioButton();
        jlEstado = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jcEstado = new javax.swing.JComboBox();
        jcCidade = new javax.swing.JComboBox();
        jcBairro = new javax.swing.JComboBox();
        jlLogCep = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jfBusca = new javax.swing.JFormattedTextField();
        jpResultado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbdados = new javax.swing.JTable();
        jpBotoes = new javax.swing.JPanel();
        btOk = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Logradouro");
        setMinimumSize(null);

        jpTitulo.setBackground(new java.awt.Color(204, 0, 0));
        jpTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de Logradouro");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpTituloLayout = new javax.swing.GroupLayout(jpTitulo);
        jpTitulo.setLayout(jpTituloLayout);
        jpTituloLayout.setHorizontalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        jpTituloLayout.setVerticalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        buttonGroup1.add(jrEnd);
        jrEnd.setSelected(true);
        jrEnd.setText("Por Endereço");
        jrEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEndActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrCEP);
        jrCEP.setText("Por CEP");
        jrCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEndActionPerformed(evt);
            }
        });

        jlEstado.setText("Estado");

        jlCidade.setText("Cidade");

        jlBairro.setText("Bairro");

        jcEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEstadoActionPerformed(evt);
            }
        });

        jcCidade.setEnabled(false);
        jcCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCidadeActionPerformed(evt);
            }
        });

        jcBairro.setEnabled(false);

        jlLogCep.setText("Logradouro/CEP");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOpcaoLayout = new javax.swing.GroupLayout(jpOpcao);
        jpOpcao.setLayout(jpOpcaoLayout);
        jpOpcaoLayout.setHorizontalGroup(
            jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOpcaoLayout.createSequentialGroup()
                        .addComponent(jfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar))
                    .addComponent(jlLogCep)
                    .addGroup(jpOpcaoLayout.createSequentialGroup()
                        .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrEnd)
                            .addComponent(jlEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrCEP)
                            .addComponent(jlCidade)
                            .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlBairro))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jpOpcaoLayout.setVerticalGroup(
            jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOpcaoLayout.createSequentialGroup()
                        .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrEnd)
                            .addComponent(jrCEP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEstado)
                            .addComponent(jlCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jlLogCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOpcaoLayout.createSequentialGroup()
                        .addComponent(jlBairro)
                        .addGap(59, 59, 59)))
                .addGroup(jpOpcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBuscar)
                    .addComponent(jfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultados"));

        jtbdados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Logradouro", "CEP", "Bairro", "Cidade", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbdados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtbdados);
        jtbdados.getColumnModel().getColumn(0).setResizable(false);
        jtbdados.getColumnModel().getColumn(1).setResizable(false);
        jtbdados.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout jpResultadoLayout = new javax.swing.GroupLayout(jpResultado);
        jpResultado.setLayout(jpResultadoLayout);
        jpResultadoLayout.setHorizontalGroup(
            jpResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jpResultadoLayout.setVerticalGroup(
            jpResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        btOk.setText("OK");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btVoltar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpOpcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jpBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jpOpcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-605)/2, (screenSize.height-473)/2, 605, 473);
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        if (jtbdados.getSelectedRow() >= 0) {
            this.log = tblLog.getTipoLog(jtbdados.getSelectedRow());
            this.setVisible(false);
        }
    }//GEN-LAST:event_btOkActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        log = null;
        setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jcEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEstadoActionPerformed
        carregarCidade();
    }//GEN-LAST:event_jcEstadoActionPerformed

    private void jcCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCidadeActionPerformed
        carregarBairro();
    }//GEN-LAST:event_jcCidadeActionPerformed

    private void jrEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEndActionPerformed
       jlEstado.setEnabled(jrEnd.isSelected());
       jlCidade.setEnabled(jrEnd.isSelected() && jcEstado.getSelectedIndex() >= 0);
       jlBairro.setEnabled(jrEnd.isSelected() && jcCidade.getSelectedIndex() >= 0);
       jcEstado.setEnabled(jrEnd.isSelected());
       jcCidade.setEnabled(jrEnd.isSelected() && jcEstado.getSelectedIndex() >= 0);
       jcBairro.setEnabled(jrEnd.isSelected() && jcCidade.getSelectedIndex() >= 0);

       if (jrEnd.isSelected()) {
           jlLogCep.setText("Logradouro");
           jfBusca.setFormatterFactory(null);
       } else {
           jlLogCep.setText("CEP");
            try {
                jfBusca.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###-###")));
            } catch (ParseException ex) {
                
            }
       }
       jfBusca.setValue(null);
       jfBusca.setText("");
    }//GEN-LAST:event_jrEndActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            if (jrCEP.isSelected()) {
                logdao.selecionarPorCEP(jfBusca.getText());
            } else {
                if (jcBairro.getModel().getSelectedItem() instanceof Bairro) {
                    Bairro bai = (Bairro) jcBairro.getModel().getSelectedItem();
                    logdao.selecionarPorBairro(bai.getBai_Id(), jfBusca.getText());
                } else {
                    JOptionPane.showMessageDialog(null,"Selecione um Bairro!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            tblLog.setResultados(logdao.getLista());
            setTamColunas();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDCnsLogradouro dialog = new JDCnsLogradouro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void setTamColunas() {
        for (int i = 0; i < tblLog.getColumnCount(); i++) {
            jtbdados.getColumnModel().getColumn(i).setMinWidth(tblLog.getColumnSize(i));
            jtbdados.getColumnModel().getColumn(i).setMaxWidth(tblLog.getColumnSize(i));
        }
        jtbdados.getTableHeader().setResizingAllowed(false);
        jtbdados.getTableHeader().setReorderingAllowed(false);
    }

    public Logradouro exibeConsulta() {
        this.setModal(true);
        this.setVisible(true);
        return this.log;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JComboBox jcBairro;
    private javax.swing.JComboBox jcCidade;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JFormattedTextField jfBusca;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlLogCep;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpOpcao;
    private javax.swing.JPanel jpResultado;
    private javax.swing.JPanel jpTitulo;
    private javax.swing.JRadioButton jrCEP;
    private javax.swing.JRadioButton jrEnd;
    private javax.swing.JTable jtbdados;
    // End of variables declaration//GEN-END:variables

    private void carregarEstado() {
        try {
            estdao.selecionarPorNome("");
            dcEstado = new DefaultComboBoxModel(estdao.getLista().toArray());
            jcEstado.setModel(dcEstado);
            dcEstado.setSelectedItem(null);
        } catch (Exception e) {
        }
        dcCidade.setSelectedItem(null);
        jcCidade.setEnabled(false);
    }

    private void carregarCidade() {
        try {
          if (dcEstado != null && dcEstado.getSelectedItem() instanceof Estado) {
            ciddao.selecionarPorEstado(((Estado) dcEstado.getSelectedItem()).getEst_uf(),"");
            dcCidade = new DefaultComboBoxModel(ciddao.getLista().toArray());
            jcCidade.setModel(dcCidade);
            dcCidade.setSelectedItem(null);
            jcCidade.setEnabled(true);
          }
        } catch (Exception e) {
        }
        dcBairro.setSelectedItem(null);
        jcBairro.setEnabled(false);
    }

    private void carregarBairro() {
        try {
          if (dcCidade != null && dcCidade.getSelectedItem() instanceof Cidade) {
            dcBairro = new DefaultComboBoxModel(baidao.selecionarPorCidade(((Cidade) dcCidade.getSelectedItem()).getCid_id(), "").toArray());
            jcBairro.setModel(dcBairro);
            dcBairro.setSelectedItem(null);
            jcBairro.setEnabled(true);
          }
        } catch (Exception e) {
            
        }
    }
}
