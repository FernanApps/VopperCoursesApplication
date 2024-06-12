/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package presentation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.bundle.Bundle
import io.ktor.util.decodeBase64String
import io.ktor.util.encodeBase64
import org.jetbrains.compose.resources.StringResource
import presentation.theme.HomeFilledRounded
import presentation.theme.HomeOutlineRounded
import presentation.theme.PersonFilledRounded
import presentation.theme.PersonOutlineRounded
import presentation.theme.SettingsFilledRounded
import presentation.theme.SettingsOutlineRounded
import utils.kase64.base64UrlDecoded
import utils.kase64.base64UrlEncoded
import utils.toJson
import utils.toModel
import voppercourses.composeapp.generated.resources.Res
import voppercourses.composeapp.generated.resources.courses
import voppercourses.composeapp.generated.resources.profile
import voppercourses.composeapp.generated.resources.settings


internal val bottomNavItems = listOf(Screens.Courses, Screens.Profile, Screens.Setting)

const val courseBundleKey = "courseBundleKey"
const val videoUrlBundleKey = "videoUrlBundleKey"

enum class Screens(
    private val args: List<String>? = null,
    val title: StringResource? = null,
    val isTabItem: Boolean = false,
    val unselectedIcon: ImageVector? = null,
    val selectedIcon: ImageVector? = null,
) {
    Splash,
    Courses(title = Res.string.courses, selectedIcon = Icons.HomeFilledRounded, unselectedIcon = Icons.HomeOutlineRounded),
    Profile(title = Res.string.profile, selectedIcon = Icons.PersonFilledRounded, unselectedIcon = Icons.PersonOutlineRounded),
    Setting(title = Res.string.settings, selectedIcon = Icons.SettingsFilledRounded, unselectedIcon = Icons.SettingsOutlineRounded),

    CourseDetails(args = listOf(courseBundleKey)),
    Player(args = listOf(videoUrlBundleKey)),


    /*
     <string name="courses">Courses</string>
    <string name="profile">Profile</string>
    <string name="settings">Settings</string>
     */

    //Home(title = Strings.home, isTabItem = true, selectedIcon = Icons.Default.Home, unselectedIcon = Icons.Outlined.Home),
    //Search(title = Strings.explore, isTabItem = true, selectedIcon = Icons.Default.Search, unselectedIcon = Icons.Outlined.Search),
    //Settings(title = Strings.settings, isTabItem = true, selectedIcon = Icons.Default.Settings, unselectedIcon = Icons.Outlined.Settings),

    ;

    operator fun invoke(): String {
        val argList = StringBuilder()
        args?.let { nnArgs ->
            nnArgs.forEach { arg -> argList.append("/{$arg}") }
        }
        return name + argList
    }



    fun withArgs(vararg args: Any): String {
        val destination = StringBuilder()
        args.forEach { arg ->
            destination.append("/$arg")
        }
        return name + destination
    }
    inline fun <reified T: Any> withObject(model: T) = withArgs(_pass<T>(model))
    fun withArgsSafe(vararg arg: String) = withArgs(*_passSafe(*arg))
    //inline fun <reified T: Any> withObject(key: String, model: T) = withArgs(key, _pass<T>(model))

    inline fun <reified T> _pass(object1: T) = object1.toJson().encodeBase64()
    fun _passSafe(vararg arg: String) = arg.map {  it.base64UrlEncoded }.toTypedArray()



    inline fun <reified T> getObject(key: String, bundle: Bundle?) =
        bundle!!.getString(key)!!.decodeBase64String().toModel<T>()

    fun getData(key: String, bundle: Bundle?) =
        bundle!!.getString(key)!!

    fun getDataSafe(key: String, bundle: Bundle?) =
        getData(key, bundle).base64UrlDecoded



}

