package ar.edu.unq.grupo7.pronosticosdeportivos.service

import ar.edu.unq.grupo7.pronosticosdeportivos.model.Pronostico
import ar.edu.unq.grupo7.pronosticosdeportivos.repositories.PronosticoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PronosticoService {

    @Autowired
    private lateinit var repository : PronosticoRepository

    fun findAll() : List<Pronostico>{
        return repository.findAll()
    }

    fun save(pronostico: Pronostico): Pronostico{
        return repository.save(pronostico)
    }
}
