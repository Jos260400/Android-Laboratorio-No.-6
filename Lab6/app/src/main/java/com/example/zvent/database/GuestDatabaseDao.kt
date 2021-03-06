package com.example.zvent.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GuestDatabaseDao {

    @Insert
    fun insert(guest: Guest)

    @Update
    fun update(guest: Guest)

    @Query("SELECT * FROM guest_table WHERE id = :key")
    fun getGuest(key: Long): Guest?

    @Query("SELECT * FROM guest_table")
    fun getGuests(): LiveData<List<Guest>>

    @Query("SELECT COUNT(*) FROM guest_table")
    fun getGuestCount(): LiveData<Int>

    @Query("SELECT q.*, t.type FROM guest_table q LEFT JOIN guest_type_table t ON q.type_id = t.id")
    fun getGuestWithType(): LiveData<List<GuestWithType>>
}