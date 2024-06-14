package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val title: String,
    //val path: String,
    val image: String,
    // 0 - 100
    val percentageWatched: Int = 0,
    val key: String,
    val enabled: Int = -1,
    val total: Int  = -1
)



