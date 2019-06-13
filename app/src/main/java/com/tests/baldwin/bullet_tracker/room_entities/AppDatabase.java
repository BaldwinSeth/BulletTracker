package com.tests.baldwin.bullet_tracker.room_entities;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Bullet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BulletDao bulletDao();
}
