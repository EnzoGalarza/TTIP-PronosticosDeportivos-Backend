package ar.edu.unq.grupo7.pronosticosdeportivos.repositories

import ar.edu.unq.grupo7.pronosticosdeportivos.model.pronostics.Pronostic
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Configuration
@Repository
interface PronosticRepository : JpaRepository<Pronostic,Long>{

    @Query("SELECT * FROM pronosticos p WHERE (p.user = ?1)", nativeQuery = true)
    fun pronosticsFromUser(user : String) : List<Pronostic>

    fun findByUser(user : String) : List<Pronostic>
}
