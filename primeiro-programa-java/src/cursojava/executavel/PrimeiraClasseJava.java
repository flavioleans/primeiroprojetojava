package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		// LISTA DE ALUNOS PRINCIPAL
		List<Aluno> alunos = new ArrayList<Aluno>();

		// HASHMAP -> COMTEM UMA LISTA COM CHAVE E VALOR (PODE PASSAR UMA LISTA COMO
		// VALOR)
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

		// CRIANDO UMA LISTA PARA CADA STATUS DO ALUNO (NÃO PRECISA QUANDO USA HASHMAP
		/*
		 * List<Aluno> alunosAprovados = new ArrayList<Aluno>(); List<Aluno>
		 * alunosRecuperacao = new ArrayList<Aluno>(); List<Aluno> alunosReprovados =
		 * new ArrayList<Aluno>();
		 */

		for (int qtd = 1; qtd <= 3; qtd++) {

			String nome = JOptionPane.showInputDialog(null, "Digite o seu nome " + qtd + ": ");
			/*
			 * String idade = JOptionPane.showInputDialog(null, "Digite sua idade: ");
			 * String dataNascimento = JOptionPane.showInputDialog(null,
			 * "Data de nascimento: "); String registroGeral =
			 * JOptionPane.showInputDialog(null, "Identidade: "); String numeroCpf =
			 * JOptionPane.showInputDialog(null, "CPF: "); String nomeMae =
			 * JOptionPane.showInputDialog(null, "Nome da Mãe: "); String nomePai =
			 * JOptionPane.showInputDialog(null, "Nome do pai: "); String dataMatricula =
			 * JOptionPane.showInputDialog(null, "Data da matricula: "); String nomeEscola =
			 * JOptionPane.showInputDialog(null, "Nome da Escola: "); String
			 * serieMatriculado = JOptionPane.showInputDialog(null, "Série: ");
			 */

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
			/*
			 * aluno1.setIdade(Integer.valueOf(idade));
			 * aluno1.setDataNascimento(dataNascimento);
			 * aluno1.setRegistroGeral(registroGeral); aluno1.setNumeroCpf(numeroCpf);
			 * aluno1.setNomeMae(nomeMae); aluno1.setNomePai(nomePai);
			 * aluno1.setDataMatricula(dataMatricula); aluno1.setNomeEscola(nomeEscola);
			 * aluno1.setSerieMatriculado(serieMatriculado);
			 */

			// SETANDO, RECUPERANDO E ADICIONANDO ITENS NA LISTA DINAMICAMENTE

			for (int pos = 1; pos <= 4; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog(null, "Nome da Disciplina " + pos + ": ");
				String notaDisciplina = JOptionPane.showInputDialog(null, "Nota da Disciplina " + pos + ": ");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);
			}

			// REMOVENDO ITENS DA LISTA
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

			if (escolha == 0) {// opção sim == 0

				int continuarRemover = 0;
				int posicao = 1;

				while (continuarRemover == 0) {
					String disciplnaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3, 4?");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplnaRemover).intValue() - posicao); // STRING ->
																											// INT
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a Remover?");
				}

			}
			alunos.add(aluno1);
		}

		// ADICIONANDO AO HASHMAP
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

		// PROCESSANDO LISTAS DOS ALUNOS POR STATUS
		for (Aluno aluno : alunos) {

			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				// alunosAprovados.add(aluno); SEM HASHMAP
				maps.get(StatusAluno.APROVADO).add(aluno);

			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				// alunosAprovados.add(aluno); SEM HASHMAP
				maps.get(StatusAluno.REPROVADO).add(aluno);
				;
			} else {
				// alunosReprovados.add(aluno); //
				// (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) SEM
				// HASHMAP
				maps.get(StatusAluno.RECUPERACAO).add(aluno);

			}
		}
		// COM HASHMAP
		System.out.println("-------LISTA DOS APROVADOS---------");
		for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
			System.out.println(aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado2() + " com média de = "
					+ aluno.getMediaNota());
		}

		System.out.println("-------LISTA DOS RECUPERAÇÃO---------");
		for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println(aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado2() + " com média de = "
					+ aluno.getMediaNota());
		}

		System.out.println("-------LISTA DOS REPROVADOS---------");
		for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
			System.out.println(aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado2() + " com média de = "
					+ aluno.getMediaNota());
		}

		/*
		 * //SEM HASHMAP System.out.println("-------LISTA DOS APROVADOS---------"); for
		 * (Aluno aluno : alunosAprovados) { System.out.println(aluno.getNome() +
		 * " Resultado = " + aluno.getAlunoAprovado2() + " com média de = " +
		 * aluno.getMediaNota()); }
		 * 
		 * System.out.println("-------LISTA DOS REPROVADOS---------"); for (Aluno aluno
		 * : alunosReprovados) { System.out.println(aluno.getNome() + " Resultado = " +
		 * aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota()); }
		 * 
		 * System.out.println("-------LISTA DOS RECUPERAÇÃO---------"); for (Aluno aluno
		 * : alunosRecuperacao) { System.out.println(aluno.getNome() + " Resultado = " +
		 * aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota()); }
		 */

		/*
		 * for (Aluno aluno : alunos) {
		 * 
		 * System.out.println(aluno.toString()); System.out.println("media: " +
		 * aluno.getMediaNota()); System.out.println("Resultado " +
		 * (aluno.getAlunoAprovado2()));
		 * System.out.println("--------------------------------------------------------"
		 * ); }
		 * 
		 * // PARANDO AO ENCONTRAR UM ALUNO ESPECIFICO /* for (Aluno aluno : alunos) {
		 * 
		 * if (aluno.getNome().equalsIgnoreCase("Leandro")) {
		 * System.out.println(aluno.toString()); System.out.println("media: " +
		 * aluno.getMediaNota()); System.out.println("Resultado " +
		 * (aluno.getAlunoAprovado2()));
		 * System.out.println("--------------------------------------------------------"
		 * ); break; }
		 * 
		 * }
		 */

		// PARANDO AO ENCONTRAR UM ALUNO ESPECIFICO E REMOVENDO
		/*
		 * for (Aluno aluno : alunos) {
		 * 
		 * if (aluno.getNome().equalsIgnoreCase("Leandro")) { alunos. break; }else{
		 * System.out.println(aluno.toString()); System.out.println("media: " +
		 * aluno.getMediaNota()); System.out.println("Resultado " +
		 * (aluno.getAlunoAprovado2()));
		 * System.out.println("--------------------------------------------------------"
		 * ); } }
		 */

	}
}