package com.cursos.infoMS.repository;

import com.cursos.infoMS.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Tema, Integer> {

    @Query(value = "select * from topic where course_id = ?1", nativeQuery = true)
    List<Tema> listaDeTemas(int course_id);

}
