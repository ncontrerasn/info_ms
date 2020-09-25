package com.cursos.infoMS.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @NotBlank
    private String course_description;

    @NotBlank
    private String course_name;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "curso")
    private Set<Tema> temas;

}
