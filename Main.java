public class pantalla{
    public static void main(String[] args) {
        Escenarios escenario = new Escenarios(5);
        escenario.colocarIndicador(0, 0, 'O'); 
        escenario.colocarIndicador(2, 2, 'X'); 

        System.out.println(escenario.toString());
    }
}
