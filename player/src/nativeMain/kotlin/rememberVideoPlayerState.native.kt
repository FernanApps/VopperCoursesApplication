import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import data.local.WatchDatabaseInit
import data.local.WatchProgressRepository
import data.local.getRoomDatabase
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.play
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.UIKit.UIView
import platform.QuartzCore.kCATransactionDisableActions

/*
@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {
    val repository = remember {
        WatchProgressRepository(getRoomDatabase(WatchDatabaseInit().getDatabaseBuilder()))
    }
    TODO("Not yet implemented")
}
*/



/*
@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {
    val repository = remember {
        WatchProgressRepository(getRoomDatabase(WatchDatabaseInit().getDatabaseBuilder()))
    }
    return remember {
        val player = XVideoPlayer()
        VideoPlayerState(
            player = player,
            content = {
                VideoPlayer2(it, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            },
            repository
        )
    }

}
*/

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {
    return rememberVideoPlayerState2()
}

@OptIn(ExperimentalForeignApi::class)
@Composable
fun VideoPlayer2(modifier: Modifier, url: String) {
    val player = remember { AVPlayer(uRL = NSURL.URLWithString(url)!!) }
    val playerLayer = remember { AVPlayerLayer() }
    val avPlayerViewController = remember { AVPlayerViewController() }
    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = true

    playerLayer.player = player
    // Use a UIKitView to integrate with your existing UIKit views
    UIKitView(
        factory = {
            // Create a UIView to hold the AVPlayerLayer
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            // Return the playerContainer as the root UIView
            playerContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            playerLayer.setFrame(rect)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()
        },
        update = { view ->
            player.play()
            avPlayerViewController.player!!.play()
        },
        modifier = modifier)
}


@OptIn(ExperimentalForeignApi::class)
@Composable
fun rememberVideoPlayerState2(): VideoPlayerState {
    val repository = remember {
        WatchProgressRepository(getRoomDatabase(WatchDatabaseInit().getDatabaseBuilder()))
    }
    return remember {
        val player = XVideoPlayer()
        VideoPlayerState(
            player = player,
            content = {
                val avPlayerViewController = remember { AVPlayerViewController() }
                avPlayerViewController.player = player.player

                UIKitView(
                    factory = {
                        val playerContainer = UIView()
                        playerContainer.addSubview(avPlayerViewController.view)
                        playerContainer
                    },
                    onResize = { view: UIView, rect: CValue<CGRect> ->
                        CATransaction.begin()
                        CATransaction.setValue(true, kCATransactionDisableActions)
                        view.layer.setFrame(rect)
                        avPlayerViewController.view.layer.frame = rect
                        CATransaction.commit()
                    },
                    update = { /* No necesitas hacer nada específico de actualización aquí */ },
                    modifier = it
                )
            },
            repository = repository
        )
    }
}