import org.gradle.internal.extensions.stdlib.toDefaultLowerCase
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URI
import java.net.URL

plugins {
	id("maven-publish")
	id("fabric-loom") version "1.9.2"
	id("babric-loom-extension") version "1.9.3"
}

//noinspection GroovyUnusedAssignment
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

base.archivesName = project.properties["archives_base_name"] as String
version = project.properties["mod_version"] as String
group = project.properties["maven_group"] as String

loom {
//	accessWidenerPath = file("src/main/resources/examplemod.accesswidener")

	runs {
		// If you want to make a testmod for your mod, right click on src, and create a new folder with the same name as source() below.
		// Intellij should give suggestions for testmod folders.
		register("testClient") {
			source("test")
			client()
			configurations.transitiveImplementation
		}
		register("testServer") {
			source("test")
			server()
			configurations.transitiveImplementation
		}
	}
}

repositories {
	maven("https://maven.glass-launcher.net/snapshots/")
	maven("https://maven.glass-launcher.net/releases/")
	maven("https://maven.glass-launcher.net/babric")
	maven("https://maven.minecraftforge.net/")
	maven("https://jitpack.io/")
	mavenCentral()
	exclusiveContent {
		forRepository {
			maven("https://api.modrinth.com/maven")
		}
		filter {
			includeGroup("maven.modrinth")
		}
	}
}

dependencies {
	minecraft("com.mojang:minecraft:b1.7.3")
	mappings("net.glasslauncher:biny:b1.7.3+4cbd9c8:v2")
	modImplementation("babric:fabric-loader:${project.properties["loader_version"]}")

	implementation("org.apache.logging.log4j:log4j-core:2.17.2")

	implementation("org.slf4j:slf4j-api:1.8.0-beta4")
	implementation("org.apache.logging.log4j:log4j-slf4j18-impl:2.17.1")

	// convenience stuff
	// adds some useful annotations for data classes. does not add any dependencies
	compileOnly("org.projectlombok:lombok:1.18.24")
	annotationProcessor("org.projectlombok:lombok:1.18.24")

	// adds some useful annotations for miscellaneous uses. does not add any dependencies, though people without the lib will be missing some useful context hints.
	implementation("org.jetbrains:annotations:23.0.0")
	implementation("com.google.guava:guava:33.2.1-jre")

	// StAPI itself.
	// transitiveImplementation tells babric loom that you want this dependency to be pulled into other mod's development workspaces. Best used ONLY for required dependencies.
	//modImplementation("net.modificationstation:StationAPI:${project.properties["stationapi_version"]}")

	// Extra mods.
	// https://github.com/calmilamsy/glass-config-api
	//modImplementation("net.glasslauncher.mods:GlassConfigAPI:${project.properties["gcapi_version"]}")
	// https://github.com/calmilamsy/modmenu
	//modImplementation("net.glasslauncher.mods:ModMenu:${project.properties["modmenu_version"]}")
	// https://github.com/Glass-Series/Always-More-Items
	//modImplementation("net.glasslauncher.mods:AlwaysMoreItems:${project.properties["alwaysmoreitems_version"]}")
}

tasks.withType<ProcessResources> {
	inputs.property("version", project.properties["version"])

	filesMatching("fabric.mod.json") {
		expand(mapOf("version" to project.properties["version"]))
	}
}

// ensure that the encoding is set to UTF-8, no matter what the system default is
// this fixes some edge cases with special characters not displaying correctly
// see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

java {
	// Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
	// if it is present.
	// If you remove this line, sources will not be generated.
	withSourcesJar()
}

tasks.withType<Jar> {
	from("LICENSE") {
		rename { "${it}_${project.properties["archivesBaseName"]}" }
	}
}

publishing {
	repositories {
		mavenLocal()
		if (project.hasProperty("my_maven_username")) {
			maven {
				url = URI("https://maven.example.com")
				credentials {
					username = "${project.properties["my_maven_username"]}"
					password = "${project.properties["my_maven_password"]}"
				}
			}
		}
	}

	publications {
		register("mavenJava", MavenPublication::class) {
			artifactId = project.properties["archives_base_name"] as String
			from(components["java"])
		}
	}
}

