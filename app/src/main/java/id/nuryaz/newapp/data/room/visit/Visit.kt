package id.nuryaz.newapp.data.room.visit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visit")
data class Visit(
  val location: String,
  val date: String,
  val time: String,
  val accessories: List<String>,
  val type: String,
  val rating: Float
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}