    object TimeUtils {
        fun getStringForTime(timeMs: Long): String {
            var timeMs = timeMs
            if (timeMs == Long.MIN_VALUE + 1) {
                timeMs = 0
            }
            val totalSeconds = (timeMs + 500) / 1000
            val seconds = totalSeconds % 60
            val minutes = totalSeconds / 60 % 60
            val hours = totalSeconds / 3600

            return if (hours > 0) {
                "${hours}:${minutes.padZero()}:${seconds.padZero()}"
            } else {
                "${minutes.padZero()}:${seconds.padZero()}"
            }
        }

        private fun Long.padZero(): String = this.toString().padStart(2, '0')
    }