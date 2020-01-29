package be.brussel.boujdainiahmed.teampokemon

import android.app.Application
import android.content.Context
import androidx.room.Room
import be.brussel.boujdainiahmed.teampokemon.database.DatabaseFragment

class App : Application() {

    companion object {
        lateinit var context: Context
        lateinit var database: DatabaseFragment
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        database = Room.databaseBuilder(
            this,
            DatabaseFragment::class.java,
            getString(R.string.app_name)
        )
            .fallbackToDestructiveMigration()
            .build()

    }

}
