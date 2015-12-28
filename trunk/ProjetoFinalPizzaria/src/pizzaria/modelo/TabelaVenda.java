package pizzaria.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaVenda extends AbstractTableModel{

    //Aqui declare os vetores que preencheram a tabela
    private Integer[] vnTamanho = {70, 100, 70}; // Definirá a largura das colunas
    private String[] vsTitulos = {"ID Venda","Funcionário","Num.Pedido"}; // Definirá os títulos das colunas
    private Class[] vsClasses = {Object.class, String.class, String.class}; // Classe dos valores
    private List<Venda> dados = null; // Lista contendo os dados a serem exibidos
    // Lista de objetos genéricos que compõem a tabela
    private List<Object[]> rsTabela = new ArrayList<Object[]>();
    private double total = 0;

    //Método Construtor
    public TabelaVenda() {
        Object[] linha = {null, null, null};
        rsTabela.add(linha);
    }

    //Método utilizado para modificar a lista de dados da tabela
    public TabelaVenda(List<Venda> lista) {
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

    public void adicionarLinha(Venda venda) {
        Object[] linha = {"" + venda.getVenda_id(), venda.getFuncionario().getFun_nome(), venda.getPedido().getPed_num()};
        rsTabela.add(linha);
        fireTableStructureChanged(); // Notifica a mudança de dados da Tabela
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dados.remove(linha);
        fireTableStructureChanged();
    }

    // Retorna o objeto Cidade da linha selecionada
    public Venda getVenda(int linha) {
        try {
            Venda venda = null;
            if (dados != null && dados.size() > 0) {
                venda = dados.get(linha);
            }
            return venda;
        } catch (Exception e) {
            return null;
        }
    }

    // Define o conteúdo dos dados para preechimento da tabela
    public void setResultados(List<Venda> lista) {
        dados = lista;
        rsTabela.clear();
        if (lista != null) {
            Iterator<Venda> it = lista.iterator();
            while (it.hasNext()) {
                Venda venda = it.next();
                Object[] linha = {venda.getVenda_id(), venda.getFuncionario().getFun_nome(), venda.getPedido().getPed_num()};
                rsTabela.add(linha);
            }
        }
        if (lista == null || lista.size() == 0) {
            Object[] linha = {null, null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }
}
