package com.cursos.infoMS.service;

import com.cursos.infoMS.model.Curso;
import com.cursos.infoMS.model.Tema;
import com.cursos.infoMS.repository.CourseRepository;
import com.cursos.infoMS.repository.TopicRepository;
import com.cursos.infoMS.utils.Cadena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Info {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TopicRepository topicRepository;

    public List<Curso> verCursos(){
        return courseRepository.listaCursos();
    }

    public List<Tema> verTemario(int course_id){
        return topicRepository.listaDeTemas(course_id);
    }

    /*public List<Curso> convertirLista(List<String> lista){
        List<Curso> cursos = new ArrayList<>();
        Optional<Curso> curso;
        while(!lista.isEmpty()){

        }
    }*/

    public List<Curso> buscarCurso(Cadena palabra)
    {
        List<Curso> cursos = new ArrayList<>();
        List<Curso> findings = new ArrayList<>();
        String[] Words = palabra.getCadena().split(" ");

        for (int i=0; i<Words.length; i++)
        {
            findings = courseRepository.buscarCurso("%"+Words[i]+"%");

            while(!findings.isEmpty())
            {
                if (!cursos.contains(findings.get(0)))
                {
                    cursos.add(findings.get(0));
                }
                findings.remove(0);
            }
        }

        //return convertirLista(cursos);
        return cursos;
    }

}
