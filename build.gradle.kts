// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}

//añadimos la dependencia de hilt para la construcción del proyecto
buildscript {
    dependencies {
        val hiltVersion = "2.48.1" // Reemplazar con la versión más reciente
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}

/*ahora a nivel de aplicación añadiremos el compilador de Kotlin para que pueda trabajar
correctamente con la versión que hemos declarado.
No se donde va esto

composeOptions {
kotlinCompilerExtensionVersion = "1.5.4"
}
También vamos a necesitar añadir los plugins a nivel de aplicación.
plugins {
id("com.android.application")
id("org.jetbrains.kotlin.android")
id("com.google.devtools.ksp")
}
Finalmente las dependencias a este nivel de hilt, tanto su compilador como la librería
val hiltVersion = "2.48.1" // Asegúrate de que esta es la versión correcta

*/

