package com.familytrack.sumajmikuy.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.familytrack.sumajmikuy.data.local.CloudinaryConfig
import com.familytrack.sumajmikuy.model.sampleRecipes
import com.familytrack.sumajmikuy.ui.theme.AccentYellow
import com.familytrack.sumajmikuy.ui.theme.BackgroundBeige
import com.familytrack.sumajmikuy.ui.theme.EarthyGreen
import com.familytrack.sumajmikuy.ui.theme.PrimaryRed
import com.familytrack.sumajmikuy.ui.theme.SecondaryOrange
import com.familytrack.sumajmikuy.viewmodel.FavoritesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(recipeId: Int, navController: NavController) {
    val recipe = sampleRecipes.find { it.id == recipeId }
    val favoritesViewModel: FavoritesViewModel = viewModel()
    val isFavorite by favoritesViewModel.favoriteIds.collectAsState()

    if (recipe == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Receta no encontrada",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryRed
            )
        }
        return
    }

    val isCurrentFavorite = recipeId in isFavorite

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { favoritesViewModel.toggleFavorite(recipe.id) }) {
                        Icon(
                            imageVector = if (isCurrentFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = if (isCurrentFavorite) "Quitar de favoritos" else "Agregar a favoritos",
                            tint = if (isCurrentFavorite) AccentYellow else Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryRed
                )
            )
        },
        containerColor = BackgroundBeige
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                AsyncImage(
                    model = if (recipe.imagePublicId.startsWith("http")) {
                        recipe.imagePublicId
                    } else {
                        CloudinaryConfig.buildUrl(recipe.imagePublicId)
                    },
                    contentDescription = recipe.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = SecondaryOrange.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = recipe.region,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                color = SecondaryOrange,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }

                        Surface(
                            color = AccentYellow.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = recipe.category,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                color = PrimaryRed,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        InfoChip(icon = "\u23F1\uFE0F", label = recipe.time)
                        InfoChip(icon = "\uD83D\uDCB0", label = recipe.priceRange)
                        InfoChip(icon = "\uD83C\uDF7D\uFE0F", label = "1-2 pers.")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.DarkGray,
                        lineHeight = 24.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    HorizontalDivider(thickness = 1.dp, color = PrimaryRed.copy(alpha = 0.15f))
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "INGREDIENTES",
                        style = MaterialTheme.typography.titleMedium,
                        color = PrimaryRed,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 2.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    recipe.ingredients.forEach { ingredient ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "\u2022",
                                color = SecondaryOrange,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(
                                text = ingredient,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.DarkGray,
                                lineHeight = 24.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    HorizontalDivider(thickness = 1.dp, color = PrimaryRed.copy(alpha = 0.15f))
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "PREPARACI\u00D3N",
                        style = MaterialTheme.typography.titleMedium,
                        color = PrimaryRed,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 2.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    recipe.steps.forEachIndexed { index, step ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Surface(
                                color = EarthyGreen.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(50),
                                modifier = Modifier.size(28.dp)
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(
                                        text = "${index + 1}",
                                        color = EarthyGreen,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = step,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.DarkGray,
                                lineHeight = 24.sp,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Composable
private fun InfoChip(icon: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = icon,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = PrimaryRed,
            fontWeight = FontWeight.SemiBold
        )
    }
}
