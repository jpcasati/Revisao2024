package br.edu.mouralacerda.revisao2024

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Carro(
    val marca: String,
    val modelo: String,
    val placa: String,
    val ano: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
) {

}
