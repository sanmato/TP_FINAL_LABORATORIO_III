public enum Situacion {
    LIBRE("LIBRE"), OCUPADA ("OCUPADA"), RESERVADA ("RESERVADA");
    private String mesaSit;

    Situacion(String mesaSit){
        this.mesaSit=mesaSit;
    }

    public String mesaSituacion(){
        return mesaSit;
    }
}
