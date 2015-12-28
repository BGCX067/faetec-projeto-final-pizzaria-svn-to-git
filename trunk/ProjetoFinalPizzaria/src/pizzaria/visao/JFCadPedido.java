package pizzaria.visao;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pizzaria.modelo.Bebida;
import pizzaria.modelo.Cliente;
import pizzaria.modelo.Entregador;
import pizzaria.modelo.Funcionario;
import pizzaria.modelo.ItemPedido;
import pizzaria.modelo.Login;
import pizzaria.modelo.Pedido;
import pizzaria.modelo.Pizza;
import pizzaria.modelo.TabelaItemPedido;
import pizzaria.modelo.Venda;
import pizzaria.modeloDao.BebidaDAO;
import pizzaria.modeloDao.ClienteDAO;
import pizzaria.modeloDao.EntregadorDao;
import pizzaria.modeloDao.FuncionarioDao;
import pizzaria.modeloDao.ItemPedidoDao;
import pizzaria.modeloDao.LoginDAO;
import pizzaria.modeloDao.PedidoDao;
import pizzaria.modeloDao.PizzaDAO;
import pizzaria.modeloDao.VendaDao;

public class JFCadPedido extends javax.swing.JFrame {

    private List<ItemPedido> lista_pedidos;
    private TabelaItemPedido tblitemPedido = new TabelaItemPedido();
    private Pedido pedido;
    private PedidoDao pedidodao;
    private Entregador entregador;
    private Funcionario funcionario;
    private EntregadorDao entregadorDao;
    private FuncionarioDao funcionarioDao;
    private ClienteDAO clidao;
    private Venda venda;
    private VendaDao vendaDao;
    private PizzaDAO pizzadao;
    private LoginDAO logindao;
    private BebidaDAO bebidadao;
    private boolean novo = true;
    private Cliente cliente;
    private Pizza pizza;
    private Bebida bebida;
    private Login login;
    private JDCnsFuncionario jdFuncionario;
    private JDCnsEntregador jdEntregador;
    private JDCnsPedido jdPedido;
    private JDCnsPizza jdPizza;
    private JDCnsBebida jdBebida;
    private JDCnsCliente jdCliente;
    SimpleDateFormat sfData = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat sfPreco = new DecimalFormat("#,##0.00");

