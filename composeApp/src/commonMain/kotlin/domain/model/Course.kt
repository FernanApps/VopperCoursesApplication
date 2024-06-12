package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val title: String,
    val path: String,
    val image: String
)

@Serializable
data class Chapter(
    val title: String,
    val link: String,
)

