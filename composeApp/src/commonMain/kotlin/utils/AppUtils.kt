package utils


class Application(val name: String, val information: String, val openUrl: String)

internal val mandatoryAppsInMacOs = listOf(
    Application(
        name = "vlc",
        information = "Please install Vlc application for player",
        openUrl = "https://www.videolan.org/vlc/"
    )
)

expect suspend fun checkAppInstalls(): Application?
