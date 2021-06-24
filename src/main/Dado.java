package src.main;

public class Dado {
    
    public Dado(){

    }

    public static int tirarDado(int valorMinimo, int valorMaximo, int cantidadDados){
        int resultado=0;
        int dado;
        for (int i=0;i<cantidadDados;i++) {
            dado =(int)((Math.random()*(valorMaximo-valorMinimo))+valorMinimo);
            System.out.println("Dado: "+i+", resultado: "+ dado);
            if (resultado < dado)
                resultado = dado;
        }
        if(resultado<=1){
            System.out.println("\nEl resultado del dado lanzado es: "+ resultado);
        } else if (cantidadDados > 1){
            System.out.println("El resultado mayor de los "+cantidadDados + " Dados lanzados es: "+resultado);
        }

        return resultado;
    }

    public static int dadoParaCreacionPersonaje(int valorMinimo,int valorMaximo){
        int dado=0;
        for(int i=0;i<1;i++){
            dado=(int)((Math.random()*(valorMaximo-valorMinimo))+valorMinimo);
        }
        return dado;
    }
    
}
