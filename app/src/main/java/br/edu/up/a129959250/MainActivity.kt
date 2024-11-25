package br.edu.up.a129959250

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.up.a129959250.backend.DAOViewModel
import br.edu.up.a129959250.pages.CadastroPage
import br.edu.up.a129959250.ui.theme.AppA129959250Theme
import com.example.atividade.pages.EditarPage

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppA129959250Theme {
              CadastroPage(daoViewModel = DAOViewModel())
            }
        }
    }
}
