import java.util.Scanner;
import java.util.Locale;
class UsarConta{
	public static void main(String args[]){
		Locale.setDefault(Locale.US);
		// Simulando formulario para entrada dos dados em
		//  	uma interface para o bancario.
		String campo1 = "0455";
		String campo2 = "001";
		String campo3 = "000322906";
		String campo4 = "Victor Israel Anchieta de Medeiros";
		String campo5 = "030.505.390-62";
		short campoAgencia = Short.parseShort(campo1);
		short campoTipoDeConta = Short.parseShort(campo2);
		int campoNumeroConta = Integer.parseInt(campo3);
		String campoNome = campo4;
		String campoCPF = campo5;
		Conta conta1 = new Conta(campoAgencia,campoTipoDeConta,
			campoNumeroConta,campoNome,campoCPF);
		System.out.println(conta1.getSaldo());
	};
}
