package br.edu.mouralacerda.revisao2024

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CarroDAO {

    @Insert
    fun salvar(c: Carro)

    @Query("SELECT * FROM Carro")
    fun listar(): List<Carro>

}