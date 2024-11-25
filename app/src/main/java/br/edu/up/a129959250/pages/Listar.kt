/*package br.edu.up.a129959250.pages


import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.a129959250.backend.DAOViewModel
import br.edu.up.a129959250.backend.Produto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarUsuario(modifier: Modifier = Modifier, daoViewModel: DAOViewModel) {


    var produtos by remember { mutableStateOf<List<Produto>>(emptyList()) }//lista de usuarios
    val context = LocalContext.current


    var isexpanded by remember {
        mutableStateOf(false)
    }


    //val navBackStackEntry = navController.currentBackStackEntry
    // val emailUsuario = navBackStackEntry?.arguments?.getString("email") ?: ""
    @Composable
    fun LocalizacoesPagePreview(
        modifier: Modifier = Modifier,
        //navController: NavController,
        daoViewModel: DAOViewModel
    ) {

        LaunchedEffect(Unit) {
            daoViewModel.listarUsuario(context = context) { produtosList ->
                produtos = produtosList
            }
        }


        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentHeight(), horizontalAlignment = Alignment.CenterHorizontally
        ) {//centraliza
            Icon(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),//tamanho do icone
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Icon",
                tint = Color(0xFFE64A19)

            )//icone

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = "Localizações",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                color = Color.Black
            )

        }
        LazyColumn {
            items(localizacoes) { localizacao ->

                Card(
                    modifier = modifier
                        .padding(15.dp)
                        .border(
                            2.dp,
                            Color(0xFFE64A19),
                            shape = RoundedCornerShape(16.dp)
                        ), // Borda arredondada laranja
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 12.dp
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp).height(22.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = localizacao.descricao,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = {
                            daoViewModel.excluirLocal(
                                localizacao.descricao,
                                context
                            ) { result, error ->
                                if (result) {
                                    Toast.makeText(
                                        context,
                                        "Localização excluída com sucesso",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    navController.navigate("localizacoes")
                                } else {
                                    Toast.makeText(context, error, Toast.LENGTH_LONG).show()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Excluir Localização",
                                tint = Color.Red,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}*/