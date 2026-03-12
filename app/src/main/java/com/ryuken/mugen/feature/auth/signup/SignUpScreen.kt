package com.ryuken.mugen.feature.auth.signup

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ryuken.mugen.R

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirm by remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFF0a0a0f),  // deep void top
                            0.4f to Color(0xFF1a0530),  // purple mid
                            0.7f to Color(0xFF0d0208),  // dark red hint
                            1.0f to Color(0xFF0a0a1a)   // blue-black bottom
                        )
                    )
                )
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(229.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Username") })
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") })
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                isError = password.length >= 8 && password.length <= 13
            )
            OutlinedTextField(
                value = confirm,
                onValueChange = { confirm = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                isError = password.isNotEmpty() && confirm.isNotEmpty() && password != confirm
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirm.isNotEmpty() && password == confirm) {
                Text(text = "Sign Up")
            }
            TextButton(onClick = { navController.popBackStack() }) {
                Text(text = "Already have an account? SignIn")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navController = rememberNavController())
}
