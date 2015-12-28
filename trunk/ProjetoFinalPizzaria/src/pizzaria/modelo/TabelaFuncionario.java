/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TabelaFuncionario extends AbstractTableModel {

    // Aqui declare os vetores que preencheram a tabela.
    private final Integer[] vnTamanho = {100, 100, 100}; // Definirá a largura das colunas.
    private final String[] vsTitulo = {"Matricula", "Nome", "Telefone"}; // Definirá os títulos das colunas.
    private List<Funcionario> dados = null; // Lista contendo o dados a serem exibidos.
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public TabelaFuncionario() {
        Object[] linha = {null, null, null};
        rsTabela.add(linha);
    }

    public TabelaFuncionario(List<Funcionario> lista) {
        setResultados(lista);
    }

    public final void setResultados(List<Funcionario> lista) {
        dados = lista;
        rsTabela.clear(); // Remover Dados Anteriores.

        if (lista != null) {
            Iterator<Funcionario> it = lista.iterator();
            while (it.hasNext()) {
                Funcionario funcionario = it.next();
                adicionarLinha(funcionario);
            }
        }

        if (lista == null || lista.isEmpty()) { // Lista igual à nulo ou lista com o tamanho igual à zero (vazia).
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }

        fireTableStructureChanged();
    }

    public void adicionarLinha(Funcionario func) {
        Object[] linha = {func.getFun_mat(), func.getFun_nome(), func.getFun_tel()};
        rsTabela.add(linha);
    }

    public Funcionario getFuncionario(int linha) {
        Funcionario ent = null;
        if (dados != null && dados.size() > linha) {
            ent = dados.get(linha);
        }
        return ent;
    }

    @Override
    public int getRowCount() {
        return rsTabela.size();
    }

    @Override
    public int getColumnCount() {
        return vsTitulo.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rsTabela.get(rowIndex) [columnIndex];
    }
    
    public String getColumnName(int columnIndex) {
        return vsTitulo[columnIndex];
    }
    
    public int getColumnSize(int columnIndex) {
        return vnTamanho[columnIndex];
    }
}
