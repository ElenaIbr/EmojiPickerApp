import json
import re

def parse_emoji_test(file_path):
    emojis = []
    group = ""
    subgroup = ""

    with open(file_path, "r", encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line.startswith("# group:"):
                group = line.replace("# group: ", "")
            elif line.startswith("# subgroup:"):
                subgroup = line.replace("# subgroup: ", "")
            elif re.match(r".*; fully-qualified.*# .*", line):
                parts = line.split("#")
                emoji_char = parts[1].strip().split(" ")[0]
                description = " ".join(parts[1].strip().split(" ")[1:])
                emojis.append({
                    "emoji": emoji_char,
                    "description": description,
                    "group": group,
                    "subcategory": subgroup
                })
    return emojis

if __name__ == "__main__":
    input_file = "scripts/emoji-test.txt"
    output_file = "scripts/emojis.json"

    emojis = parse_emoji_test(input_file)
    with open(output_file, "w", encoding="utf-8") as f:
        json.dump(emojis, f, ensure_ascii=False, indent=2)

    print(f"✅ Saved {len(emojis)} emojis to {output_file}")