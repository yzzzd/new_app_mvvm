package id.nuryaz.newapp.data.room.visit

import androidx.room.*

@Dao
interface VisitDao {
    @Insert
    fun insert(visit: Visit)

    @Query("SELECT * FROM visit")
    fun getAll(): List<Visit>

    @Update
    fun update(visit: Visit)

    @Delete
    fun delete(visit: Visit)
}