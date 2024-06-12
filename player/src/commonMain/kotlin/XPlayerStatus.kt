sealed interface XPlayerStatus {
    data object Idle : XPlayerStatus
    data object Preparing : XPlayerStatus
    data object Ready : XPlayerStatus
    data object Buffering : XPlayerStatus
    data object Playing : XPlayerStatus
    data object Paused : XPlayerStatus
    data object Ended : XPlayerStatus
    data class Error(val error: Throwable) : XPlayerStatus
    data object Released : XPlayerStatus
}