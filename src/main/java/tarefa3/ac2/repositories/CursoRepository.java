package tarefa3.ac2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tarefa3.ac2.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
