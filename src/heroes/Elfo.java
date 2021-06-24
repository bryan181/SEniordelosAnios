package src.heroes;
import src.main.*;
import src.ente.*;
import src.bestias.*;

public class Elfo extends Heroe {

    public Elfo(String nombre) {
        super(250, nombre, Dado.dadoParaCreacionPersonaje(50,70));
    }
    
    @Override
    public int getAtaque(Ente ente){
        if (ente instanceof Orco){
            System.out.println(" "+ this.getNombre() + " furia de un ELFO------ ");
            return this.ataque + 10;
        }
        return this.ataque;
    }

    @Override
    public void saludar(){
        System.out.println("Soy un Elfo, mi nombre es: "+this.getNombre());
    }

}
