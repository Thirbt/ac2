package tarefa3.ac2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tarefa3.ac2.models.CategoriaCurso;
import tarefa3.ac2.models.Curso;
import tarefa3.ac2.repositories.CategoriaCursoRepository;
import tarefa3.ac2.repositories.CursoRepository;

@SpringBootApplication
public class Ac2Application {
	
	@Bean
	public CommandLineRunner init(@Autowired CategoriaCursoRepository categoriaCursoRepository, @Autowired CursoRepository cursoRepository){
		return args -> {

			CategoriaCurso categoria1 = new CategoriaCurso(null, "Tecnologia", null);
			CategoriaCurso categoria2 = new CategoriaCurso(null, "Culinária", null);
			CategoriaCurso categoria3 = new CategoriaCurso(null, "Jogos", null);

			categoriaCursoRepository.save(categoria1);
			categoriaCursoRepository.save(categoria2);
			categoriaCursoRepository.save(categoria3);

			CategoriaCurso categoria1Encontrada = categoriaCursoRepository.findById(1L).get();
			CategoriaCurso categoria2Encontrada = categoriaCursoRepository.findById(2L).get();
			CategoriaCurso categoria3Encontrada = categoriaCursoRepository.findById(3L).get();

			Curso curso1 = new Curso(null, "Análise e Desenvolvimento de Sistemas", 200, categoria1Encontrada);
			Curso curso2 = new Curso(null, "Comida Japonesa", 100, categoria2Encontrada);
			Curso curso3 = new Curso(null, "Jogos Digitais", 250, categoria3Encontrada);

			cursoRepository.save(curso1);
			cursoRepository.save(curso2);
			cursoRepository.save(curso3);

			List<Curso> tecnologiaList = new ArrayList<>();
			tecnologiaList.add(curso1);
			
			List<Curso> culinariaList = new ArrayList<>();
			culinariaList.add(curso2);

			List<Curso> jogoList = new ArrayList<>();
			jogoList.add(curso3);

			categoria1Encontrada.setCursos(tecnologiaList);
			categoria2Encontrada.setCursos(culinariaList);
			categoria3Encontrada.setCursos(jogoList);

			categoriaCursoRepository.save(categoria1Encontrada);
			categoriaCursoRepository.save(categoria2Encontrada);
			categoriaCursoRepository.save(categoria3Encontrada);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}


}
