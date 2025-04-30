public class Extraterrestre extends Personaje implements Destruible {
    public Extraterrestre(String nombre, Escenario e, Posicion p) {
        super(nombre, e, p);
    }

    @Override
    public String destruir() {
        return nombre + " Alien destruido)";
    }

    @Override
    public char getIndicador() {
        return 'E';
    }
}