package pizzaria.visao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import pizzaria.modelo.Cliente;
import pizzaria.modelo.Logradouro;
import pizzaria.modelo.TabelaTelefone;
import pizzaria.modelo.Telefone;
import pizzaria.modeloDao.ClienteDAO;
import pizzaria.modeloDao.LogradouroDAO;

public class JFCadCliente extends javax.swing.JFrame {

    private Cliente cliente;
    private ClienteDAO clientedao;
    private boolean novo = true;
    private JDCnsCliente jdconsulta;
    private JDCnsLogradouro jdcons_logra;
    private LogradouroDAO logdao;
    private Logradouro logradouro;
    private DefaultComboBoxModel dclogradouro = new DefaultComboBoxModel();
    private SimpleDateFormat sdDtnasc = new SimpleDateFormat("dd/MM/yyyy");
    private List<Telefone> telefones;
    private TabelaTelefone tblfone = new TabelaTelefone();

    /** Classe Construtora **/
    public JFCadCliente() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        clientedao = new ClienteDAO();
        logdao = new LogradouroDAO();
        jtbTelefones.setModel(tblfone);
        jclogradouro.setModel(dclogradouro);
        criarMascaras();
        exibir();
    }

    private void criarMascaras() {
        ((MaskFormatter) jfCEP.getFormatter()).setPlaceholderCharacter('_');
        ((MaskFormatter) jfCPF.getFormatter()).setPlaceholderCharacter('_');
        ((MaskFormatter) jfDtNasc.getFormatter()).setPlaceholderCharacter('_');

    }

    /**  Construtor da Tela **/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtNome = new javax.swing.JTextField();
        btProcura = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jrMasc = new javax.swing.JRadioButton();
        jrFeminino = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jfDtNasc = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jfCPF = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jtRG = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jfCEP = new javax.swing.JFormattedTextField();
        btProcura2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jclogradouro = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jtBairro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtCidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtEstado = new javax.swing.JTextField();
        jtNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtCompl = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jfTel = new javax.swing.JFormattedTextField();
        btAdicionar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTelefones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");

        jLabel2.setText("ID:");

        jLabel3.setText("Nome:");

        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });

        btProcura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        buttonGroup1.add(jrMasc);
        jrMasc.setText("Masculino");

        buttonGroup1.add(jrFeminino);
        jrFeminino.setText("Feminino");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrMasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jrFeminino))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrMasc)
                    .addComponent(jrFeminino))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Dt. Nasc.:");

        try {
            jfDtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("CPF:");

        try {
            jfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("RG:");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel7.setText("CEP:");

        try {
            jfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jfCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jfCEPKeyReleased(evt);
            }
        });

        btProcura2.setText("Procurar");
        btProcura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcura2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Logradouro:");

        jclogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jclogradouroActionPerformed(evt);
            }
        });

        jLabel11.setText("Bairro:");

        jtBairro.setEditable(false);

        jLabel12.setText("Cidade:");

        jtCidade.setEditable(false);

        jLabel13.setText("Estado:");

        jtEstado.setEditable(false);

        jLabel10.setText("Número:");

        jLabel15.setText("Complemento:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btProcura2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jclogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel15)
                    .addComponent(jtCompl, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProcura2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jclogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(4, 4, 4)
                .addComponent(jtCompl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(583, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jfDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jfDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cadastro de Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefones"));

        jLabel14.setText("Telefone:");

        try {
            jfTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        jtbTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Telefone"
            }
        ));
        jScrollPane1.setViewportView(jtbTelefones);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jfTel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRemover)
                            .addComponent(btAdicionar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addContainerGap(319, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btExcluir)
                    .addComponent(btGravar)
                    .addComponent(btCanc)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-727)/2, (screenSize.height-730)/2, 727, 730);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novo = true;
        limpar();
        mudaEstado();
        jtId.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        try {
            if (novo) // Incluir
            {
                cliente = new Cliente();
            }

            cliente.setCli_nome(jtNome.getText());
            cliente.setCli_data_nasc(sdDtnasc.parse(jfDtNasc.getText()));
            cliente.setCli_cpf(jfCPF.getText());
            cliente.setCli_rg(jtRG.getText());
            cliente.setLogradouro(logradouro);
            cliente.setCli_numero(jtNumero.getText());
            cliente.setCli_compl(jtCompl.getText());

            if (jrFeminino.isSelected()) {
                cliente.setCli_sexo("F");
            } else {
                cliente.setCli_sexo("M");
            }
            cliente.setTelefones(telefones);
            if (JOptionPane.showConfirmDialog(null, "Gravar Dados do Cliente?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                if (novo) {
                    clientedao.incluir(cliente);
                } else {
                    clientedao.alterar(cliente);
                }
                novo = false;
                exibir();
                JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Excluir Cliente?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                clientedao.excluir(cliente);
                cliente = null;
                exibir();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
                cliente = clientedao.selecionarPorID(Integer.parseInt(jtId.getText()));
                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "Cliente não Cadastrado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                exibir();
                jtId.selectAll();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jtIdKeyTyped

    private void btProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraActionPerformed
        Cliente tmp;
        if (jdconsulta == null) {
            jdconsulta = new JDCnsCliente(this, true);
        }
        tmp = jdconsulta.exibeConsulta();
        if (tmp != null) {
            cliente = tmp;
            exibir();
        }

    }//GEN-LAST:event_btProcuraActionPerformed

    private void btProcura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcura2ActionPerformed
        Logradouro tmp;
        if (jdcons_logra == null) {
            jdcons_logra = new JDCnsLogradouro(this, true);
        }
        tmp = jdcons_logra.exibeConsulta();
        if (tmp != null) {
            jfCEP.setValue(tmp.getLog_cep());
            logradouro = tmp;
            carregarLogradouro(logradouro);
            exibirLogradouro();
        }

    }//GEN-LAST:event_btProcura2ActionPerformed

    private void jfCEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfCEPKeyReleased
        if (jfCEP.getText().indexOf('_') == -1) {
            carregarLogradouro(null);
        } else {
            logradouro = null;
            dclogradouro.removeAllElements();
        }

    }//GEN-LAST:event_jfCEPKeyReleased

    private void jclogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jclogradouroActionPerformed
        logradouro = (Logradouro) jclogradouro.getSelectedItem();
        exibirLogradouro();

    }//GEN-LAST:event_jclogradouroActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        Telefone tmp = new Telefone(0, jfTel.getText(), 0, 'N');

        if (cliente != null) {
            int pos = cliente.getTelefones().indexOf(tmp);

            if (pos >= 0) {
                tmp = cliente.getTelefones().get(pos);
            }
        }
        if (!telefones.contains(tmp)) {
            telefones.add(tmp);
        } else {
            JOptionPane.showMessageDialog(this, "Este Número de Telefone já Existe!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        tblfone.setResultados(telefones);
        jfTel.setValue(null);
        jfTel.requestFocus();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
       if (telefones.size() > 0 && jtbTelefones.getSelectedRow() >= 0) {
            tblfone.removerLinha(jtbTelefones.getSelectedRow());
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCadCliente().setVisible(true);
            }
        });
    }

    private void limpar() {
        jtId.setText("");
        jtNome.setText("");
        jtRG.setText("");
        jtCompl.setText("");
        jtNumero.setText("");
        jfCPF.setValue(null);
        jfCEP.setValue(null);
        jfDtNasc.setValue(null);
        logradouro = null;
        jrMasc.setSelected(true);
        telefones = new ArrayList<Telefone>();
        limparLogradouro();

    }

    private void exibir() {
        if (cliente != null) {
            novo = false;
            jtId.setText("" + cliente.getCli_id());
            jtNome.setText(cliente.getCli_nome());
            jtRG.setText(cliente.getCli_rg());
            jfCPF.setValue(cliente.getCli_cpf());
            jfCEP.setValue(cliente.getLogradouro().getLog_cep());
            jfDtNasc.setValue(sdDtnasc.format(cliente.getCli_data_nasc()));
            jtCompl.setText(cliente.getCli_compl());
            jtNumero.setText(cliente.getCli_numero());

            if (cliente.getCli_sexo().equalsIgnoreCase("F")) {
                jrFeminino.setSelected(true);
            } else {
                jrMasc.setSelected(true);
            }

            logradouro = cliente.getLogradouro();
            telefones = cliente.getTelefones();
            if (telefones == null)
                telefones = new ArrayList<Telefone>();
            carregarLogradouro(logradouro);
            exibirLogradouro();

        } else {
            limpar();
            novo = true;
        }
        tblfone.setResultados(telefones);
        mudaEstado();
        jtId.requestFocus();
    }

    private void mudaEstado() {

        if (cliente == null || novo) {
            btExcluir.setEnabled(false);
        } else if (cliente != null) {
            btExcluir.setEnabled(true);
        }


    }

    private void carregarLogradouro(Logradouro log) {
        try {
            if (jfCEP.getText().indexOf('_') == -1) {
                dclogradouro.removeAllElements();
                logdao.selecionarPorCEP(jfCEP.getText());
                for (int x = 0; x < logdao.getLista().size(); x++) {
                    dclogradouro.addElement(logdao.getLista().get(x));
                }
            }

            if (log != null) {
                dclogradouro.setSelectedItem(log);
            }
        } catch (Exception ex) {
        }
    }

    private void exibirLogradouro() {
        if (logradouro != null) {
            jtBairro.setText(logradouro.getBairro().getBai_Nome());
            jtCidade.setText(logradouro.getBairro().getCidade().getCid_nome());
            jtEstado.setText(logradouro.getBairro().getCidade().getEstado().getEst_uf());
        } else {
            limparLogradouro();
        }
    }

    private void limparLogradouro() {
        dclogradouro.removeAllElements();
        jtBairro.setText(null);
        jtCidade.setText(null);
        jtEstado.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCanc;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProcura;
    private javax.swing.JButton btProcura2;
    private javax.swing.JButton btRemover;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jclogradouro;
    private javax.swing.JFormattedTextField jfCEP;
    private javax.swing.JFormattedTextField jfCPF;
    private javax.swing.JFormattedTextField jfDtNasc;
    private javax.swing.JFormattedTextField jfTel;
    private javax.swing.JRadioButton jrFeminino;
    private javax.swing.JRadioButton jrMasc;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTextField jtCompl;
    private javax.swing.JTextField jtEstado;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtRG;
    private javax.swing.JTable jtbTelefones;
    // End of variables declaration//GEN-END:variables
}
