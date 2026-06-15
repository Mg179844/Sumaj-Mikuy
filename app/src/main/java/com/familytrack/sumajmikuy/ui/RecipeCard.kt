package com.familytrack.sumajmikuy.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.familytrack.sumajmikuy.data.local.CloudinaryConfig
import com.familytrack.sumajmikuy.model.Recipe
import com.familytrack.sumajmikuy.ui.theme.PrimaryRed
import com.familytrack.sumajmikuy.ui.theme.SecondaryOrange

@Composable
fun RecipeCard(recipe: Recipe, onClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick(recipe.id) },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            AsyncImage(
                model = if (recipe.imagePublicId.startsWith("http")) {
                    recipe.imagePublicId
                } else {
                    CloudinaryConfig.buildUrl(recipe.imagePublicId)
                },
                contentDescription = recipe.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = recipe.category.uppercase(),
                        style = MaterialTheme.typography.labelMedium,
                        color = SecondaryOrange,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = recipe.region,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Gray
                    )
                }

                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = PrimaryRed,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 0.5.dp, color = Color.LightGray)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "\u23F1\uFE0F ${recipe.time}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray
                    )

                    Surface(
                        color = PrimaryRed.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "\uD83D\uDCB0 ${recipe.priceRange}",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = PrimaryRed
                        )
                    }
                }
            }
        }
    }
}
