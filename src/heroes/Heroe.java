package src.heroes;
import src.ente.Ente;
import src.main.Dado;

public class Heroe extends Ente {

    private static int ataqueMaximo=100;
    private static int heroesCreados=0;

    public Heroe(int vida, String nombre, int resistenciaArmadura) {
        super(vida, nombre, resistenciaArmadura,ataqueMaximo);
        heroesCreados++;    
    }

    public static int getHeroesCreados(){
        return heroesCreados;   
    }

    public int setAtaque(){
        return ataque=Dado.tirarDado(0,ataqueMaximo,2);
    }

    public void saludar(){
        System.out.println("Soy un Heroe, mi nombre es: "+this.getNombre());
    }

    
}
