// public static void main - quando há interação
public class Agenda {

	public static void main(String[] args) {
		// chamando a classe do banco de dados e os métodos
		BancoDeDados sintaxeBanco = new BancoDeDados();
		sintaxeBanco.conectar();
		
		// if para verificar se o banco ou n está conectado
		if(sintaxeBanco.estaConectado()) {
			sintaxeBanco.adicionaContatos("Hidroxicloroquina", 27.55, "Medicamentos", 10);
			sintaxeBanco.editarContatos(18.70);
			sintaxeBanco.listaContatos();
			sintaxeBanco.deletarContatos(14);
			System.out.println("Conexão com o db foi estabelecida!");
		} else {
			System.out.println("Não foi possível conectar-se ao db");
		}

	}

}
