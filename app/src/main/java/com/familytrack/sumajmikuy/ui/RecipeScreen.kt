package com.familytrack.sumajmikuy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.familytrack.sumajmikuy.R
import com.familytrack.sumajmikuy.model.sampleRecipes
import com.familytrack.sumajmikuy.ui.theme.BackgroundBeige
import com.familytrack.sumajmikuy.ui.theme.PrimaryRed
import com.familytrack.sumajmikuy.ui.theme.SecondaryOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    var selectedRegion by remember { mutableStateOf("Todas") }

    val regions = listOf("Todas", "Altiplano", "Valles", "Oriente")

    val filteredRecipes = sampleRecipes.filter { recipe ->
        val matchesSearch = recipe.name.contains(searchText, ignoreCase = true) ||
                recipe.ingredients.any { it.contains(searchText, ignoreCase = true) }
        val matchesRegion = selectedRegion == "Todas" || recipe.region == selectedRegion

        matchesSearch && matchesRegion
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_app),
                            contentDescription = "Logo Sumaj Mikuy",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            "Sumaj Mikuy",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryRed)
            )
        },
        containerColor = BackgroundBeige
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("\u00BFQu\u00E9 cocinamos hoy? (ej. huevo, sajta)") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = PrimaryRed) },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryRed,
                    unfocusedBorderColor = Color.LightGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                items(regions) { region ->
                    val isSelected = selectedRegion == region
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedRegion = region },
                        label = { Text(region) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = SecondaryOrange,
                            selectedLabelColor = Color.White,
                            labelColor = PrimaryRed
                        ),
                        border = FilterChipDefaults.filterChipBorder(
                            enabled = true,
                            selected = isSelected,
                            borderColor = PrimaryRed,
                            selectedBorderColor = SecondaryOrange
                        )
                    )
                }
            }

            if (filteredRecipes.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(32.dp)
                    ) {
                        Text(
                            text = "\u00A1Ujuy!",
                            style = MaterialTheme.typography.displaySmall,
                            color = PrimaryRed,
                            fontWeight = FontWeight.Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "No encontramos esa receta, intenta con otro ingrediente del mercado.",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { searchText = ""; selectedRegion = "Todas" },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryRed)
                        ) {
                            Text("Ver todas las recetas")
                        }
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredRecipes) { recipe ->
                        RecipeCard(
                            recipe = recipe,
                            onClick = { recipeId -> navController.navigate("detail/$recipeId") }
                        )
                    }
                }
            }
        }
    }
}
