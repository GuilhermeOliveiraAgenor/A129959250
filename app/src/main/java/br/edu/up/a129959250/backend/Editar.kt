package br.edu.up.a129959250.backend

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun editarLocal(
    produto: Produto,
    context: Context,
    callback: (Boolean, String?) -> Unit
) = CoroutineScope(Dispatchers.IO).launch{

    val firebase =
        Firebase.firestore.collection("usuario").document("codigo")

    try {
        val addOnFailureListener = firebase.set(produto)
            .addOnSuccessListener {
                callback(true, null)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(
                    context,
                    "Erro ao editar produto: ${exception.message}",
                    Toast.LENGTH_LONG
                ).show()
                callback(false, exception.message)
            }
    } catch (e: Exception) {
        Log.e("Erro", "Erro ao alterar produto")
    }

}

fun excluirLocal(
    produto: String,
    context: Context,
    callback: (Boolean, String?) -> Unit
) = CoroutineScope(Dispatchers.IO).launch{

    val firebase =
        Firebase.firestore.collection("usuario").document(produto)

    try {
        firebase.delete()
            .addOnSuccessListener {
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