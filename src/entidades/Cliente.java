package entidades;

public class Cliente {
	//commit final
	private static int senhaDeAtendimento = 0;
	private static int geradorDeSenha = 1;
	
	private int senhaDocliente;
	private String nome;
	
	public Cliente(String nome) {	
		senhaDocliente = geradorDeSenha;
		this.nome = nome;
		geradorDeSenha++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getSenhaDeAtendimento() {
		return senhaDeAtendimento;
	}

	public int getSenhaDocliente() {
		return senhaDocliente;
	}

	public static int proximo() {
		senhaDeAtendimento++;
		return senhaDeAtendimento;
	}
	
	@Override
	public String toString() {
		return "Senha: "+ getSenhaDocliente() + "\nCliente: " + getNome()+"\n";
	}
	
	
}
