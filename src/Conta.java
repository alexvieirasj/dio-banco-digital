//@Getter
//@Setter
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	//Tem relação com a classe Conta, como se fosse uma primary key
		
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected char status;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.status = 'A';
	}
	
	@Override
	public void sacar(double valor) {
		if(valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saque não realizado. Você possui R$ " + this.saldo + " em conta. Digite outro valor!");
		}		
	}

	@Override
	public void depositar(double valor) {
		if(valor > 0) {
			saldo += valor;
		} else {
			System.out.println("Deposito não realizado. O valor R$ " + valor + " não é válido. Digite outro valor!");
		}		
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(valor <= saldo) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.out.println("Transfêrencia não realizada. Você não possui R$ " + valor + " em conta.");
		}
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getNomeStatus() {
		return status == 'A' ? "Ativo" : "Inativo";
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Situacao: %s", getNomeStatus()));
	}
}
