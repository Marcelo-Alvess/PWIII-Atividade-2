import java.util.Date;

public class ClienteTeste {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		Date nascimentoTeste = DateTimeUtils.toDate(23, 01, 2001);
		
		cliente.nome = "MARCELO";
		cliente.nascimento = nascimentoTeste;
		cliente.cpf ="38933673814";
	
		System.out.println(cliente.toString());
	}
}
