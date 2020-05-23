import java.util.Scanner;
import java.util.Locale;
class DistanciaEntrePontos{
	public static void main(String args[]){
		Locale.setDefault(Locale.US);
		int[] ponto1 = {0,0,0};
		int[] ponto2 = {2,3,4};
		double distancia=0;
		for (int i=0;i<3;i++){
			distancia += Math.pow((ponto1[i]-ponto2[i]),2);
		}
		distancia = Math.sqrt(distancia);
		System.out.println("Distancia entre os pontos: "+distancia);
	};
}
