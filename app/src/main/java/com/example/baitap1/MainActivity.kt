package com.example.baitap1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UngDungTinhTong()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UngDungTinhTong() {
    var soThuNhat by remember { mutableStateOf("") }
    var soThuHai by remember { mutableStateOf("") }
    var ketQua by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = soThuNhat,
            onValueChange = { soThuNhat = it },
            label = { Text("So thu nhat") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = soThuHai,
            onValueChange = { soThuHai = it },
            label = { Text("So thu hai") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val num1 = soThuNhat.toIntOrNull() ?: 0
                val num2 = soThuHai.toIntOrNull() ?: 0
                ketQua = "Ket qua: ${num1 + num2}"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tinh tong")
        }

        Text(
            text = ketQua,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
