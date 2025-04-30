
public class Posicion{
    private int renglon;
    private int columna;
    
    public Posicion(int renglon, int columna){
        this.renglon=renglon;
        this.columna=columna;
    }
    public int getRenglon(){
        return renglon;
    }
    public int getColumna(){
        return columna;
    }
    public double distancia(Posicion otra) {
        int dr = renglon - otra.renglon;
        int dc = columna - otra.columna;
        return Math.sqrt(dr * dr + dc * dc);
    }
    @Override
    public String toString(){
        return "("+ renglon + ","+ columna+ ")";
    
    }
}
