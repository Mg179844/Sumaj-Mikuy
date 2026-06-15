package com.familytrack.sumajmikuy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.familytrack.sumajmikuy.model.sampleRecipes
import com.familytrack.sumajmikuy.ui.theme.BackgroundBeige
import com.familytrack.sumajmikuy.ui.theme.PrimaryRed
import com.familytrack.sumajmikuy.viewmodel.FavoritesViewModel

@Composable
fun FavoritesScreen(navController: NavController) {
    val viewModel: FavoritesViewModel = viewModel()
    val favoriteIds by viewModel.favoriteIds.collectAsState()
    val favoriteCount by viewModel.favoriteCount.collectAsState()

    val favoriteRecipes = sampleRecipes.filter { it.id in favoriteIds }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBeige)
    ) {
        if (favoriteCount > 0) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                color = Color.White,
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 1.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Mis Favoritos",
                        style = MaterialTheme.typography.titleMedium,
                        color = PrimaryRed,
                        fontWeight = FontWeight.Bold
                    )
                    Surface(
                        color = PrimaryRed.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "$favoriteCount receta${if (favoriteCount != 1) "s" else ""}",
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.labelMedium,
                            color = PrimaryRed,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        if (favoriteRecipes.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(32.dp)
                ) {
                    Text(
                        text = "\u2764\uFE0F",
                        fontSize = MaterialTheme.typography.displayLarge.fontSize
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "No tienes recetas favoritas todav\u00EDa",
                        style = MaterialTheme.typography.titleLarge,
                        color = PrimaryRed,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Explora las recetas y marca tus favoritas con el \u00EDcono de coraz\u00F3n.",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(favoriteRecipes) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = { recipeId -> navController.navigate("detail/$recipeId") }
                    )
                }
            }
        }
    }
}
