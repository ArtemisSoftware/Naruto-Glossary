package com.artemissoftware.narutoglossary.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artemissoftware.narutoglossary.util.Constants.HERO_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = HERO_DATABASE_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
){

    companion object{

        fun getMock() = Hero(
            id = 1,
            name = "Sasuke",
            image = "",
            about = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
            rating = 0.0,
            power = 100,
            month = "",
            day = "",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        )
    }

}