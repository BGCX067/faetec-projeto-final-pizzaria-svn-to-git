package pizzaria.modelo;

public class Telefone {

    private int tel_id;
    private String tel_numero;
    private int cliente;
    private char status;

    public int getTel_id() {
        return tel_id;
    }

    public void setTel_id(int tel_id) {
        this.tel_id = tel_id;
    }

    public String getTel_numero() {
        return tel_numero;
    }

    public void setTel_numero(String tel_numero) {
        this.tel_numero = tel_numero;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Telefone() {
        status = 'N';
    }


    public Telefone(int tel_id, String tel_numero, int cliente, char status) {
        this.tel_id = tel_id;
        this.tel_numero = tel_numero;
        this.cliente = cliente;
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if ((this.tel_numero == null) ? (other.tel_numero != null) : !this.tel_numero.equals(other.tel_numero)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.tel_numero != null ? this.tel_numero.hashCode() : 0);
        return hash;
    }



}
