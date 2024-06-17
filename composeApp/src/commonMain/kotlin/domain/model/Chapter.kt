package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Chapter(
    val index: Int,
    val link: String,
    val soon: Boolean = false,
    // 0 - 100
    val percentageWatched: Int = 0,
){
    val progress get() = if(percentageWatched == 0) 0f else percentageWatched / 100f
}
