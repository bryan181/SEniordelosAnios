package src.heroes;
import src.bestias.Orco;
import src.ente.*;
import src.main.Dado;

public class Humano extends Heroe {

    public Humano(String nombre) {
        super(180, nombre,Dado.dadoParaCreacionPersonaje(50, 70));
    }
    
    @Override
    public void saludar(){
        System.out.println("Soy Humano, Mi nombre es: "+this.getNombre());
    }

    @Override
    public int getAtaque(Ente ente){
        if (ente instanceof Orco){
            System.out.println(" "+ this.getNombre() + " fuiste atacado por un Orco, armadura disminuida------ ");
            return this.getResistenciaArmadura() -10;
        }
        return this.getResistenciaArmadura();
    }
}
