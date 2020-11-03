package com.example.appdozero1.model

/*import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoas")*/
 data class Pessoa (

     var docId : String,
     var nome : String,
     var cpf : String,
     var foto : String,
     var altura : Int
 )
 {
     constructor() : this(String(), String(), String(), String(),0)
 }


