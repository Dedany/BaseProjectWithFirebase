package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthRemoteDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRemoteDataSource {

    override suspend fun login(loginDto: LoginDto): LoginDto {
        return suspendCoroutine { result ->
            auth.signInWithEmailAndPassword(loginDto.user, loginDto.password)
                .addOnCompleteListener { authResult ->
                    result.resume(LoginDto("", "", authResult.result?.user?.uid))
                }
        }
    }

    override fun logout(): Boolean {
        auth.signOut()
        return true
    }

    override suspend fun register(dto: UserDto): Pair<Boolean, String> {
        val uuid = createAuthUser(dto.email, dto.password)
        val isRegisterSucces = createDatabaseUser(uuid, dto)

        return Pair(isRegisterSucces, uuid)


    }

    private suspend fun createAuthUser(email: String, password: String): String {
        return suspendCoroutine { result ->
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result.resume(task.result?.user?.uid ?: "")
                }
            }.addOnFailureListener {
                result.resume("")

            }
        }
    }

    private suspend fun createDatabaseUser(uuid: String, obj: UserDto): Boolean {
        val dto = hashMapOf(
            "uuid" to uuid,
            "name" to obj.name,
            "email" to obj.email,
            "age" to obj.age,
            "country" to obj.country,
            "password" to obj.password,
            "isAdmin" to obj.isAdmin,
            "registeredAt" to obj.registeredAt
        )

        return suspendCoroutine { result ->
            firestore.collection("users").document(uuid).set(dto)
                .addOnSuccessListener {
                    result.resume(true)
                }.addOnFailureListener {
                    result.resume(false)
                }
        }
    }
}
