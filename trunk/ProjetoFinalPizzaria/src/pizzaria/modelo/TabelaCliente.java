package pizzaria.modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TabelaCliente extends AbstractTableModel {
    //Aqui declare os vetores que preencheram a tabela

    private Integer[] vnTamanho = {70, 500}; // Definirá a largura das colunas
    private String[] vsTitulos = {"ID", "Nome"}; // Definirá os títulos das colunas
    private Class[] vsClasses = {Object.class, String.class}; // Classe dos valores
    private List<Cliente> dados = null; // Lista contendo os dados a serem exibidos
    // Lista de objetos genéricos que compõem a tabela
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    //Método Construtor
    public TabelaCliente() {
        Object[] linha = {null, ""};
        rsTabela.add(linha);
    }

    //Método utilizado para modificar a lista de dados da tabela
    public TabelaCliente(List<Cliente> lista) {
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
    @Override
    public Class getColumnClass(int columnIndex) {
        return vsClasses[columnIndex];
    }

    // Retorna a largura de uma coluna da tabela
    public int getColumnSize(int columnIndex) {
        return vnTamanho[columnIndex];
    }

    // Retorna o título de uma coluna
    @Override
    public String getColumnName(int ColumnIndex) {
        return vsTitulos[ColumnIndex];
    }

    public void adicionarLinha(Cliente cliente) {
        Object[] linha = {cliente.getCli_id(), cliente.getCli_nome()};
        rsTabela.add(linha);
        fireTableStructureChanged(); // Notifica a mudança de dados da Tabela
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dados.remove(linha);
        fireTableStructureChanged();
    }

    // Retorna o objeto Pessoa da linha selecionada
    public Cliente getCliente(int linha) {
        try {
            Cliente cliente = null;
            if (dados != null && dados.size() > 0) {
                cliente = dados.get(linha);
            }
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    // Define o conteúdo dos dados para preechimento da tabela
    public void setResultados(List<Cliente> lista) {
        dados = lista;
        rsTabela.clear();
        if (lista != null) {
            Iterator<Cliente> it = lista.iterator();
            while (it.hasNext()) {
                Cliente cliente = it.next();
                Object[] linha = {cliente.getCli_id(), cliente.getCli_nome()};
                rsTabela.add(linha);
            }
        }
       if(lista==null || lista.size()==0){
       Object[] linha = {null,""};
       rsTabela.add(linha);
       }
       fireTableStructureChanged();
    }
}




