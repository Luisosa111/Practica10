public class Terricola extends Personaje implements Destruible {
    public Terricola(String nombre, Escenario e, Posicion p) {
        super(nombre, e, p);
    }

    @Override
    public String destruir() {
        return nombre + " ha muerto (Terricola destruido)";
    }

    @Override
    public char getIndicador() {
        return 'T';
    }
}