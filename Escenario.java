import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Escenario {
    private String nombre;
    private final int N = 10;
    private int n;
    private List<Elemento> elementos=new ArrayList<>();
    
    public Escenario(String nombre,int n) {
        this.nombre = nombre;
        this.elementos = new ArrayList<>();
        this.n=n;
    }

    public void addElemento(Elemento e) {
        elementos.add(e);
    }
    
   public List<Elemento> getElementos(){
       
       return elementos;
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
