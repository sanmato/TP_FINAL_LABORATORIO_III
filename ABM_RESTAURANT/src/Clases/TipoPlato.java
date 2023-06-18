package Clases;

public enum TipoPlato {
    ENTRADA("ENTRADA"), PRINCIPAL("PRINCIPAL"), POSTRE("POSTRE");

    private String tipoDePlato;

    TipoPlato(String tipoDePlato) {
        this.tipoDePlato = tipoDePlato;
    }

    public String tipoDePlato() {
        return tipoDePlato;
    }
}
