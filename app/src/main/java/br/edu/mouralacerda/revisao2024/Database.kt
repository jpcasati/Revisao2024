package br.edu.mouralacerda.revisao2024

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [Carro::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun carroDAO(): CarroDAO

    companion object {

        private var database: Database? = null
        private val DATABASE = "CARROS"

        // Padrão de Projeto: Singleton
        // Só deixa existir uma instância na aplicação
        fun getInstance(context: Context): Database? {
            if(database == null) {
                return criaBanco(context)
            } else {
                return database
            }
        }

        private fun criaBanco(context: Context): Database? {
            return Room.databaseBuilder(
                context, Database::class.java, DATABASE)
                .allowMainThreadQueries().build()
        }
    }


}