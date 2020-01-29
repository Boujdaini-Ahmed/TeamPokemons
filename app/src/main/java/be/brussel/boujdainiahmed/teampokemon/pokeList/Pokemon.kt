package be.brussel.boujdainiahmed.teampokemon.pokeList


import com.squareup.moshi.Json



data class Pokemon(

    val id: String,
    @Json(name = "imageurl") val imgScrUrl: String,
    //@Json(name = "male_percentage") val malePercentage: String,
    val name: String,
    val category: String?,
    val ydescription : String,
    @Json(name = "hp") val HP: Int

)






