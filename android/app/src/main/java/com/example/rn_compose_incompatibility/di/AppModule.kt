// File: app/src/main/java/com/example/rn_compose_incompatibility/di/AppModule.kt
package com.example.rn_compose_incompatibility.di

import android.content.Context
import com.example.rn_compose_incompatibility.react_bridge.ReactInstanceManagerAccess
import com.facebook.react.PackageList
import com.facebook.react.ReactPackage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideReactInstanceManagerAccess(
        @ApplicationContext context: Context,
        packageList: @JvmSuppressWildcards List<ReactPackage>
    ): ReactInstanceManagerAccess {
        return ReactInstanceManagerAccess(context, packageList)
    }

    @Provides
    fun providePackageList(@ApplicationContext context: Context): List<ReactPackage> {
        val application = context.applicationContext as android.app.Application
        return PackageList(application).packages
    }
}