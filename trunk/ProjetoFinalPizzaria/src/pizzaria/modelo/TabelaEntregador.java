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
public class TabelaEntregador extends AbstractTableModel {

    // Aqui declare os vetores que preencheram a tabela.
    private final Integer[] vnTamanho = {100, 100}; // Definirá a largura das colunas.
    private final String[] vsTitulo = {"Nome", "Telefone"}; // Definirá os títulos das colunas.
    private List<Entregador> dados = null; // Lista contendo o dados a serem exibidos.
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public TabelaEntregador() {
        Object[] linha = {null, null};
        rsTabela.add(linha);
    }

    public TabelaEntregador(List<Entregador> lista) {
        setResultados(lista);
    }

    public final void setResultados(List<Entregador> lista) {
        dados = lista;
        rsTabela.clear(); // Remover Dados Anteriores.

        if (lista != null) {
            Iterator<Entregador> it = lista.iterator();
            while (it.hasNext()) {
                Entregador entregador = it.next();
                adicionarLinha(entregador);
            }
        }

        if (lista == null || lista.isEmpty()) { // Lista igual à nulo ou lista com o tamanho igual à zero (vazia).
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }

        fireTableStructureChanged();
    }

    public void adicionarLinha(Entregador ent) {
        Object[] linha = {ent.getNome(), ent.getTelefone()};
        rsTabela.add(linha);
    }

    public Entregador getEntregador(int linha) {
        Entregador ent = null;
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