tasks.register("setupMod") {
	// If this still exists after setup, everything after the line above should be removed. It won't work again after you've run it once.
	group = "_setup"

	doLast {
		val propsFile = File("gradle.properties")
		val propsFileContent = propsFile.readText()

		if (!propsFileContent.contains("%s")) {
			error("You have already run setup. This task should've been removed.")
		}

		println("Grabbing latest BINY version.")
		val binyVersion = URL("https://maven.glass-launcher.net/releases/net/glasslauncher/biny/maven-metadata.xml").readText().split("<latest>")[1].split("</latest>")[0]
		println("Found BINY version: $binyVersion")

		println("Grabbing latest StationAPI version.")
		val stapiVersion =
			URL("https://maven.glass-launcher.net/releases/net/modificationstation/StationAPI/maven-metadata.xml").readText().split("<latest>")[1].split("</latest>")[0]
		println("Found StationAPI version: $stapiVersion")

		println("Grabbing latest Glass Networking version.")
		val gnVersion =
			URL("https://maven.glass-launcher.net/releases/net/glasslauncher/mods/glass-networking/maven-metadata.xml").readText().split("<latest>")[1].split("</latest>")[0]
		println("Found Glass Networking version: $gnVersion")

		println("Grabbing latest Glass Config API version.")
		val gcapiVersion =
			URL("https://maven.glass-launcher.net/releases/net/glasslauncher/mods/GlassConfigAPI/maven-metadata.xml").readText().split("<latest>")[1].split("</latest>")[0]
		println("Found GCAPI version: $gcapiVersion")

		println("Grabbing latest ModMenu version.")
		val mmVersion =
			URL("https://maven.glass-launcher.net/releases/net/glasslauncher/mods/ModMenu/maven-metadata.xml").readText().split("<latest>")[1].split("</latest>")[0]
		println("Found ModMenu version: $mmVersion")

		println("Grabbing latest Always More Items version.")
		val amiVersion =
			URL("https://maven.glass-launcher.net/releases/net/glasslauncher/mods/AlwaysMoreItems/maven-metadata.xml").readText().split("<latest>")[1].split("</latest>")[0]
		println("Found AMI version: $amiVersion")

		println("Mod archive name: (This should ideally be snake_case, decides your maven name)")
		val modArchiveName = readInput()

		println("Maven group: (This usually a domain you control, or io.github.yourname)")
		val mavenGroup = readInput()

		val suggestedID = modArchiveName.replace("_", "").toDefaultLowerCase()
		println("Mod ID: (This has to be lowercase, and must only contain alphanumeric chars) [leave blank to use $suggestedID]")
		var modID = readInput()
		if (modID.isEmpty()) {
			modID = suggestedID
		}
		while ("$[a-z0-9]*^".toRegex().matches(modID)) {
			println("Invalid mod ID.")
			modID = readInput()
			if (modID.isEmpty()) {
				modID = suggestedID
			}
		}
		propsFile.writeText(propsFileContent.format(binyVersion, modID, mavenGroup, modArchiveName, stapiVersion, gcapiVersion, gnVersion, amiVersion, mmVersion))

		val projectDir = File(projectDir, "src/main")

		// Move project code
		val codeDir = projectDir.cd("java")
		val glassCode = codeDir.cd("net/glasslauncher")
		var code = glassCode.cd("example/events/init/InitListener.java")
		code.writeText(code.readText().replaceFirst("net.glasslauncher.example", "${mavenGroup}.$modID"))
		code = glassCode.cd("example/mixin/ExampleMixin.java")
		code.writeText(code.readText().replaceFirst("net.glasslauncher.example", "${mavenGroup}.$modID"))
		val modCode = codeDir.cd(mavenGroup.replace(".", "/"))
		modCode.mkdirs()
		glassCode.delete()
		glassCode.parentFile.delete()
		glassCode.cd("example").renameTo(modCode.cd(modID))

		// Deal with mixins json
		val mixinsJson = projectDir.cd("resources/examplemod.mixins.json")
		mixinsJson.writeText(mixinsJson.readText().format("${mavenGroup}.$modID"))
		mixinsJson.renameTo(projectDir.cd("resources/${modID}.mixins.json"))

		// Rename assets folder
		val assets = projectDir.cd("resources/assets/examplemod")
		val langFile = assets.cd("stationapi/lang/en_US.lang")
		langFile.writeText(langFile.readText().format(modID))
		assets.renameTo(projectDir.cd("resources/assets/$modID"))

		// Fill out the fabric mod json
		val modJson = projectDir.cd("resources/fabric.mod.json")
		modJson.writeText(modJson.readText().format(modID, modID, "${mavenGroup}.$modID", modID))

		// Replace the hardcoded mappings string with the one in the properties file
		buildFile.writeText(buildFile.readText().replace("b1.7.3+4cbd9c8", "\${project.properties[\"yarn_mappings\"]}"))

		// And finally yeet ourself into the void
		val buildFile = project.projectDir.cd("build.gradle.kts")
		buildFile.writeText(buildFile.readText().split("tasks.register(\"setupMod\")")[0].replace("//modImplementation(", "modImplementation("))

		println("Setup complete! Reload your gradle project, and everything *should* work.")
	}
}

fun File.cd(subDir: String): File {
	return File(this, subDir)
}

fun readInput(): String {
	return BufferedReader(InputStreamReader(System.`in`)).readLine()
}
