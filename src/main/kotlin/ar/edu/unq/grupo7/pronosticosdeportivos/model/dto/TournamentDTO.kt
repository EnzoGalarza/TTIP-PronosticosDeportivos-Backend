package ar.edu.unq.grupo7.pronosticosdeportivos.model.dto

import ar.edu.unq.grupo7.pronosticosdeportivos.model.tournaments.Tournament

data class TournamentDTO(val name : String, val competition : String, val usersEmail : List<String>)

fun TournamentDTO.toModel() = Tournament(name = name, competition = competition)