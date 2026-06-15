package com.familytrack.sumajmikuy.data.repository

import com.familytrack.sumajmikuy.data.local.FavoriteRecipeDao
import com.familytrack.sumajmikuy.data.local.FavoriteRecipeEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val dao: FavoriteRecipeDao) {

    fun getAllFavorites(): Flow<List<FavoriteRecipeEntity>> = dao.getAllFavorites()

    fun isFavorite(recipeId: Int): Flow<Boolean> = dao.isFavorite(recipeId)

    suspend fun toggleFavorite(recipeId: Int) {
        if (dao.isFavoriteSync(recipeId)) {
            dao.delete(FavoriteRecipeEntity(recipeId))
        } else {
            dao.insert(FavoriteRecipeEntity(recipeId))
        }
    }

    suspend fun removeFavorite(recipeId: Int) {
        dao.delete(FavoriteRecipeEntity(recipeId))
    }
}
