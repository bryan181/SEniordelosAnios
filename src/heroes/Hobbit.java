package src.heroes;
import src.main.*;
import src.bestias.*;
import src.ente.*;

public class Hobbit extends Heroe {

    public Hobbit(String nombre) {
        super(200, nombre, Dado.dadoParaCreacionPersonaje(50,70));
    }
    
    @Override
    public void saludar(){
        System.out.println("Soy un Hobbit, mi nombre es: "+this.getNombre());
    }

    @Override
    public int getAtaque(Ente ente){
        if (ente instanceof Trasgo){
            System.out.println(" "+ this.getNombre() + " Disminucion de ataque------ ");
            return this.ataque -5;

        }
        if(ente instanceof Orco){
            System.out.println(" "+ this.getNombre() + " Has sido atacado por un orco, armadura afectada------ ");
            return this.getResistenciaArmadura() -10;
        }
        return this.ataque;
    }
}
