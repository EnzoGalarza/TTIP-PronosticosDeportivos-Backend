package ar.edu.unq.grupo7.pronosticosdeportivos.model.competitions

import ar.edu.unq.grupo7.pronosticosdeportivos.model.dto.TeamDTO
import javax.persistence.*

@Entity
@Table(name = "team")
class Team(val name: String?, val tla : String?, val crest : String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0


}

fun Team.toDTO() = TeamDTO(name = name, tla = tla, crest = crest)