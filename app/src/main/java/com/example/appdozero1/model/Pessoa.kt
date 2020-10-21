package com.example.appdozero1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoas")
 data class Pessoa (
    @PrimaryKey(autoGenerate = true)
     var id : Int,
     var nome : String,
     var cpf : String,
     var altura : Double
 )
 {
     constructor() : this(0, String(), String(), 0.0)
 }


