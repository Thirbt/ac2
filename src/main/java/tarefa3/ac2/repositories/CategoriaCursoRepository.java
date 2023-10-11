package tarefa3.ac2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tarefa3.ac2.models.CategoriaCurso;


@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Long> {
    Optional<CategoriaCurso> findByNome(String nome);
}
