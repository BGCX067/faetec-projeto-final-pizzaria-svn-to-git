package pizzaria.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaItemPedido extends AbstractTableModel {

    private Integer[] vnTamanho = {70, 100, 80, 110, 100}; // Definirá a largura das colunas
    private String[] vsTitulos = {"ID", "Descrição", "Quantidade", "Valor Unitário (R$)", "Valor Total (R$)"}; // Definirá os títulos das colunas
    private Class[] vsClasses = {Object.class, String.class, Object.class, Double.class, Double.class}; // Classe dos valores
    private List<ItemPedido> dados = null; // Lista contendo os dados a serem exibidos
    // Lista de objetos genéricos que compõem a tabela
    private List<Object[]> rsTabela = new ArrayList<Object[]>();
    private double total = 0;

    //Método Construtor
    public TabelaItemPedido() {
        Object[] linha = {null, null, null, null, null};
        rsTabela.add(linha);
    }

    //Método utilizado para modificar a lista de dados da tabela
    public TabelaItemPedido(List<ItemPedido> lista) {
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

    public void adicionarLinha(ItemPedido itemPed) {
        if (itemPed.getOperacao() == 'P') {
            Object[] linha = {itemPed.getPizza().getPiz_id(), itemPed.getPizza().getPiz_desc(), itemPed.getQuantidade(), itemPed.getPizza().getPiz_preco(), itemPed.getValor_total()};
            rsTabela.add(linha);
            total += itemPed.getValor_total();
        } else if (itemPed.getOperacao() == 'B') {
            Object[] linha = {itemPed.getBebida().getBeb_id(), itemPed.getBebida().getBeb_desc(), itemPed.getQuantidade(), itemPed.getBebida().getBeb_preco(), itemPed.getValor_total()};
            rsTabela.add(linha);
            total += itemPed.getValor_total();
        }
        dados.add(itemPed);
        fireTableStructureChanged(); // Notifica a mudança de dados da Tabela
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        total -= dados.get(linha).getValor_total();
        if (dados.get(linha).getOperacao() == 'A') {
            dados.remove(linha);
        } else {
            dados.get(linha).setOperacao(' ');
        }
        fireTableStructureChanged();
    }

    // Retorna o objeto Cidade da linha selecionada
    public ItemPedido getItemPedido(int linha) {
        try {
            ItemPedido itemPed = null;
            if (dados != null && dados.size() > 0) {
                itemPed = dados.get(linha);
            }
            return itemPed;
        } catch (Exception e) {
            return null;
        }
    }

    // Define o conteúdo dos dados para preechimento da tabela
    public void setResultados(List<ItemPedido> lista) {
        dados = lista;
        rsTabela.clear();
        total = 0;
        if (lista != null) {
            Iterator<ItemPedido> it = lista.iterator();
            while (it.hasNext()) {
                ItemPedido itemPed = it.next();
                if (itemPed.getOperacao() == 'P'||itemPed.getPizza() != null) {
                    total += itemPed.getValor_total();
                    Object[] linha = {itemPed.getPizza().getPiz_id(), itemPed.getPizza().getPiz_sabor(), itemPed.getQuantidade(), itemPed.getPizza().getPiz_preco(), itemPed.getValor_total()};
                    rsTabela.add(linha);
                } else if (itemPed.getOperacao() == 'B'||itemPed.getBebida() != null) {
                    total += itemPed.getValor_total();
                    Object[] linha = {itemPed.getBebida().getBeb_id(), itemPed.getBebida().getBeb_desc(), itemPed.getQuantidade(), itemPed.getBebida().getBeb_preco(), itemPed.getValor_total()};
                    rsTabela.add(linha);
                }
            }
        }
        if (lista == null || lista.size() == 0) {
            Object[] linha = {null, null, null, null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }

    public double getTotal() {
        return total;
    }

}
