package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.netflixclone.ui.theme.NetflixRed

@Composable
fun SignInScreen(onSignIn: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Black, Color(0xFF1A1A1A))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = "Netflix",
                color = NetflixRed,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            AuthTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email or phone number"
            )
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                isPassword = true,
                showPassword = showPassword,
                onTogglePassword = { showPassword = !showPassword }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onSignIn,
                colors = ButtonDefaults.buttonColors(containerColor = NetflixRed),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Sign In", color = Color.White, modifier = Modifier.padding(vertical = 4.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it }
                    )
                    Text(text = "Remember me", color = Color.White)
                }
                TextButton(onClick = { /* TODO: Forgot Password flow */ }) {
                    Text(text = "Need help?", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Sign in is protected by Google reCAPTCHA to ensure you're not a bot.",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
private fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    showPassword: Boolean = false,
    onTogglePassword: (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = NetflixRed,
            unfocusedBorderColor = Color.DarkGray,
            cursorColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            placeholderColor = Color.Gray,
            containerColor = Color(0x33000000)
        ),
        visualTransformation = if (isPassword && !showPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = if (isPassword && onTogglePassword != null) {
            {
                Text(
                    text = if (showPassword) "HIDE" else "SHOW",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clickable(onClick = onTogglePassword),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        } else null
    )
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    com.example.netflixclone.ui.theme.NetflixCloneTheme {
        SignInScreen(onSignIn = {})
    }
}
