package se.android.blibb.presentation.screen.explore.profile


data class Education(
    val degree: String = "",
    val institution: String = "",
    val year: String = ""
)

data class Experience(
    val title: String = "",
    val company: String = "",
    val period: String = "",
    val description: String = ""
)

data class Project(
    val title: String = "",
    val description: String = "",
    val image: String? = null
)
