package src.ente;
import src.heroes.*;
import src.bestias.*;

public class Ente {
    
    private int vida;
    private String nombre;
    private int resistenciaArmadura;
    private int limiteSuperiorAtaque;
    public int ataque;
    private String[] figuraBestia;
    private String[] figuraMuerto;
    private String[] figuraHeroe;

    public Ente(int vida, String nombre, int resistenciaArmadura,int ataqueMaximo) {
        this.vida = vida;
        this.nombre = nombre;
        this.resistenciaArmadura = resistenciaArmadura;
        this.limiteSuperiorAtaque=ataqueMaximo;
       
    }

    

    public int getVida() {
        return vida;
    }


    public String getNombre() {
        return nombre;
    }

    public int getResistenciaArmadura() {
        return resistenciaArmadura;
    }

    public int getLimiteSuperiorAtaque() {
        return limiteSuperiorAtaque;
    }    

    public int getAtaque(Ente defensor) {
        return this.ataque;
    }

    public int modificacionAtaque(Ente ente){
        return ente.ataque;
    }
    
    public void disminuirVida(double ataque){
        this.vida -= ataque;
    }


    public void recibirAtaque(Ente atacante){
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("\nTurno de Ataque: "+atacante.getNombre()+". Vida: "+atacante.getVida()+" contra: "+this.nombre+" Vida "+this.vida+".");
        
        if(atacante instanceof Heroe){
            ((Heroe)atacante).setAtaque();
        } 
        else if (atacante instanceof Bestia){
            ((Bestia)atacante).setAtaque();
        }

        int ataque = atacante.getAtaque(this);
        System.out.println("Ataque: "+ataque+"\nDefensa: "+this.resistenciaArmadura);

        if(atacante instanceof Orco){
            System.out.println("- Fuerza desmesurada de orco, armadura enemiga dañada en 10 unidades");
            if(ataque > (this.resistenciaArmadura-10)){
                ataque -= (this.resistenciaArmadura-10);
                this.disminuirVida(ataque); 
            }
            else {
                System.out.println("!!!!!!!!!!!Ataque fallido!!!!!!!!!");
            }
        } 
        else {
            if(ataque > this.resistenciaArmadura){
                ataque -= this.resistenciaArmadura;
                this.disminuirVida(ataque);
            }
            else {
                System.out.println("!!!!!!!!!Ataque fallido!!!!!!!");
            }
        }
        System.out.println("\nFin del ataque entre: "+atacante.getNombre()+" Vida: "+atacante.getVida()+" y "+this.nombre+" Vida "+this.vida+".");
    }
}
