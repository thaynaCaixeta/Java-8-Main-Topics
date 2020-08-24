import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {

	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
}

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		/* Optional é null-safe e ele pode conter ou nao o elemento, nesse caso ele garante que nao sera retornada uma exception caso haja
		 * uma divisao por zero */
		OptionalDouble media = cursos.parallelStream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).average();

		//cursos.stream().filter(c -> c.getAlunos() >= 50).map(Curso::getNome).forEach(System.out::println);
		
		//cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));
		
		//cursos = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
		
		/*Criando uma estrutura map usando stream e lambdas*/
		cursos.parallelStream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toMap(c -> c.getNome(),c -> c.getAlunos()))
		.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}
}