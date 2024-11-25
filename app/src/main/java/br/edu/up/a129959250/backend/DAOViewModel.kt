package br.edu.up.a129959250.backend

import android.content.ComponentCallbacks
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import com.google.protobuf.Internal.BooleanList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DAOViewModel: ViewModel() {


    fun cadastrarUsuario(
        produto: Produto,
        context: Context,
        callback: (Boolean, String?) -> Unit
    ){


        val firebase = Firebase.firestore.collection("produto").document(produto.codigo)

        try {
            firebase.set(produto).addOnSuccessListener {
                Log.i("Usuário", "Usuario cadastrado com sucesso")
                callback(true, null)
            }.addOnFailureListener{ exception ->
                callback(false, exception.message)
            }

        }
        catch (e:Exception){
            Log.e("Erro", "Erro ao cadastrar usuário")
        }

    }

    fun listarProduto(
        context: Context,
        data: (Produto) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{

        val firebase = Firebase.firestore.collection("produto").document("1")

        try {
            firebase.get().addOnSuccessListener {//lista o usuario
                if(it.exists()){
                    Log.i("Usuário listado", "Usuário listado com sucesso")
                    val userData = it.toObject<Produto>()!!
                    data(userData)
                    Log.i("Log", "Usuario: " + data(userData))

                }else{
                    Log.i("Usuário listado", "Erro ao listar usuário")
                }
            }
        }
        catch (e: Exception){
            Log.i("Erro", "Erro ao cadastrar usuário:  ${e.message}")
        }

    }

    fun listarPrincipal(
        data: (Produto?) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {

        var firebase =
            Firebase.firestore.collection("produto")

        try {

            val result = firebase.get().await()

            if (!result.isEmpty) {
                val produto = result.toObjects(Produto::class.java).firstOrNull()
                data(produto)

            } else {
            }

        } catch (e: Exception) {
            Log.e("Erro", "Erro ao listar localização:  ${e.message}")
        }
    }


    fun editarProduto(
        produto: Produto,
        context: Context,
        callback: (Boolean, String?) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{

        val firebase =
            Firebase.firestore.collection("produto").document(produto.codigo)

        try {
            firebase.set(produto)
                .addOnSuccessListener {
                    callback(true,null)
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(context, "Erro ao editar produto: ${exception.message}", Toast.LENGTH_LONG).show()
                    callback(false, exception.message)
                }
        } catch (e: Exception) {
            Log.e("Erro", "Erro ao alterar localizacao")
        }

    }

    fun excluirLocal(
        codigo: String,
        context: Context,
        callback: (Boolean, String?) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{

        val firebase =
            Firebase.firestore.collection("produto").document(codigo)

        try {
            firebase.delete()
                .addOnSuccessListener {
                    Log.i("Produto excluído", "Produto excluída com sucesso")
                    callback(true,null)
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(context, "Erro ao excluir: ${exception.message}", Toast.LENGTH_LONG).show()
                    callback(false, exception.message)
                }
        } catch (e: Exception) {
            Log.e("Erro", "Erro ao excluir produto")
            callback(false, e.message)
        }

    }



}