package src.main;
import src.bestias.*;
import src.heroes.*;
import java.util.*;
import src.ente.*;

public class Juego {
    Scanner scanner=new Scanner(System.in);
    private static Bestia[] bestias;
    private static Heroe[] heroes;
    private static int heroe;
    private static int bestia;

    public Juego(){
        bestias=new Bestia[5];
        heroes=new Heroe[5];
    }

    public void creacionBestias(){
        int aleatorio;
        for(int i=0;i<bestias.length;i++){
            aleatorio=Dado.dadoParaCreacionPersonaje(0,10);
            if(aleatorio>=0 && aleatorio<5){
                bestias[i]= new Orco("ORCO: Sagdat");
            } else {
                bestias[i]= new Trasgo("TRASGO: MUDFACE");
            }
        }
    }

    public void creacionHeroes(){
        int aleatorio;
        for(int i=0;i<heroes.length;i++){
            aleatorio=Dado.dadoParaCreacionPersonaje(0,15);
            if(aleatorio>=0 && aleatorio<5){
                heroes[i]= new Elfo("ELFO: Finrod");
            } else if(aleatorio>=5 && aleatorio<10){
                heroes[i]=new Hobbit("HOBBIT: Frodo");
            } else {  
                heroes[i]=new Humano("HUMANO: Aragorn");
            } 
        }
    }

    public static void saludoHeroes(){
        for(int i = 0; i <heroes.length; i++){
            heroes[i].saludar();
        }
        System.out.println("\n");
    }

    public static void saludoBestias(){
        for(int i = 0; i <bestias.length; i++){
            bestias[i].saludar();
        } 
        System.out.println("\n");
    }

    public void jugar(){
        System.out.println("\n--------SEÑOR DE LOS ANILLOS-----------\n\n");
        creacionHeroes();
        creacionBestias();
        saludoHeroes();
        saludoBestias();
        System.out.println("Número de Héroes: "+Heroe.getHeroesCreados()+"\n");
        System.out.println("\nNúmero de Bestias: "+Bestia.getBestiasCreadas()+"\n");
        pelear(heroes,bestias);
    }

    public void pelear(Heroe[] ejercitoHeroes,Bestia[] ejercitoBestias){
        int avanzar;
        int nTurnos;
        heroe = 5;
        bestia =5;
        System.out.println("\n\tInicia el combate.");

        do{
            nTurnos=0;
            do{     
                if(ejercitoHeroes[nTurnos] != null && ejercitoBestias[nTurnos] != null){
                    System.out.print("\nPresione cualquier número para avanzar al combate: ");
                    avanzar = scanner.nextInt();
                    ejercitoBestias[nTurnos].recibirAtaque(ejercitoHeroes[nTurnos]);
                    if(ejercitoBestias[nTurnos].getVida() > 0){
                        ejercitoHeroes[nTurnos].recibirAtaque(ejercitoBestias[nTurnos]);

                        if(ejercitoHeroes[nTurnos].getVida() <= 0){
                            eliminarJugador(heroes, nTurnos);
                        }
                    } 
                    else {
                        eliminarJugador(bestias, nTurnos);
                    }
                }
                nTurnos++;
            } while(nTurnos<ejercitoHeroes.length);
        } while(heroe > 0 && bestia > 0);
        if(heroe > 0){
           System.out.println("Ejercito de Bestias aniquilado. Ganan los Heroes.");
        } else {
            System.out.println("Ejercito de Heroes aniquilado. Ganan las bestias.");
        }
        System.out.println("---------------Fin---------------");
    }

   
    public static void eliminarJugador(Ente ejercito[], int n){
        if( ejercito[0] instanceof Heroe){
            for(int i = n; i < heroe-1; i++){
                ejercito[i] = ejercito[i+1];
            }
            heroe--;
            ejercito[heroe] = null;
        } 
        else if (ejercito[0] instanceof Bestia){
            for(int i = n; i < bestia-1; i++){
                ejercito[i] = ejercito[i+1];
            }
            bestia--;
            ejercito[bestia] = null;
        }
    }
}
