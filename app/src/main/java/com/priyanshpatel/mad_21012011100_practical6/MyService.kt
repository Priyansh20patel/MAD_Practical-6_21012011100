package com.priyanshpatel.mad_21012011100_practical6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {

    companion object {
        val PLAYERCONSTANT = "PLAY/PAUSE"
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    lateinit var player : MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (!this::player.isInitialized) {
            player = MediaPlayer.create(this,R.raw.danza)
        }

        if (intent != null) {
            val command = intent.getStringExtra(PLAYERCONSTANT)

            if (!player.isPlaying) {
                player.start()
            }
            else {
                player.pause()
            }
        }

        else {
            player.stop()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }
}