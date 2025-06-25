# EmojiPickerApp

A fast and lightweight Jetpack Compose emoji picker with:

- Emoji search
- Category filtering
- Grid layout
- Built-in emoji JSON parsed from Unicode `emoji-test.txt`

---

## Demo

[Screen_recording_20250625_224352.webm](https://github.com/user-attachments/assets/882a6912-50c6-4330-aa3e-07df3f1ee475)


---

## How it works

- Unicode’s [emoji-test.txt](https://unicode.org/Public/emoji/15.1/emoji-test.txt) is downloaded and parsed at build time via a Gradle task
- Resulting JSON (`emojis.json`) is placed in `assets/` and loaded with `EmojiLoader`
- UI is built with Compose using `LazyVerticalGrid`

---

## Getting Started

```bash
git clone https://github.com/yourusername/EmojiPickerApp
cd EmojiPickerApp
./gradlew updateEmojis

