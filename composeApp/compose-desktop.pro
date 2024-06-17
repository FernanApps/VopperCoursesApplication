# TODO: Workaround to solve https://github.com/JetBrains/compose-multiplatform/issues/4883
-dontwarn androidx.compose.material.**
-keep class androidx.compose.material3.** { *; }
-ignorewarnings

-keep class android.os.Looper {
    *;
}


# Keep the Screens class and its members
-keep class presentation.Screens {
    *;
}

# Koin rules
-keepattributes *Annotation*
-keep class * implements org.koin.core.module.Module { *; }
-keep class * extends org.koin.core.component.KoinComponent { *; }
-keep class * implements org.koin.core.component.KoinComponent { *; }
-keep class org.koin.** { *; }
-dontwarn org.koin.**

# ViewModel rules
-keep class * extends androidx.lifecycle.ViewModel { *; }
-keepclassmembers class **.ViewModel { *; }
-keepclassmembers class **.ViewModelFactory { *; }

# Keep specific ViewModel
-keep class presentation.screens.CoursesViewModel { *; }

# Room rules
-keep class androidx.room.** { *; }
-keep class * extends androidx.room.RoomDatabase { *; }
-keep @androidx.room.Database class * { *; }
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }
-keep class * extends androidx.room.RoomDatabase {
    public static **_Impl create(...);
}

# Use case rules
-keep class domain.use_cases.** { *; }
-keep class data.local.** { *; }
-keepclassmembers class domain.use_cases.** {
    public <init>(...);
}

# Kotlinx Coroutines rules
-keep class kotlinx.coroutines.** { *; }
-keepclassmembers class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.coroutines.**

# Preserve all native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Preserve all classes using JNI (Java Native Interface)
-keep class **.R {
    <fields>;
}
-keep class **.R$* {
    <fields>;
}

# Preserve all classes with annotations
-keepattributes *Annotation*

# Preserve Compose classes
-keep class androidx.compose.animation.** { *; }
-keep class androidx.compose.runtime.** { *; }
-keep class androidx.compose.ui.** { *; }
-keep class androidx.compose.foundation.** { *; }
-keep class androidx.compose.material.** { *; }

# Prevent warnings about missing classes
-dontwarn androidx.compose.**
-dontwarn androidx.room.**

-keep class uk.co.caprica.vlcj.** { *; }
-keep interface uk.co.caprica.vlcj.** { *; }
-keep enum uk.co.caprica.vlcj.** { *; }

-keepnames class * implements uk.co.caprica.vlcj.factory.discovery.provider.DiscoveryDirectoryProvider
-keepnames class uk.co.caprica.vlcj.factory.discovery.provider.**

-keep class com.sun.jna.** { *; }
-keepclassmembers class * extends com.sun.jna.** {
    <methods>;
}


# General rules to avoid issues
-ignorewarnings