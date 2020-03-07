import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Cliente {

	
	public String nome;
	public String email;
	public String telefone;
	public Date   nascimento;
	public String cpf;
	
    public String toString() {
    	return String.format("Nome: %s \nMaior de idade: %s \ndata de nascimento: %s \nCPF: %s", nome, ehMaiorIdade(), nascimento, ehCPFValido());
    }
	
	public boolean ehCPFValido() {

		int     d1, d2;
	    int     digito1, digito2, resto;
	    int     digitoCPF;
	    String  nDigResult;

	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;
	
	    for (int contador = 1; contador < cpf.length() -1; contador++) {
	         digitoCPF = Integer.valueOf (cpf.substring(contador -1, contador)).intValue();
	
	         d1 = d1 + ( 11 - contador ) * digitoCPF;
	
	         d2 = d2 + ( 12 - contador ) * digitoCPF;
	    };
	
        resto = (d1 % 11);

        if (resto < 2) {
          digito1 = 0;
        }
        else {
          digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        resto = (d2 % 11);

        if (resto < 2) {
          digito2 = 0;
        }
        else {
          digito2 = 11 - resto;
        }

        String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());

        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        return nDigVerific.equals(nDigResult);
    }
	
	public boolean ehMaiorIdade() {
		LocalDate dtNascimento = nascimento.toInstant()
				   						   .atZone(ZoneId.systemDefault())
				   						   .toLocalDate();
		
		if (LocalDate.now().until(dtNascimento, ChronoUnit.YEARS) * -1 >=  18) {
			return true;
		} else {
			return false;
		}
		
		
		
	}
}
