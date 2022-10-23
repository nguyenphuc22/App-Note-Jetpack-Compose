package com.phucvr.appnotejetpackcompose

import android.app.Application
import com.phucvr.appnotejetpackcompose.dependencyinjection.DependencyInjector

class NotesApplication : Application() {

    lateinit var dependencyInjector: DependencyInjector

    override fun onCreate() {
        super.onCreate()
        initDependencyInjector()
    }

    private fun initDependencyInjector() {
        dependencyInjector = DependencyInjector(this)
    }
}