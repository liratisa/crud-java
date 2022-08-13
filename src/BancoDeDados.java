import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

// só é executada quando invocada por outro programa
public class BancoDeDados {
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultSet = null;
	// passagem de parâmetros para a conexão do bd
	public void conectar() {
		// criando a variável de conexão do db
		String servidor = "jdbc:mysql://localhost/ibm";
		//usuário do db
		String usuario = "root";
		//senha
		String senha = "mysql";
		// vinculando o driver de conexão
		String driver = "com.mysql.cj.jdbc.Driver";
		// try catch para tratamento do db
		try {
			//se conecta ao driver e passa os tres params
			Class.forName(driver);
			this.connection=DriverManager.getConnection(servidor, usuario, senha);
			// estado do db - ativo ou inativo
			this.statement=this.connection.createStatement();
		} catch(Exception e) {
			System.out.println("erro:" + e.getMessage());
		}
	}
	
		// método de retorno da conexão
		public boolean estaConectado() {
			if(this.connection != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// criando um método para visualizar os registros do bd
		
		public void listaContatos() {
			// criando o processo de tratamento dos comandos no bd
			try {
				// criando uma variável para a sintaxe em sql
				// get dos produtos
				String query = "select * from produtos";
				this.resultSet = this.statement.executeQuery(query);
				// retorna o estado do bd
				this.statement = this.connection.createStatement();
				// laço de repetição para retornar os registros
				while(this.resultSet.next()) {
					// criando as variáveis para receber os registros do bd
					String idProduto = resultSet.getString("id_produto");
					String nomeProduto = resultSet.getString("nome_produto");
					String valorUnitario = resultSet.getString("valor_unitario");
					String categoriaProduto = resultSet.getString("categoria_produto");
					String codMarca = resultSet.getString("cod_marca");				
					System.out.println("id do produto: " + idProduto);
					System.out.println("nome do produto: " + nomeProduto);
					System.out.println("valor do produto: R$ " + valorUnitario);
					System.out.println("categoria do produto: " + categoriaProduto);
					System.out.println("código da marca: " + codMarca + "\n");
					
				}
				 
				
			} catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		
		// post 
		public void adicionaContatos(String nome, double valor, String categoria, int codigo) {
			try {
				String query = "insert into produtos values(null, '"+nome+"', '"+valor+"', '"+categoria+"', '"+codigo+"')";
				this.statement.execute(query);
				System.out.println("Produto cadastrado com sucesso!");
			} catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		
		// update
		public void editarContatos(double valor) {
			try {
				String query = "update produtos set valor_unitario = '"+valor+"' where valor_unitario = 15.30";
				this.statement.execute(query);
			} catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
			
		}
		
		// delete
		public void deletarContatos(int id) {
			try {
				String query = "delete from produtos where id_produto='"+id+"'";
				this.statement.execute(query);
				System.out.println("Produto excluído com sucesso");
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
			
		}
		
}
