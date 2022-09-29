package ar.edu.unq.grupo7.pronosticosdeportivos.repositories

import ar.edu.unq.grupo7.pronosticosdeportivos.model.competitions.Match
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Configuration
@Repository
interface MatchRepository : JpaRepository<Match, Long> {

    @Query("SELECT COUNT(*) FROM partidos\n" +
            "WHERE (competition = ?2 AND match_day = ?1 AND status = 'FINISHED')", nativeQuery = true)
    fun countFinishedMatchesByCompetition(matchDay : Int, competition: String) : Int

    @Query("SELECT * FROM partidos WHERE (match_day = ?1)", nativeQuery = true)
    fun findByMatchDay(match_day: Int) : List<Match>
}