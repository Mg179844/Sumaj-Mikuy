package com.familytrack.sumajmikuy.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteRecipeEntity)

    @Delete
    suspend fun delete(favorite: FavoriteRecipeEntity)

    @Query("SELECT * FROM favorite_recipes ORDER BY recipeId ASC")
    fun getAllFavorites(): Flow<List<FavoriteRecipeEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_recipes WHERE recipeId = :recipeId)")
    fun isFavorite(recipeId: Int): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_recipes WHERE recipeId = :recipeId)")
    suspend fun isFavoriteSync(recipeId: Int): Boolean
}
