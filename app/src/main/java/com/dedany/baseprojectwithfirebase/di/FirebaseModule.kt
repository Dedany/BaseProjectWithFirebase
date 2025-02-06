package com.dedany.baseprojectwithfirebase.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import dagger.Provides
import javax.inject.Singleton


object FirebaseModule {

    @Provides
    @Singleton
    fun provideFireBaseAuthentication(): FirebaseAuth {
        return Firebase.auth

    }

    @Provides
    @Singleton
    fun provideFireBaseFireStore(): FirebaseStorage {
        return Firebase.firestore
    }
}