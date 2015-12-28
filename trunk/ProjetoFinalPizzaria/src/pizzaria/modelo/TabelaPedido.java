package pizzaria.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelaPedido extends AbstractTableModel{

    //Aqui declare os vetores que preencheram a tabela

    private Integer[] vnTamanho = {70, 70, 70, 70, 70 }; // Definirá a largura das colunas
    private String[] vsTitulos = {"Num.Pedido","Entregador","Funcionário","Cliente","Pedido Datas"}; // Definirá os títulos das colunas
    private Class[] vsClasses = {Object.class, String.class, String.class, String.class, String.class}; // Classe dos valores
    private List<Pedido> dados = null; // Lista contendo os dados a serem exibidos
    // Lista de objetos genéricos que compõem a tabela
    private List<Object[]> rsTabela = new ArrayList<Object[]>();
    private double total = 0;

    //Método Construtor
    public TabelaPedido() {
        Object[] linha = {null, null, null, null, null};
        rsTabela.add(linha);
    }

    //Método utilizado para modificar a lista de dados da tabela
    public TabelaPedido(List<Pedido> lista) {
        setResultados(lista);
    }

    // Retorna a quantidade de linhas da tabela
    public int getRowCount() {
        return rsTabela.size();
    }

    // Retorna a quantidade de colunas da tabela
    public int getColumnCount() {
        return vsTitulos.length;
    }

    // Retorna o valor que será exibido em uma posição da tabela
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rsTabela.get(rowIndex)[columnIndex];
    }

    // Retorna a classe de objetos de uma coluna
 
    public Class getColumnClass(int columnIndex) {
        return vsClasses[columnIndex];
    }

    // Retorna a largura de uma coluna da tabela
    public int getColumnSize(int columnIndex) {
        return vnTamanho[columnIndex];
    }

    // Retorna o título de uma coluna

    public String getColumnName(int ColumnIndex) {
        return vsTitulos[ColumnIndex];
    }

   public void adicionarLinha(Pedido pedido) {
        Object[] linha = {"" + pedido.getPed_num(),pedido.getEntregador().getNome(),pedido.getFuncionario().getFun_nome(),pedido.getCliente().getCli_nome(),pedido.getPed_data()};
        rsTabela.add(linha);
        fireTableStructureChanged(); // Notifica a mudança de dados da Tabela
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dados.remove(linha);
        fireTableStructureChanged();
    }

    // Retorna o objeto Cidade da linha selecionada
    public Pedido getPedido(int linha) {
        try {
            Pedido pedido = null;
            if (dados != null && dados.size() > 0) {
                pedido = dados.get(linha);
            }
            return pedido;
        } catch (Exception e) {
            return null;
        }
    }

    // Define o conteúdo dos dados para preechimento da tabela
    public void setResultados(List<Pedido> lista) {
        dados = lista;
        rsTabela.clear();
        if (lista != null) {
            Iterator<Pedido> it = lista.iterator();
            while (it.hasNext()) {
                Pedido pedido = it.next();
                Object[] linha = {pedido.getPed_num(),pedido.getEntregador().getNome(),pedido.getFuncionario().getFun_nome(),pedido.getCliente().getCli_nome(),pedido.getPed_data()};
                rsTabela.add(linha);
            }
        }
        if (lista == null || lista.size() == 0) {
            Object[] linha = {null, null, null, null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }
}
