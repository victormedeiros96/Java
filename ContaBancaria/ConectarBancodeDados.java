import java.util.Locale;
import java.sql.*;
import java.util.Locale;
import java.sql.*;
class Conta{
	 private double saldo=0;
	 private short numeroAgencia=0;
	 private short tipoDeConta = 0;
	 private int numeroConta=0;
	 private String titular;
	 private String cpf;
	public Conta(short agencia,short tipoDeConta,int numeroConta,String titular,String cpf){
		this.cpf = cpf;
		if (CPF.valido(cpf)){
			this.numeroAgencia = agencia;
			this.tipoDeConta = tipoDeConta;
			this.numeroConta = numeroConta;
			this.titular = titular;
			System.out.println("Conta criada com sucesso.");
		}
		else{
			System.out.println("Erro ao criar a conta, CPF invalido.");
		}
	}
	public double getSaldo(){
		return this.saldo;
	}
	public int getNumeroConta(){
		return this.numeroConta;
	}
	public short getNumeroAgencia(){
		return this.numeroAgencia;
	}
	public String getTitular(){
		return this.titular;
	}
	public short getTipoDeConta(){
		return this.tipoDeConta;
	}
	public String getCPF(){
		return this.cpf;
	}

	//public void setNumeroConta(int numero){
		//this.numeroConta = numero;
	//}
	public boolean transferirAgencia(short agencia){
		try{
			this.numeroAgencia = agencia;
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	public boolean depositar(short agencia,short tipoDeConta,int conta,String cpf){
		if (CPF.valido(cpf)){
			//Pesquisar conta no banco de dados;
			return true;
		}
		else{
			return false;
			// CPF invalido. Retorna deposito nao realizado.
		}
	}
}
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
class ConectarBancodeDados{
	 public static void connect(Conta conta) {
        String sql = "INSERT INTO Clientes(Titular,CPF,NumeroAgencia,TipoDeConta,NumeroConta,Saldo) VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:ClientesDoBanco.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, conta.getTitular());
            pstmt.setString(2,conta.getCPF());
            pstmt.setInt(3,conta.getNumeroAgencia());
            pstmt.setInt(4,conta.getTipoDeConta());
            pstmt.setInt(5,conta.getNumeroConta());
            pstmt.setDouble(6,conta.getSaldo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
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
		Conta conta1 = new Conta(campoAgencia,campoTipoDeConta,campoNumeroConta,campoNome,campoCPF);
        connect(conta1);
    }
}
