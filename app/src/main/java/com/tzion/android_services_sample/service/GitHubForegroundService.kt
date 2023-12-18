package com.tzion.android_services_sample.service

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.tzion.android_services_sample.R
import com.tzion.android_services_sample.network.GitHubRetrofit
import com.tzion.android_services_sample.network.GitHubRetrofitFactory
import com.tzion.android_services_sample.network.SearchRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val NOTIFICATION_ID = 100

class GitHubForegroundService : Service() {
    private val searchRepositories = SearchRepositories(
        gitHubRetrofit = GitHubRetrofitFactory.createGitHubRetrofitImpl(GitHubRetrofit::class.java)
    )
    private val notificationBuilder = NotificationCompat.Builder(this, "running_channel")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Searching...")
        .setContentText("Searching GitHub repositories that match with Android")

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.name -> startForeground()
            Actions.STOP.name -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForeground() {
        startForeground(NOTIFICATION_ID, notificationBuilder.build())
        searchRepositories()
    }

    private fun searchRepositories() = runBlocking {
        val query = "Android"
        updateNotification()
        launch(Dispatchers.IO) {
            val repositories = searchRepositories.getSearchRepositories(query = query)
            updateNotification(contentText = "${repositories.items.count()} repositories where found with word $query")
        }
    }

    private fun updateNotification(contentText: String? = null) {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED) {
            NotificationManagerCompat.from(this).apply {
                if (contentText == null) {
                    notificationBuilder.setProgress(0, 0, true)
                    notify(NOTIFICATION_ID, notificationBuilder.build())
                } else {
                    notificationBuilder
                        .setContentTitle("Done!")
                        .setContentText(contentText)
                        .setProgress(0, 0, false)
                    notify(NOTIFICATION_ID, notificationBuilder.build())
                }

            }
        }
    }

    enum class Actions {
        START, STOP
    }
}