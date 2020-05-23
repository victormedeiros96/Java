class CPF{
	public static boolean valido(String cpf){
		try{
			cpf = cpf.replaceAll("-","");
			cpf = cpf.replaceAll("\\.","");
			if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") ||
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") ||
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") ||
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") ||
            cpf.equals("99999999999") ||
            (cpf.length()!=11)){
				System.out.println("CPF INVALIDO");
				return false;
			}
			if (validarPrimeiroDigito(cpf)){
				if (validarSegundoDigito(cpf))
					return true;
			}
		}
		catch(Exception ex){
			return false;
		}
		return false;
	}
	private static boolean validarPrimeiroDigito(String cpf){
		double produto = 0;
		for (int i=10;i>1;--i){
			produto += i*(cpf.charAt(10-i)-48);
		}
		produto *= 10;
		double resto  = produto%11.0;
		if (resto==(cpf.charAt(9)-48)){
			return true;
		}
		return false;
	}
	private static boolean validarSegundoDigito(String cpf){
		double produto = 0;
		for (int i=11;i>1;--i){
			produto += i*(cpf.charAt(11-i)-48);
		}
		produto *= 10;
		double resto  = produto%11.0;
		if (resto==(cpf.charAt(10)-48)){
			return true;
		}
		return false;
	}
}


