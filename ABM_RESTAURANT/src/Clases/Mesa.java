package Clases;

public class Mesa {
    private Integer numMesa;
    private Integer paraCuantos;
    private Situacion situacion;
    private boolean ocupada;

    // region CONST
    public Mesa() {
    }

    public Mesa(Integer numMesa, Integer paraCuantos, Situacion situacion, boolean ocupada) {
        this.numMesa = numMesa;
        this.paraCuantos = paraCuantos;
        this.situacion = situacion;
        this.ocupada = ocupada;
    }

    // endregion
    // region GYS
    public Integer getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }

    public Integer getParaCuantos() {
        return paraCuantos;
    }

    public void setParaCuantos(Integer paraCuantos) {
        this.paraCuantos = paraCuantos;
    }

    public Situacion getSituacion() {
        return situacion;
    }

    public void setSituacion(Situacion situacion) {
        this.situacion = situacion;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    // endregion

    @Override
    public String toString() {
        return "Mesa{" +
                "numMesa=" + numMesa +
                ", paraCuantos=" + paraCuantos +
                ", situacion=" + situacion +
                ", ocupada=" + ocupada +
                '}';
    }
}
