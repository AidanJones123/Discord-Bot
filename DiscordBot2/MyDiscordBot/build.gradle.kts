plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.1.2" //id for plugin creating fat jar file
}

application.mainClass = "com.example.discordbot.Bot"
group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.24")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true

    sourceCompatibility = "1.8"
}