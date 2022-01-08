import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Cliente maria = new Cliente();
		maria.setNome("Maria");
		
		Cliente joao = new Cliente();
		joao.setNome("João");

		Conta ccMaria = new ContaCorrente(maria);
		Conta poupancaJoao = new ContaPoupanca(joao);
		
		ccMaria.imprimirExtrato();
		ccMaria.depositar(100);
		ccMaria.imprimirExtrato();
		ccMaria.transferir(100, poupancaJoao);		
		ccMaria.imprimirExtrato();
		
		poupancaJoao.imprimirExtrato();
		
		List<Conta> contas = new ArrayList<>();
		contas.add(ccMaria);
		contas.add(poupancaJoao);
		
		Banco b = new Banco();
		b.setNome("Sicredi");
		b.setContas(contas);		
		b.listarContas();
		
		
	    /*			
		 status = ativo e inativo
		 lista de clientes 
		 fazer os controles de transferencia e saque
		*/
	}

}
