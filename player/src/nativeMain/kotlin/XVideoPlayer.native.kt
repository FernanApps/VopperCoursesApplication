import kotlinx.coroutines.flow.Flow

public actual class XVideoPlayer {
    actual val status: Flow<XPlayerStatus>
        get() = TODO("Not yet implemented")
    actual val volume: Flow<Float>
        get() = TODO("Not yet implemented")
    actual val isMute: Flow<Boolean>
        get() = TODO("Not yet implemented")
    actual val currentTime: Flow<Long>
        get() = TODO("Not yet implemented")
    actual val duration: Flow<Long>
        get() = TODO("Not yet implemented")
    actual val isRepeated: Flow<Boolean>
        get() = TODO("Not yet implemented")

    actual fun prepare(dataSource: Any, playWhenReady: Boolean) {
    }

    actual fun play() {
    }

    actual fun pause() {
    }

    actual fun stop() {
    }

    actual fun release() {
    }

    actual fun seekTo(position: Long) {
    }

    actual fun setMute(mute: Boolean) {
    }

    actual fun setVolume(volume: Float) {
    }

    actual fun setRepeat(isRepeat: Boolean) {
    }
}