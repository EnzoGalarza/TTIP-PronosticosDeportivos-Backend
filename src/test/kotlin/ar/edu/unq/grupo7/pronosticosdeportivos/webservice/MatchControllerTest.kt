package ar.edu.unq.grupo7.pronosticosdeportivos.webservice

import ar.edu.unq.grupo7.pronosticosdeportivos.model.dto.TeamDTO
import ar.edu.unq.grupo7.pronosticosdeportivos.model.dto.MatchDTO
import ar.edu.unq.grupo7.pronosticosdeportivos.model.dto.ResultDTO
import ar.edu.unq.grupo7.pronosticosdeportivos.model.dto.ScoreDTO
import ar.edu.unq.grupo7.pronosticosdeportivos.service.MatchService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
class MatchControllerTest(@Mock val matchService : MatchService) {

    @InjectMocks
    lateinit var matchController : MatchController

    @Test
    fun getMatchsOfCompetitionPL(){
        val eq1 = TeamDTO("Manchester United","MUN","logoMun")
        val eq2 = TeamDTO("Southampton FC","SOU","logoSou")
        val eq3 = TeamDTO("Aston Villa FC","SOU","logoSou")
        val score = ScoreDTO("DRAW", ResultDTO(1,2))
        val partido1 = MatchDTO(1,"FINISHED","2022-11-05T15:00:00Z",25,eq1,eq2,score)
        val partido2 = MatchDTO(2,"FINISHED","2022-11-05T15:00:00Z",30,eq1,eq3,score)

        Mockito.`when`(matchService.getMatches("PL")).thenReturn(mutableListOf(partido1,partido2))

        var todosLosPartidos = matchController.getTodosLosPartidos("PL")

        assertEquals(mutableListOf(partido1,partido2),todosLosPartidos.body)
        assertEquals(HttpStatus.OK,todosLosPartidos.statusCode)
    }
}