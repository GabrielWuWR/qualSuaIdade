package com.example.informaidade

import android.R.attr.font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.informaidade.ui.theme.InformaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InformaIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    telaPrincipal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun telaPrincipal(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qual é a sua idade?", color = Color(0xFF4559b4), fontSize = 30.sp);
        Text("Aperte os botões \n para informar a sua idade", fontSize = 17.sp, textAlign = TextAlign.Center);
        Spacer(Modifier.height(15.dp))
        Text("17", fontWeight = FontWeight.Bold, fontSize = 35.sp)
        Spacer(Modifier.height(15.dp))
        Botao(valor = 1)
    }
}

@Composable
fun Botao(modifier: Modifier = Modifier, valor: Int = 0) {
    Box(
        modifier = Modifier.width(30.dp).height(30.dp).background(color = Color(0xFF4559b4))
    ) {
        if(valor >= 0) {
            Text("+", color = Color.White)
        }

    }
}