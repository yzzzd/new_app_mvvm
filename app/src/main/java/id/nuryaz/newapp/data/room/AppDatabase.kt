package id.nuryaz.newapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.nuryaz.newapp.data.room.converter.RoomConverter
import id.nuryaz.newapp.data.room.visit.Visit
import id.nuryaz.newapp.data.room.visit.VisitDao

@Database(
    entities = [
        Visit::class
    ], version = 1, exportSchema = false
)
@TypeConverters(RoomConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun visitDao(): VisitDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "new-app.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}