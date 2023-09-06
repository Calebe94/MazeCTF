#!/usr/bin/env sh

javac -cp . -d bin \
CaptureTheFlags/src/mazectf/*.java \
CaptureTheFlags/src/mazectf/ui/*.java \
CaptureTheFlags/src/mazectf/states/*.java \
CaptureTheFlags/src/mazectf/worlds/*.java \
CaptureTheFlags/src/mazectf/utils/*.java \
CaptureTheFlags/src/mazectf/entities/*.java \
CaptureTheFlags/src/mazectf/entities/statics/*.java \
CaptureTheFlags/src/mazectf/entities/creatures/*.java \
CaptureTheFlags/src/mazectf/gfx/*.java \
CaptureTheFlags/src/mazectf/input/*.java \
CaptureTheFlags/src/mazectf/display/*.java \
CaptureTheFlags/src/mazectf/tiles/*.java

# java -cp bin:CaptureTheFlags/res mazectf.Launcher

# jar cfm MazeCTF.jar Manifest.txt -C bin . -C bin .

jar cfm MazeCTF.jar Manifest.txt -C bin . -C CaptureTheFlags .
# jar cfm MazeCTF.jar Manifest.txt -C bin . -C bin/textures .
