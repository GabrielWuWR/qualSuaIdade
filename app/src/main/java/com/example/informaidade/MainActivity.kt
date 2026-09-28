package com.example.informaidade

import android.R.attr.font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
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
var idade by mutableStateOf(0)
var maioridade by mutableStateOf("MENOR")

@Composable
fun telaPrincipal(modifier: Modifier = Modifier) {


    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Qual é a sua idade?", color = Color(0xFF4559b4), fontSize = 30.sp);
        Spacer(Modifier.height(5.dp))
        Text("Aperte os botões para informar a\n sua idade", fontSize = 18.sp, textAlign = TextAlign.Center);
        Spacer(Modifier.height(15.dp))
        Text(text = idade.toString(), fontWeight = FontWeight.Bold, fontSize = 35.sp)
        Spacer(Modifier.height(15.dp))

        Row() {
            Botao(valor = -1)
            Spacer(modifier = modifier.width(20.dp))
            Botao(valor = 1)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Você é $maioridade de idade", color = Color(0xFF4559b4), fontSize = 30.sp)

    }
}

@Composable
fun Botao(modifier: Modifier = Modifier, valor: Int = 0) {
    Box(
        modifier = modifier
            .width(80.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = Color(0xFF4559b4))
            .clickable {
                var novaIdade  = idade + valor;

                if(novaIdade in 0..180) {
                    idade += valor
                }

                if(idade < 18) {
                    maioridade = "MENOR"
                } else {
                    maioridade = "MAIOR"
                }
            },
        contentAlignment = Alignment.Center

    ) {
        if(valor >= 0) {
            Text("+", color = Color.White, fontSize = 35.sp)
        } else if (valor < 0) {
            Text("-", color = Color.White, fontSize = 35.sp)
        }
    }
}
