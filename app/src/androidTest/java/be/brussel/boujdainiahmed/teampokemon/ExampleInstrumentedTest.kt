package be.brussel.boujdainiahmed.teampokemon

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.brussel.boujdainiahmed.teampokemon.database.DatabaseFragment
import be.brussel.boujdainiahmed.teampokemon.database.FinalTeam
import be.brussel.boujdainiahmed.teampokemon.database.PokemonDAO
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ScoreDatabaseTest {

    private lateinit var scoreDao: PokemonDAO
    private lateinit var db: DatabaseFragment

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, DatabaseFragment::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        scoreDao = db.pokemonDAO
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertandgetScore() {
        val score = FinalTeam()
        scoreDao.insert(score)
        val finalScore1 = scoreDao.getFinal()
        assertEquals(finalScore1?.finalTeamvalue, -1 )
    }
}