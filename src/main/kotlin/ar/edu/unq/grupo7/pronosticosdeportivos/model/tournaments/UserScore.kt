package ar.edu.unq.grupo7.pronosticosdeportivos.model.tournaments

import ar.edu.unq.grupo7.pronosticosdeportivos.model.user.User
import javax.persistence.*

@Entity
class UserScore(@OneToOne
                @JoinColumn(name = "user_score_id")
                val user : User,
                @Column var score : Int = 0,
                @Column var totalPronostics : Int = 0,
                @Column var hits : Int = 0,
                @Column var percentage : Int = 0) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    fun sumPoints(score: Int) {
        this.score += score
    }

    fun addHit() {
        this.score += 1
    }

    fun addPronostic(){
        totalPronostics += 1
    }

    fun calculatePercentage(){
        percentage = hits * 100 / totalPronostics
    }

}