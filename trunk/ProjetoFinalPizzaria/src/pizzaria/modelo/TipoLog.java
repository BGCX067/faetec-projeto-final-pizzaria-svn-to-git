package pizzaria.modelo;

public class TipoLog {

    private int tplogra_id;
    private String tplogra_descr;

    @Override
    public String toString() {
        return tplogra_descr;
    }

    public int getTplogra_id() {
        return tplogra_id;
    }

    public void setTplogra_id(int tplogra_id) {
        this.tplogra_id = tplogra_id;
    }

    public String getTplogra_descr() {
        return tplogra_descr;
    }

    public void setTplogra_descr(String tplogra_descr) {
        this.tplogra_descr = tplogra_descr;
    }
}