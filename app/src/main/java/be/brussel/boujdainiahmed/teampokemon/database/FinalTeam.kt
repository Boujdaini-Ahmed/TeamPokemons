package be.brussel.boujdainiahmed.teampokemon.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="final_team_table")
data class FinalTeam (
    @PrimaryKey (autoGenerate = true)
    var teamId : Long = 0L,
    @ColumnInfo (name = "final_team_value")
    var finalTeamvalue : Int = -1

)
