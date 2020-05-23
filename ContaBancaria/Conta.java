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
