package Clases;

public class Mesa {
    private Integer numMesa;
    private Integer paraCuantos;
    private Situacion situacion;

    // region CONST
    public Mesa() {
    }

    public Mesa(Integer numMesa, Integer paraCuantos, Situacion situacion) {
        this.numMesa = numMesa;
        this.paraCuantos = paraCuantos;
        this.situacion = situacion;
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



    @Override
    public String toString() {
        return "Mesa{" +
                "numMesa=" + numMesa +
                ", paraCuantos=" + paraCuantos +
                ", situacion=" + situacion +
                '}';
    }
}
