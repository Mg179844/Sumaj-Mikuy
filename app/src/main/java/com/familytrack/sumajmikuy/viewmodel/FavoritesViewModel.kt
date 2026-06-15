package com.familytrack.sumajmikuy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.familytrack.sumajmikuy.SumajMikuyApplication
import com.familytrack.sumajmikuy.data.repository.FavoriteRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FavoriteRepository =
        (application as SumajMikuyApplication).favoriteRepository

    private val _favoriteIds = MutableStateFlow<Set<Int>>(emptySet())
    val favoriteIds: StateFlow<Set<Int>> = _favoriteIds.asStateFlow()

    val favoriteCount: StateFlow<Int> = _favoriteIds
        .map { it.size }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    init {
        observeFavorites()
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            repository.getAllFavorites().collect { favorites ->
                _favoriteIds.value = favorites.map { it.recipeId }.toSet()
            }
        }
    }

    fun isFavorite(recipeId: Int): Boolean {
        return _favoriteIds.value.contains(recipeId)
    }

    fun toggleFavorite(recipeId: Int) {
        viewModelScope.launch {
            repository.toggleFavorite(recipeId)
        }
    }
}
