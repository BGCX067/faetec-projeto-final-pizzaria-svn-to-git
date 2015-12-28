package pizzaria.modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TabelaPizza extends AbstractTableModel {
    //Aqui declare os vetores que preencheram a tabela

    private Integer[] vnTamanho = {40,250,100,80,60}; // Definirá a largura das colunas
    private String[] vsTitulos = {"ID","Descrição","Sabor","Tamanho","Preço"}; // Definirá os títulos das colunas
    private Class[] vsClasses = {Integer.class, String.class,String.class,String.class,String.class}; // Classe dos valores
    private List<Pizza> dados = null; // Lista contendo os dados a serem exibidos
    // Lista de objetos genéricos que compõem a tabela
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    //Método Construtor
    public TabelaPizza() {
        Object[] linha = {null,"","","",""};
        rsTabela.add(linha);
    }

    //Método utilizado para modificar a lista de dados da tabela
    public TabelaPizza(List<Pizza> lista) {
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

    public void adicionarLinha(Pizza pizza) {
        Object[] linha = {pizza.getPiz_id(),pizza.getPiz_desc(),pizza.getPiz_sabor(),pizza.getPiz_tam(),pizza.getPiz_preco()};
        rsTabela.add(linha);
        fireTableStructureChanged(); // Notifica a mudança de dados da Tabela
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dados.remove(linha);
        fireTableStructureChanged();
    }

    // Retorna o objeto Pessoa da linha selecionada
    public Pizza getPizza(int linha) {
        try {
            Pizza pizza = null;
            if (dados != null && dados.size() > 0) {
                pizza = dados.get(linha);
            }
            return pizza;
        } catch (Exception e) {
            return null;
        }
    }

    // Define o conteúdo dos dados para preechimento da tabela
    public void setResultados(List<Pizza> lista) {
        dados = lista;
        rsTabela.clear();
        if (lista != null) {
            Iterator<Pizza> it = lista.iterator();
            while (it.hasNext()) {
                Pizza pizza = it.next();
                Object[] linha = {pizza.getPiz_id(),pizza.getPiz_desc(),pizza.getPiz_sabor(),pizza.getPiz_tam(),pizza.getPiz_preco()};
                rsTabela.add(linha);
            }
        }
       if(lista==null || lista.size()==0){
       Object[] linha = {null,"","","",""};
       rsTabela.add(linha);
       }
       fireTableStructureChanged();
    }
}




