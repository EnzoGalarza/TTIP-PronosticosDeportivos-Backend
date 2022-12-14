package ar.edu.unq.grupo7.pronosticosdeportivos.repositories

import ar.edu.unq.grupo7.pronosticosdeportivos.model.competitions.Match
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Configuration
@Repository
interface MatchRepository : JpaRepository<Match, Long> {

    @Query("SELECT * FROM match WHERE (competition = :competition AND match_day = :matchDay)", nativeQuery = true)
    fun findByCompetitionAndMatchDay(matchDay : Int, competition: String) : List<Match>

    @Query("SELECT * FROM match WHERE (code = :code)",nativeQuery = true)
    fun findByCode(code : Long) : Optional<Match>
}