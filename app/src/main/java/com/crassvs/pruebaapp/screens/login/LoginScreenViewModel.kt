package com.crassvs.pruebaapp.screens.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {

    private val auth : FirebaseAuth =  Firebase.auth
    private val _loading = MutableLiveData(false)

    fun singInWithEmailAndPassword(email: String, password: String, home: ()->Unit)
        = viewModelScope.launch{
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task->
                        if (task.isSuccessful){
                            Log.d("Label1","SingInWithEmailAndPassword is Loged")
                            home()
                        }else{
                            Log.d("Label2","SingInWithEmailAndPassword: ${task.result.toString()}")
                        }
                    }
            }catch (ex:Exception){
                Log.d("LabelError","SingInWithEmailAndPassword: ${ex.message}")
            }

        }

}