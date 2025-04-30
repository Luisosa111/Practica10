import java.util.ArrayList;
import java.util.Iterator;

import java.util.ArrayList;

public class Escenario {
    private String nombre;
    private ArrayList<Elemento> elementos;
    private final int N = 10;

    public Escenario(String nombre) {
        this.nombre = nombre;
        elementos = new ArrayList<>();
    }

    public void addElemento(Elemento e) {
        elementos.add(e);
    }

    public void destruirElementos(Posicion centro, int radio) {
    ArrayList<Elemento> destruidos = new ArrayList<>();

    for (Elemento e : elementos) {
        int dx = Math.abs(e.getPosicion().getRenglon() - centro.getRenglon());
        int dy = Math.abs(e.getPosicion().getColumna() - centro.getColumna());

        if (dx <= radio && dy <= radio) {
            if (e instanceof Destruible) {
                Destruible d = (Destruible) e;
                System.out.println(d.destruir());
                destruidos.add(e);
            }
        }
    }

   
    elementos.removeAll(destruidos);
}

    @Override
    public String toString() {
        char[][] matriz = new char[N][N];

        // Inicializa la matriz con '0'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = '0';
            }
        }

    
        for (Elemento e : elementos) {
            int r = e.getPosicion().getRenglon();
            int c = e.getPosicion().getColumna();
            if (r >= 0 && r < N && c >= 0 && c < N) {
                matriz[r][c] = e.getIndicador();
            }
        }

    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matriz[i][j]).append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
