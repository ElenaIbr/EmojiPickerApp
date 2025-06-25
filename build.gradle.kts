// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

tasks.register("updateEmojis") {
    group = "emoji-tools"
    description = "Downloads emoji-test.txt, generates emojis.json and copies it to assets."

    val scriptDir = "$rootDir/scripts"
    val emojiTxt = "$scriptDir/emoji-test.txt"
    val jsonOut = "$scriptDir/emojis.json"
    val assetsDir = "$rootDir/app/src/main/assets"

    doLast {
        println("Downloading emoji-test.txt...")
        exec {
            commandLine("curl", "-s", "-o", emojiTxt, "https://unicode.org/Public/emoji/15.1/emoji-test.txt")
        }

        println("Generating emojis.json using Python...")
        exec {
            commandLine("python3", "$scriptDir/generate_emoji_json.py")
        }

        println("📂 Copying JSON to $assetsDir...")
        copy {
            from(jsonOut)
            into(assetsDir)
        }

        println("Done: emojis.json has been updated.")
    }
}
