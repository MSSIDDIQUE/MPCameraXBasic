package com.android.example.cameraxbasic

import android.app.Application
import android.content.Context
import com.android.example.cameraxbasic.data.Repository
import com.android.example.cameraxbasic.data.network.FirestoreSource
import com.android.example.cameraxbasic.viewmodels.PicsViewModel
import com.android.example.cameraxbasic.viewmodels.PicsViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CameraApplication(): Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@CameraApplication))
        bind() from singleton { FirestoreSource() }
        bind() from singleton { Repository(instance()) }
        bind() from singleton { PicsViewModelFactory(instance()) }
    }

}