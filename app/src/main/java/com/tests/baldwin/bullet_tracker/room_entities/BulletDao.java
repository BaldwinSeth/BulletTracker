package com.tests.baldwin.bullet_tracker.room_entities;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BulletDao {
    @Query("SELECT * FROM bullet")
    List<Bullet> getAllBullets();
    @Query("DELETE FROM bullet")
    void NukeTable();
    @Delete void delete(Bullet bullet);
    @Insert
    void instertAll(Bullet...bullets);
}
