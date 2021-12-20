package cat.balrog.watchme

import android.app.Activity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class VideoPlayerActivity : Activity()
{
    lateinit var playerView: StyledPlayerView
    lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playerView = StyledPlayerView(this)
        setContentView(playerView)

        player = ExoPlayer.Builder(this).build()
        playerView.requestFocus()
        playerView.useController = false
        playerView.player = player

        player.addMediaItem(MediaItem.fromUri("asset:///video.mp4"))
        player.playWhenReady = true
        player.prepare()
    }

    override fun onResume() {
        super.onResume()
        player.play()
    }

    override fun onPause() {
        super.onPause()
        player.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}