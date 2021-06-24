package src.bestias;
import src.main.*;

public class Orco extends Bestia {
    
    public Orco(String nombre) {
        super(300, nombre, Dado.dadoParaCreacionPersonaje(50,70));
    }
    
    @Override
    public void saludar(){
        System.out.println("Soy un Orco, mi nombre es: "+this.getNombre());
    }
}
