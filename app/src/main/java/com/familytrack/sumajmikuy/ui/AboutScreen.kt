package com.familytrack.sumajmikuy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familytrack.sumajmikuy.R
import com.familytrack.sumajmikuy.ui.theme.AccentYellow
import com.familytrack.sumajmikuy.ui.theme.BackgroundBeige
import com.familytrack.sumajmikuy.ui.theme.EarthyGreen
import com.familytrack.sumajmikuy.ui.theme.PrimaryRed
import com.familytrack.sumajmikuy.ui.theme.SecondaryOrange

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBeige)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "Logo Sumaj Mikuy",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sumaj Mikuy",
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryRed,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Surface(
            color = PrimaryRed.copy(alpha = 0.1f),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "v1.0.0 MVP",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelMedium,
                color = PrimaryRed,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Acerca de Sumaj Mikuy",
                    style = MaterialTheme.typography.titleLarge,
                    color = PrimaryRed,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Aplicaci\u00F3n m\u00F3vil de recetas bolivianas r\u00E1pidas y econ\u00F3micas.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Democratiza el acceso a la gastronom\u00EDa boliviana tradicional, ayudando a optimizar el presupuesto mediante recetas f\u00E1ciles de preparar y adaptadas a los ingredientes del mercado local.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Equipo de Desarrollo",
            style = MaterialTheme.typography.titleMedium,
            color = PrimaryRed,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        TeamMemberCard(
            initials = "LL",
            name = "Luis Fernando Lopez",
            role = "Arquitectura de Software, L\u00F3gica de Negocio, Base de Datos y Backend",
            color = PrimaryRed
        )

        Spacer(modifier = Modifier.height(8.dp))

        TeamMemberCard(
            initials = "MQ",
            name = "Mayerli Quinteros",
            role = "Integraci\u00F3n de Vistas, Animaciones y Consumo de APIs en Frontend",
            color = SecondaryOrange
        )

        Spacer(modifier = Modifier.height(8.dp))

        TeamMemberCard(
            initials = "MG",
            name = "Marcelo Gonzalez",
            role = "Arquitectura de Software, L\u00F3gica de Negocio, Base de Datos y Backend",
            color = EarthyGreen
        )

        Spacer(modifier = Modifier.height(8.dp))

        TeamMemberCard(
            initials = "MM",
            name = "Maya Mercado",
            role = "Integraci\u00F3n de Vistas, Animaciones y Consumo de APIs en Frontend",
            color = AccentYellow
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = PrimaryRed
                ),
                border = ButtonDefaults.outlinedButtonBorder(enabled = true).copy(
                    brush = androidx.compose.ui.graphics.SolidColor(PrimaryRed)
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Code,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("GitHub")
            }

            Button(
                onClick = { },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SecondaryOrange
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Contacto")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
private fun TeamMemberCard(
    initials: String,
    name: String,
    role: String,
    color: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = color.copy(alpha = 0.12f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = initials,
                        color = color,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = PrimaryRed,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = role,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    lineHeight = 16.sp
                )
            }
        }
    }
}
