package com.cursos.infoMS.controller;

import com.cursos.infoMS.model.Curso;
import com.cursos.infoMS.model.Tema;
import com.cursos.infoMS.service.Info;
import com.cursos.infoMS.utils.Cadena;
import com.cursos.infoMS.utils.Entero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class Controller {

    @Autowired
    Info info;

    @GetMapping("/cursos")
    public List<Curso> cursos() { return  info.verCursos(); }

    @PostMapping("/temario")
    public List<Tema> temas(@Valid @RequestBody Entero entero) { return info.verTemario(entero.getEntero()); }

    @PostMapping("/buscarCurso")
    public List<Curso> buscarCurso(@Valid @RequestBody Cadena cadena) { return info.buscarCurso(cadena); }

}
