object Dependencies {
    object Spring{
        const val websocket = "org.springframework.boot:spring-boot-starter-websocket"
        const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect"
        const val testImpl = "org.springframework.boot:spring-boot-starter-test"
    }
    object GDX{
        private const val versionGdx = "1.10.0"

        const val gdx = "com.badlogicgames.gdx:gdx:$versionGdx"

        const val backend_headless = "com.badlogicgames.gdx:gdx-backend-headless:$versionGdx"
        //необходима для бека

        const val platform_desktop = "com.badlogicgames.gdx:gdx-platform:$versionGdx:natives-desktop"
        //нативная обертка для headless

        const val ashley = "com.badlogicgames.ashley:ashley:1.7.4"
    }
    object KTX{
        private const val fleksVersion = "1.3-JVM"
        private const val ktxVersion = "1.12.1-rc1"

        const val fleks = "io.github.quillraven.fleks:Fleks:$fleksVersion"

        val ktx = listOf(
                "io.github.libktx:ktx-actors:$ktxVersion",
                "io.github.libktx:ktx-ai:$ktxVersion",
                "io.github.libktx:ktx-app:$ktxVersion",
                "io.github.libktx:ktx-ashley:$ktxVersion",
                "io.github.libktx:ktx-assets:$ktxVersion",
                "io.github.libktx:ktx-box2d:$ktxVersion",
                "io.github.libktx:ktx-collections:$ktxVersion",
                "io.github.libktx:ktx-json:$ktxVersion",
                "io.github.libktx:ktx-log:$ktxVersion",
                "io.github.libktx:ktx-math:$ktxVersion",
                "io.github.libktx:ktx-scene2d:$ktxVersion",
                "io.github.libktx:ktx-tiled:$ktxVersion"
        )
    }
}