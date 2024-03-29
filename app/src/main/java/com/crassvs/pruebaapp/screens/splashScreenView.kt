package com.crassvs.pruebaapp.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crassvs.pruebaapp.navigation.AppNavigation
import com.crassvs.pruebaapp.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreenView(navController: NavController){
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
            scale.animateTo(targetValue = 01f,
                animationSpec = tween(durationMillis = 800,
                    easing = {
                        OvershootInterpolator(8f)
                            .getInterpolation(it)
                    }
                ),
            )

        delay(3500L)
        navController.navigate(AppScreens.LoginScreen.name)
    }
    val color = MaterialTheme.colorScheme.primary
        Surface(modifier = Modifier
            .padding(15.dp)
            .size(330.dp)
            .scale(scale.value),
            shape = CircleShape,
            color = Color.White,
            border = BorderStroke(width = 2.dp, color = color )
        ){
            Column(modifier = Modifier
                .padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "SplashScreen",
                    style = MaterialTheme.typography.bodyLarge,
                    color = color.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text("XD",
                    style = MaterialTheme.typography.bodySmall,
                    color = color
                    )
            }
        }


}