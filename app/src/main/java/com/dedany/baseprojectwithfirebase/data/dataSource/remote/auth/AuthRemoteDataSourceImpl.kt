package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class AuthRemoteDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRemoteDataSource {
    override suspend fun login(loginDto: LoginDto): LoginDto {
        return suspendCoroutine { result ->
            auth.signInWithEmailAndPassword(loginDto.user, loginDto.password).addOnCompleteListener {

            }
        }
    }

    override fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override fun register(userDto: UserDto): UserDto {
        TODO("Not yet implemented")
    }
}