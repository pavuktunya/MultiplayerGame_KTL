import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(Dependencies.Spring.websocket)
	implementation(Dependencies.Spring.kotlin_reflect)
	testImplementation(Dependencies.Spring.testImpl)

	implementation(Dependencies.GDX.gdx)
	implementation(Dependencies.GDX.backend_headless)
	implementation(Dependencies.GDX.platform_desktop)

	implementation(Dependencies.GDX.ashley)
	implementation(Dependencies.KTX.fleks)

	Dependencies.KTX.ktx.forEach {
		implementation(it)
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
