package src.bestias;
import src.main.*;

public class Trasgo extends Bestia{

    public Trasgo(String nombre) {
        super(325, nombre,Dado.dadoParaCreacionPersonaje(50,70));
    }
    
    @Override
    public void saludar(){
        System.out.println("Soy un Trasgo, mi nombre es: "+this.getNombre());
    }
    
}
