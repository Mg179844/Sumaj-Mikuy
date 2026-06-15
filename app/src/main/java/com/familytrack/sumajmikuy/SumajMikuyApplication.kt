package com.familytrack.sumajmikuy

import android.app.Application
import com.familytrack.sumajmikuy.data.local.RecipeDatabase
import com.familytrack.sumajmikuy.data.repository.FavoriteRepository

class SumajMikuyApplication : Application() {

    val database by lazy { RecipeDatabase.getInstance(this) }

    val favoriteRepository by lazy { FavoriteRepository(database.favoriteRecipeDao()) }
}
