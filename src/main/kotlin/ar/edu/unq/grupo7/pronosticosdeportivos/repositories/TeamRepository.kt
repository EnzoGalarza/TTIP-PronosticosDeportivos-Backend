package ar.edu.unq.grupo7.pronosticosdeportivos.repositories

import ar.edu.unq.grupo7.pronosticosdeportivos.model.competitions.Team
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Configuration
@Repository
interface TeamRepository : JpaRepository<Team, Long> {

    fun findByTla(tla : String?): Optional<Team>
}