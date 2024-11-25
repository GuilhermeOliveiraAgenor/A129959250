@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.atividade.pages

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.a129959250.backend.DAOViewModel
import br.edu.up.a129959250.backend.Produto

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditarPage(modifier: Modifier = Modifier, daoViewModel: DAOViewModel) {


    var produto by remember { mutableStateOf<List<Produto>>(emptyList()) }//lista de usuarios

    var codigo: String by remember { mutableStateOf("") }
    var descricao: String by remember { mutableStateOf("") }
    var categoria: String by remember { mutableStateOf("") }
    var preco: String by remember { mutableStateOf("") }

    val context = LocalContext.current

    var isexpanded by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        daoViewModel.listarProduto(context = context)
        { data ->
            codigo = data.codigo
            descricao = data.descricao
            categoria = data.categoria
            preco = data.preco
        }


    }

    Surface(color = MaterialTheme.colorScheme.background) {


        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .wrapContentHeight(), horizontalAlignment = Alignment.CenterHorizontally
        ) {//centraliza
            Icon(
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp),//tamanho do icone
                imageVector = Icons.Default.AccountCircle, contentDescription = "Icon", tint = Color(0xFFE64A19) // Define a cor do ícone como laranja

            )//icone

            val context = LocalContext.current

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {


                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp)), // Fundo whitesmoke
                    value = codigo,
                    onValueChange = { codigo = it },
                    label = { Text(text = "Codigo", color = Color.Black) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFE64A19), // Cor do indicador focado alterada para laranja escuro
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { Log.d("ImeAction", "Done pressed") }
                    ),
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 18.sp)
                )

                Spacer(modifier = Modifier.height(25.dp))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp)),
                    value = descricao,
                    onValueChange = { descricao = it },
                    label = { Text(text = "Descrição", color = Color.Black) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFE64A19),
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { Log.d("ImeAction", "Done pressed") }
                    ),
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 18.sp)
                )

                Spacer(modifier = Modifier.height(25.dp))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp)),
                    value = categoria,
                    onValueChange = { categoria = it },
                    label = { Text(text = "Categoria", color = Color.Black,fontSize = 16.sp) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFE64A19),
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { Log.d("ImeAction", "Done pressed") }
                    ),
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 18.sp)
                )

                Spacer(modifier = Modifier.height(25.dp))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp)),
                    value = preco,
                    onValueChange = { preco = it },
                    label = { Text(text = "Preço", color = Color.Black,fontSize = 16.sp) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFE64A19),
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { Log.d("ImeAction", "Done pressed") }
                    ),
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 18.sp)
                )

                Spacer(modifier = Modifier.padding(15.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    onClick = {

                        var produtoData = Produto(
                            codigo = codigo,
                            descricao = descricao,
                            categoria = categoria,
                            preco = preco

                        )


                        daoViewModel.editarProduto(produto = produtoData, context = context) { result,error ->
                            if (result) {
                                Toast.makeText(context, "Produto editado com sucesso", Toast.LENGTH_SHORT).show()

                            } else {
                                Toast.makeText(context, error ?: "Erro ao editar produto", Toast.LENGTH_SHORT).show()
                            }
                        }

                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE64A19)), // Cor do botão alterada para laranja escuro
                    shape = RoundedCornerShape(12.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(4.dp)
                ) {
                    Text(text = "Editar", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold) // Fonte maior e negrito
                }

            }

        }

    }
}


