package programa;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Cliente;

public class AppCliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Cliente> listaClientes = new ArrayList<>();

		int m;
		do {

			System.out.println();
			System.out.println("1-Gerar senha\n" + "2-Atendimento\n" + "3-Sair da fila\n"
					+ "4-Mostrar todos os clientes não atendidos\n" + "5-Sair do programa");

			System.out.println("DIGITE:");

			m = sc.nextInt();
			switch (m) {
			case 1:
				GerarSenha(listaClientes);
				break;
			case 2:
				Atendimento(listaClientes);
				break;
			case 3:
				SairDaFila(listaClientes);
				break;
			case 4:
				MostrarTodos(listaClientes);
				break;
			case 5:
				m = 5;
				System.out.println("Finalizado");
				break;
			default:
				System.out.println("error");
			}

		} while (m != 5);

		sc.close();
	}

	public static void GerarSenha(ArrayList<Cliente> listaClientes) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String nome;

		System.out.println("Digite o seu nome:");
		nome = sc.nextLine();

		listaClientes.add(new Cliente(nome));

	}

	public static void Atendimento(ArrayList<Cliente> listaClientes) {
		if (listaClientes.isEmpty()) {
			System.out.println("Não há clientes na fila");
		} else {
			Cliente.proximo();
			Cliente clientePesquisado = pesquisa(listaClientes);

			if (clientePesquisado == null) {
				System.out.println("Não existe esse cliente");
			} else {
				System.out.println(clientePesquisado);
				listaClientes.remove(clientePesquisado);
			}
		}
	}

	public static Cliente pesquisa(ArrayList<Cliente> listaClientes) {

		for (Cliente c : listaClientes) {
			if (c.getSenhaDocliente() == Cliente.getSenhaDeAtendimento()) {
				return c;
			}
		}
		return null;
	}

	public static Cliente pesquisaPorSenha(ArrayList<Cliente> listaClientes) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o seu código para sair da fila:");
		int codigo = sc.nextInt();

		for (Cliente c : listaClientes) {
			if (c.getSenhaDocliente() == codigo) {

				return c;
			}
		}

		return null;
	}

	public static void SairDaFila(ArrayList<Cliente> listaClientes) {
		Cliente senhaSair = pesquisaPorSenha(listaClientes);

		if (senhaSair != null) {
			System.out.println("Senha #" + senhaSair.getSenhaDocliente() + " foi removida.");
			listaClientes.remove(senhaSair);
		} else {
			System.out.println("Não existe essa senha");
		}

	}

	public static void MostrarTodos(ArrayList<Cliente> listaClientes) {
		
		if (listaClientes.isEmpty()) {
			System.out.println("Lista esta vazia.");
		} else {
			for (Cliente c : listaClientes) {

				System.out.println(c);

			}
		}
	}

}