    public JFCadPedido() {
        initComponents();
        vendaDao = new VendaDao();
        pedidodao = new PedidoDao();
        clidao = new ClienteDAO();
        pizzadao = new PizzaDAO();
        bebidadao = new BebidaDAO();
        funcionarioDao = new FuncionarioDao();
        entregadorDao = new EntregadorDao();
        logindao = new LoginDAO();
        limpar();
        jtbPedido.setModel(tblitemPedido);
        setTamColunas();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jtNumero = new javax.swing.JTextField();
        btProcuraNum = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jfDataProduto = new javax.swing.JFormattedTextField();
        jlproduto = new javax.swing.JLabel();
        btProcuraProduto = new javax.swing.JButton();
        jtProdutoNome = new javax.swing.JTextField();
        btAddProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btRemoveProduto = new javax.swing.JButton();
        jcProduto = new javax.swing.JComboBox();
        jtEntregador = new javax.swing.JTextField();
        btProcuraEntre = new javax.swing.JButton();
        jtEntregadornome = new javax.swing.JTextField();
        jtCliNum = new javax.swing.JTextField();
        btProcuraCli = new javax.swing.JButton();
        jtCliNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtProdutoPreco = new javax.swing.JTextField();
        jtProdutoQuantidade = new javax.swing.JTextField();
        jtProdutoNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtFuncionario = new javax.swing.JTextField();
        btProcuraFunc = new javax.swing.JButton();
        jtFuncNome = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPedido = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jttotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pedido");

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Pedido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setLayout(null);

        jLabel2.setText("Número:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 80, 20);

        jlCliente.setText("Cliente:");
        jPanel2.add(jlCliente);
        jlCliente.setBounds(20, 50, 70, 20);

        jtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNumeroKeyTyped(evt);
            }
        });
        jPanel2.add(jtNumero);
        jtNumero.setBounds(20, 30, 60, 20);

        btProcuraNum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcuraNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraNumActionPerformed(evt);
            }
        });
        jPanel2.add(btProcuraNum);
        btProcuraNum.setBounds(90, 30, 30, 20);

        jLabel8.setText("Data do Pedido");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(140, 10, 90, 20);

        try {
            jfDataProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jfDataProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jfDataProdutoFocusLost(evt);
            }
        });
        jPanel2.add(jfDataProduto);
        jfDataProduto.setBounds(140, 30, 80, 20);

        jlproduto.setText("Bebida/Pizza:");
        jPanel2.add(jlproduto);
        jlproduto.setBounds(20, 130, 100, 20);

        btProcuraProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcuraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraProdutoActionPerformed(evt);
            }
        });
        jPanel2.add(btProcuraProduto);
        btProcuraProduto.setBounds(140, 150, 30, 20);

        jtProdutoNome.setEditable(false);
        jtProdutoNome.setFocusable(false);
        jPanel2.add(jtProdutoNome);
        jtProdutoNome.setBounds(240, 150, 200, 20);

        btAddProduto.setText("Adicionar");
        btAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProdutoActionPerformed(evt);
            }
        });
        jPanel2.add(btAddProduto);
        btAddProduto.setBounds(180, 190, 100, 23);

        jLabel10.setText("Valor:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(450, 130, 50, 20);

        btRemoveProduto.setText("Remover");
        btRemoveProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveProdutoActionPerformed(evt);
            }
        });
        jPanel2.add(btRemoveProduto);
        btRemoveProduto.setBounds(300, 190, 100, 23);

        jcProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Pizza", "Bebida" }));
        jPanel2.add(jcProduto);
        jcProduto.setBounds(20, 150, 100, 20);

        jtEntregador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtEntregadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEntregadorKeyTyped(evt);
            }
        });
        jPanel2.add(jtEntregador);
        jtEntregador.setBounds(250, 30, 60, 20);

        btProcuraEntre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcuraEntre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraEntreActionPerformed(evt);
            }
        });
        jPanel2.add(btProcuraEntre);
        btProcuraEntre.setBounds(320, 30, 30, 20);

        jtEntregadornome.setEditable(false);
        jtEntregadornome.setFocusable(false);
        jPanel2.add(jtEntregadornome);
        jtEntregadornome.setBounds(360, 30, 190, 20);

        jtCliNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCliNumKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCliNumKeyTyped(evt);
            }
        });
        jPanel2.add(jtCliNum);
        jtCliNum.setBounds(20, 70, 60, 20);

        btProcuraCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcuraCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraCliActionPerformed(evt);
            }
        });
        jPanel2.add(btProcuraCli);
        btProcuraCli.setBounds(90, 70, 30, 20);

        jtCliNome.setEditable(false);
        jtCliNome.setFocusable(false);
        jPanel2.add(jtCliNome);
        jtCliNome.setBounds(140, 70, 410, 20);

        jLabel3.setText("Entregador:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(250, 10, 90, 20);

        jLabel4.setText("Quantidade:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(530, 130, 80, 20);

        jtProdutoPreco.setEditable(false);
        jtProdutoPreco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtProdutoPreco.setFocusable(false);
        jPanel2.add(jtProdutoPreco);
        jtProdutoPreco.setBounds(450, 150, 70, 20);
        jPanel2.add(jtProdutoQuantidade);
        jtProdutoQuantidade.setBounds(530, 150, 60, 20);

        jtProdutoNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtProdutoNumKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtProdutoNumKeyTyped(evt);
            }
        });
        jPanel2.add(jtProdutoNum);
        jtProdutoNum.setBounds(180, 150, 50, 20);

        jLabel5.setText("Funcionário:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 90, 70, 20);

        jtFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFuncionarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtFuncionarioKeyTyped(evt);
            }
        });
        jPanel2.add(jtFuncionario);
        jtFuncionario.setBounds(20, 110, 60, 20);

        btProcuraFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcuraFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraFuncActionPerformed(evt);
            }
        });
        jPanel2.add(btProcuraFunc);
        btProcuraFunc.setBounds(90, 110, 30, 20);

        jtFuncNome.setEditable(false);
        jtFuncNome.setFocusable(false);
        jPanel2.add(jtFuncNome);
        jtFuncNome.setBounds(140, 110, 300, 20);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itens do Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jtbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Quantidade", "Valor Unitario", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbPedido.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtbPedido);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Sub-Total");

        jttotal.setBackground(new java.awt.Color(255, 255, 204));
        jttotal.setEditable(false);
        jttotal.setFont(new java.awt.Font("Tahoma", 1, 12));
        jttotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jttotal.setText("0,00");
        jttotal.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(444, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCanc)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCanc, btExcluir, btGravar, btNovo});

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
            .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-662)/2, (screenSize.height-618)/2, 662, 618);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novo = true;
        limpar();
        jfDataProduto.setValue(sfData.format(new Date()));
        mudaEstado();
        jtCliNum.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        try {
            if (novo) {
                    if (JOptionPane.showConfirmDialog(null, "Gravar dados da Venda ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    }
                    pedido = new Pedido();
                    if (!jtNumero.getText().isEmpty()) {
                        pedido.setPed_num(Integer.parseInt(jtNumero.getText()));
                    }

                    pedido.setEntregador(entregador);
                    pedido.setFuncionario(funcionario);
                    pedido.setCliente(cliente);
                    pedido.setPed_data(sfData.parse(jfDataProduto.getText()));
                    pedido.setListapedido(lista_pedidos);

                    pedidodao.incluir(pedido);

                    venda = new Venda();
                    venda.setFuncionario(funcionario);
                    venda.setPedido(pedido);

                    vendaDao.incluir(venda);

            } else {
                novo = false;
                if (JOptionPane.showConfirmDialog(null, "Deseja alterar dados do Pedido ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    {
                        pedidodao.alterar(pedido);
                    }
                }
            }
            exibir();
            JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso !", "Pedido", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btGravarActionPerformed
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Excluir Pedido ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                pedidodao.excluir(pedido);
                pedido = null;
                JOptionPane.showMessageDialog(null, "Pedido Excluido com Sucesso ! ");
                exibir();
            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancActionPerformed
        exibir();
    }//GEN-LAST:event_btCancActionPerformed

    private void jtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNumeroKeyTyped
        String numeros = "0123456789\n\b";
        if (numeros.indexOf(evt.getKeyChar()) == -1) {
            evt.consume();
            return;
        }

        if (!jtNumero.getText().isEmpty() && evt.getKeyChar() == '\n') {
            try {
                pedido = pedidodao.selecionarPorId(Integer.parseInt(jtNumero.getText()));
                if (pedido == null) {
                    JOptionPane.showMessageDialog(null, "Pedido não Cadastrada !", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                exibir();
                jtNumero.selectAll();


            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtNumeroKeyTyped

    private void btProcuraNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraNumActionPerformed
        if (jdPedido == null) {
            jdPedido = new JDCnsPedido(this, true);
        }
        Pedido tmp = jdPedido.exibeConsulta();
        if (tmp != null) {
            pedido = tmp;
            exibir();
        }
    }//GEN-LAST:event_btProcuraNumActionPerformed

    private void btAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProdutoActionPerformed

        if (jcProduto.getSelectedItem().equals("Pizza")) {
            try {
                ItemPedido tmp = new ItemPedido(0, bebida, pizza, Integer.parseInt(jtProdutoQuantidade.getText()), pizza.getPiz_preco(), pizza.getPiz_preco() * Integer.parseInt(jtProdutoQuantidade.getText()), 'P');

                if (pedido != null) {
                    int pos = pedido.getListapedido().indexOf(tmp);

                    if (pos >= 0) {
                        tmp = pedido.getListapedido().get(pos);
                    }
                }
                if (!lista_pedidos.contains(tmp)) {
                    lista_pedidos.add(tmp);
                } else {
                    tmp = lista_pedidos.get(lista_pedidos.indexOf(tmp));
                }

                atualizaTabela();
                pizza = null;
                exibirPizza();
                jtProdutoNum.equals("");
                jtProdutoNum.requestFocus();


            } catch (Exception ex) {
                Logger.getLogger(JFCadPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (jcProduto.getSelectedItem().equals("Bebida")) {
            try {
                ItemPedido tmp = new ItemPedido(0, bebida, pizza, Integer.parseInt(jtProdutoQuantidade.getText()), bebida.getBeb_preco(), bebida.getBeb_preco() * Integer.parseInt(jtProdutoQuantidade.getText()), 'B');

                if (pedido != null) {
                    int pos = pedido.getListapedido().indexOf(tmp);

                    if (pos >= 0) {
                        tmp = pedido.getListapedido().get(pos);
                    }
                }
                if (!lista_pedidos.contains(tmp)) {
                    lista_pedidos.add(tmp);
                } else {
                    tmp = lista_pedidos.get(lista_pedidos.indexOf(tmp));

                }
                atualizaTabela();
                bebida = null;
                exibirBebida();
                jtProdutoNum.equals("");
                jtProdutoNum.requestFocus();


            } catch (Exception ex) {
                Logger.getLogger(JFCadPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btAddProdutoActionPerformed

    private void btRemoveProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveProdutoActionPerformed
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        ItemPedido itemPedido = new ItemPedido();
        if (lista_pedidos.size() > 0 && jtbPedido.getSelectedRow() >= 0) {
            try {
                if (lista_pedidos.get(jtbPedido.getSelectedRow()).getBebida() != null) {
                    itemPedidoDao.excluirProd(lista_pedidos.get(jtbPedido.getSelectedRow()));

                } else if (lista_pedidos.get(jtbPedido.getSelectedRow()).getPizza() != null) {
                    itemPedidoDao.excluirProd(lista_pedidos.get(jtbPedido.getSelectedRow()));
                }
                tblitemPedido.removerLinha(jtbPedido.getSelectedRow());
                atualizaTabela();
            } catch (Exception ex) {
                Logger.getLogger(JFCadPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btRemoveProdutoActionPerformed

    private void btProcuraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraProdutoActionPerformed
        if (jcProduto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de Produto ! ");
        }
        if (jcProduto.getSelectedItem().equals("Pizza")) {
            jdPizza = new JDCnsPizza(this, true);

            Pizza tmp = jdPizza.exibeConsulta();
            if (tmp != null) {
                pizza = tmp;
                jtProdutoNome.setText("" + pizza.getPiz_id());
                exibirPizza();
            }
        } else if (jcProduto.getSelectedItem().equals("Bebida")) {
            jdBebida = new JDCnsBebida(this, true);

            Bebida tmpb = jdBebida.exibeConsulta();
            if (tmpb != null) {
                bebida = tmpb;
                jtProdutoNome.setText("" + bebida.getBeb_id());
                exibirBebida();
            }
        }
    }//GEN-LAST:event_btProcuraProdutoActionPerformed
    private void jfDataProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfDataProdutoFocusLost
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(sfData.parse(jfDataProduto.getText()));
            c.add(Calendar.DAY_OF_YEAR, 3);
            if (c.get(Calendar.DAY_OF_WEEK) == 1) {
                c.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_jfDataProdutoFocusLost

    private void jtEntregadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEntregadorKeyReleased
        if (!jtEntregador.getText().isEmpty()) {
            try {
                entregador = entregadorDao.selecionarPorCod(Integer.parseInt(jtEntregador.getText()));
            } catch (Exception ex) {
            }
        } else {
            entregador = null;
        }
        exibirEntregador();
    }//GEN-LAST:event_jtEntregadorKeyReleased

    private void jtEntregadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEntregadorKeyTyped
        String numeros = "0123456789\n\b";
        if (numeros.indexOf(evt.getKeyChar()) == -1) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_jtEntregadorKeyTyped

    private void btProcuraEntreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraEntreActionPerformed
        if (jdEntregador == null) {
            jdEntregador = new JDCnsEntregador(this, true);
        }
        Entregador tmp = jdEntregador.exibir();
        if (tmp != null) {
            entregador = tmp;
            jtEntregador.setText("" + entregador.getEnt_cod());
            exibirEntregador();
        }
    }//GEN-LAST:event_btProcuraEntreActionPerformed

    private void jtCliNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCliNumKeyReleased
        if (!jtCliNum.getText().isEmpty()) {
            try {
                cliente = clidao.selecionarPorID(Integer.parseInt(jtCliNum.getText()));
            } catch (Exception ex) {
            }
        } else {
            cliente = null;
        }
        exibirCliente();
    }//GEN-LAST:event_jtCliNumKeyReleased

    private void jtCliNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCliNumKeyTyped
        String numeros = "0123456789\n\b";
        if (numeros.indexOf(evt.getKeyChar()) == -1) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_jtCliNumKeyTyped

    private void btProcuraCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraCliActionPerformed
        if (jdCliente == null) {
            jdCliente = new JDCnsCliente(this, true);
        }

        Cliente tmp = jdCliente.exibeConsulta();
        if (tmp != null) {
            cliente = tmp;
            jtCliNum.setText("" + cliente.getCli_id());
            exibirCliente();
        }
    }//GEN-LAST:event_btProcuraCliActionPerformed

    private void jtProdutoNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutoNumKeyReleased
        if (jcProduto.getSelectedItem().equals("Pizza")) {
            if (!jtProdutoNum.getText().isEmpty()) {
                try {
                    pizza = pizzadao.selecionarPorId(Integer.parseInt(jtProdutoNum.getText()));
                } catch (Exception ex) {
                }
            } else {
                pizza = null;
            }
            exibirPizza();
        } else if (jcProduto.getSelectedItem().equals("Bebida")) {
            if (!jtProdutoNum.getText().isEmpty()) {
                try {
                    bebida = bebidadao.selecionarPorId(Integer.parseInt(jtProdutoNum.getText()));
                } catch (Exception ex) {
                }
            } else {
                bebida = null;
            }
            exibirBebida();
        }
    }//GEN-LAST:event_jtProdutoNumKeyReleased

    private void jtProdutoNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutoNumKeyTyped
        String numeros = "0123456789\n\b";
        if (numeros.indexOf(evt.getKeyChar()) == -1) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_jtProdutoNumKeyTyped

    private void jtFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFuncionarioKeyReleased
        if (!jtFuncNome.getText().isEmpty()) {
            try {
                funcionario = funcionarioDao.selecionarPorCod(Integer.parseInt(jtFuncionario.getText()));
            } catch (Exception ex) {
            }
        } else {
            funcionario = null;
        }
        exibirFuncionario();
    }//GEN-LAST:event_jtFuncionarioKeyReleased

    private void jtFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFuncionarioKeyTyped
        String numeros = "0123456789\n\b";
        if (numeros.indexOf(evt.getKeyChar()) == -1) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_jtFuncionarioKeyTyped

    private void btProcuraFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraFuncActionPerformed
        if (jdFuncionario == null) {
            jdFuncionario = new JDCnsFuncionario(this, true);
        }
        Funcionario tmp = jdFuncionario.exibir();
        if (tmp != null) {
            funcionario = tmp;
            jtFuncionario.setText("" + funcionario.getFun_mat());
            exibirFuncionario();
        }
    }//GEN-LAST:event_btProcuraFuncActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCadPedido().setVisible(true);
            }
        });
    }

    private void limpar() {
        jtNumero.setText("");
        jfDataProduto.setText("");
        jtCliNum.setText("");
        jtCliNome.setText("");
        cliente = null;
        jtEntregador.setText("");
        jtEntregadornome.setText("");
        entregador = null;
        jtFuncionario.setText("");
        jtFuncNome.setText("");
        funcionario = null;
        jcProduto.setSelectedIndex(0);
        lista_pedidos = new LinkedList<ItemPedido>();
        atualizaTabela();
        jfDataProduto.setValue(sfData.format(new Date()));

    }

    private void exibir() {
        if (pedido != null) {
            jtNumero.setText("" + pedido.getPed_num());
            jtEntregador.setText("" + pedido.getEntregador().getEnt_cod());
            entregador = pedido.getEntregador();
            //jtEntregadornome.setText("" + pedido.getEntregador().getNome());
            jtFuncionario.setText("" + pedido.getFuncionario().getFun_mat());
            funcionario = pedido.getFuncionario();
            //jtFuncNome.setText("" + pedido.getFuncionario().getFun_nome());
            jtCliNum.setText("" + pedido.getCliente().getCli_id());
            cliente = pedido.getCliente();
            jfDataProduto.setValue(sfData.format(pedido.getPed_data()));
            lista_pedidos = pedido.getListapedido();
            novo = false;
        } else {
            limpar();
            novo = true;
        }
        exibirCliente();
        exibirEntregador();
        exibirFuncionario();
        atualizaTabela();
        mudaEstado();
        jtNumero.requestFocus();
    }

    private void mudaEstado() {
        if (pedido == null || novo) {
            btExcluir.setEnabled(false);
            btGravar.setEnabled(true);
            btAddProduto.setEnabled(true);
            btRemoveProduto.setEnabled(true);
        } else if (pedido != null) {
            btExcluir.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddProduto;
    private javax.swing.JButton btCanc;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProcuraCli;
    private javax.swing.JButton btProcuraEntre;
    private javax.swing.JButton btProcuraFunc;
    private javax.swing.JButton btProcuraNum;
    private javax.swing.JButton btProcuraProduto;
    private javax.swing.JButton btRemoveProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox jcProduto;
    private javax.swing.JFormattedTextField jfDataProduto;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlproduto;
    private javax.swing.JTextField jtCliNome;
    private javax.swing.JTextField jtCliNum;
    private javax.swing.JTextField jtEntregador;
    private javax.swing.JTextField jtEntregadornome;
    private javax.swing.JTextField jtFuncNome;
    private javax.swing.JTextField jtFuncionario;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtProdutoNome;
    private javax.swing.JTextField jtProdutoNum;
    private javax.swing.JTextField jtProdutoPreco;
    private javax.swing.JTextField jtProdutoQuantidade;
    private javax.swing.JTable jtbPedido;
    private javax.swing.JTextField jttotal;
    // End of variables declaration//GEN-END:variables

    private void setTamColunas() {
        for (int i = 0; i < jtbPedido.getColumnCount(); i++) {
            jtbPedido.getColumnModel().getColumn(i).setMinWidth(tblitemPedido.getColumnSize(i));
            jtbPedido.getColumnModel().getColumn(i).setMaxWidth(tblitemPedido.getColumnSize(i));
        }
        jtbPedido.getTableHeader().setResizingAllowed(false);
        jtbPedido.getTableHeader().setReorderingAllowed(false);
    }

    private void exibirCliente() {
        if (cliente != null) {
            jtCliNome.setText(cliente.getCli_nome());
        } else {
            jtCliNome.setText("");
        }
    }

    private void exibirEntregador() {
        if (entregador != null) {
            jtEntregadornome.setText(entregador.getNome());
        } else {
            jtEntregadornome.setText("");
        }
    }

    private void exibirFuncionario() {
        if (funcionario != null) {
            jtFuncNome.setText(funcionario.getFun_nome());
        } else {
            jtEntregadornome.setText("");
        }
    }

    private void exibirPizza() {
        if (pizza != null) {
            if (jcProduto.getSelectedItem().equals("Pizza")) {
                jtProdutoNum.setText(String.valueOf(pizza.getPiz_id()));
                jtProdutoNome.setText(pizza.getPiz_sabor());
                jtProdutoPreco.setText(sfPreco.format(pizza.getPiz_preco()));
            }
        } else {
            jtProdutoNum.setText("");
            jtProdutoNome.setText("");
            jtProdutoPreco.setText("");
            jtProdutoQuantidade.setText("");
        }
    }

    private void exibirBebida() {
        if (bebida != null) {
            if (jcProduto.getSelectedItem().equals("Bebida")) {
                jtProdutoNum.setText(String.valueOf(bebida.getBeb_id()));
                jtProdutoNome.setText(bebida.getBeb_desc());
                jtProdutoPreco.setText(sfPreco.format(bebida.getBeb_preco()));
            }
        } else {
            jtProdutoNum.setText("");
            jtProdutoNome.setText("");
            jtProdutoPreco.setText("");
            jtProdutoQuantidade.setText("");
        }
    }

    private void atualizaTabela() {
        try {
            tblitemPedido.setResultados(lista_pedidos);
            setTamColunas();
            jttotal.setText(sfPreco.format(tblitemPedido.getTotal()));
        } catch (Exception e) {
        }
    }
}
