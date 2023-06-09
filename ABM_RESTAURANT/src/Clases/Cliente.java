package Clases;
import java.util.Random;
import java.util.Scanner;
public class Cliente extends Usuario{
    //---------------
    //region Atributos
    private Reserva reserva;
    //endregion
    //---------------
    ///region Constructores
    public Cliente() {
    }
    public Cliente(String id, String nombre, String apellido, String contrasenia, boolean esAdmin, Reserva reserva) {
        super(id, nombre, apellido, contrasenia, esAdmin);
        this.reserva = reserva;
    }
    //endregion
    //---------------
    //region Getters
    public Reserva getReserva() {
            return reserva;
        }
    //endregion
    //---------------
    //region Setters
    public void setReserva(Reserva reserva) {
            this.reserva = reserva;
        }
    //endregion
    //---------------
    //region ToString
    @Override
    public String toString() {
        return "Cliente{" +
                "reserva=" + reserva +
                "} " + super.toString();
    }
    public void verCliente(Usuario usuario){
        System.out.println("Id: "+usuario.getIdUsuario());
        System.out.println("Nombre/s: "+usuario.getNombre());
        System.out.println("Apellido/s: "+usuario.getApellido());
    }
    //endregion
    //---------------
    //region Metodos
        public String generarIdRandomString(int cant){
            Random rand = new Random();
            int numeroRandom=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<cant; i++){
                numeroRandom=rand.nextInt(10);
                sb.append(String.valueOf(numeroRandom));
            }
            return sb.toString();
        }
        public Cliente datosManual(){
            Scanner scan = new Scanner(System.in);
            Cliente c = new Cliente();

            System.out.printf("Ingrese Nombre/es: ");
            c.setNombre(scan.nextLine());

            System.out.printf("Ingrese Apellido/s: ");
            c.setApellido(scan.nextLine());

            System.out.printf("Ingrese Contrasenia: ");
            c.setContrasenia(scan.nextLine());

            String adminOClient="x";
            boolean flag=false;
            do{
                System.out.printf("¿Es Administrador? S/N");
                adminOClient=scan.nextLine();
                if(adminOClient=="s" || adminOClient=="S" || adminOClient=="n" || adminOClient=="N"){
                    flag=true;
                }
            }while(flag == true);

            if(adminOClient=="s" || adminOClient!="S"){
                c.setEsAdmin(true);
            }else{
                c.setEsAdmin(false);
            }
            c.setIdUsuario(generarIdRandomString(10));
            return c;
        }
    //endregion
    //---------------
}
