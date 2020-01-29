package be.brussel.boujdainiahmed.teampokemon.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FinalTeam::class], version = 3, exportSchema = false)
abstract class DatabaseFragment : RoomDatabase() {

    abstract val pokemonDAO : PokemonDAO

    companion object {

        @Volatile
        private var INSTANCE: DatabaseFragment? = null

        fun getInstance(context: Context) : DatabaseFragment {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseFragment::class.java,
                        "score_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}
