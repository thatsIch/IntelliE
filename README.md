# IntelliE

## Table of Content

* [About](#about)
* [Contacts](#contacts)
* [License](#license)
* [Downloads](#downloads)
* [Installation](#installation)
* [Building](#building)
* [Contribution](#contribution)
* [Credits](#credits)

## About

IntelliE is an abbreviation for IntelligentEnergistics. It is a [Forge](http://minecraftforge.net)-mod and an addon for [AppliedEnergistics 2](http://minecraft.curseforge.com/mc-mods/223794-applied-energistics-2) for the game [Minecraft](https://minecraft.net/). It is currently split into 3 main child mods.
 
* **Applied Aerodynamics (WIP)** adds armor and tools for builders. 
* **Applied Agricultures (N/A)** adds some form of automatic farming.
* **Applied Intelligences (N/A)** adds crafting leverage.

## Contacts

I am a regular in [#AppliedEnergistics](http://webchat.esper.net/?channels=appliedenergistics&prompt=0) on Espernet. You can either directly speak with me there or send me a public message through [GitHub](https://github.com/thatsIch/IntelliE-Scala/issues/new) or a private message on [CurseForge](http://minecraft.curseforge.com/private-messages/send?recipient=thatsIch).

## License

[Creative Commons NonCommerical ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/)
> **You are free to:**
> 
> * **Share** — copy and redistribute the material in any medium or format 
> * **Adapt** — remix, transform, and build upon the material 
> 
> The licensor cannot revoke these freedoms as long as you follow the license terms.
>
> **Under the following terms:**
>
> * **Attribution** — You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.
> * **NonCommercial** — You may not use the material for commercial purposes. 
> * **ShareAlike** — If you remix, transform, or build upon the material, you must distribute your contributions under the same license as the original. 
>
> **No additional restrictions** — You may not apply legal terms or technological measures that legally restrict others from doing anything the license permits. 

## Downloads

Downloads can be found on [CurseForge](http://minecraft.curseforge.com/mc-mods/222848-intelligent-energistics).

## Installation

You install this mod by putting it into the `minecraft/mods/` folder. It requires a valid AppliedEnergistics 2 installed.

## Building

1. Clone this repository via 
  - SSH `git clone --recursive git@github.com:thatsIch/IntelliE-Scala.git` or 
  - HTTPS `git clone --recursive https://github.com/thatsIch/IntelliE-Scala.git`
  - Note the `--recursive` option. This enables to automatically clones of all submodules. IntelliE uses the [AE2-API](https://github.com/AlgorithmX2/Applied-Energistics-2-API) repository.
2. Setup workspace 
  - Decompiled source `gradlew setupDecompWorkspace`
  - Obfuscated source `gradlew setupDevWorkspace`
  - CI server `gradlew setupCIWorkspace`
3. (Import into IDE)
4. (Generate run for IntelliJ `gradlew genIntellijRuns`
5. Build `gradlew build`. Jar will be in `.gradle/libs`

## Contribution

Before you want to add major changes, you might want to discuss them with me first, before wasting your time.
If you are still willing to contribute to this project, you can contribute via [Pull-Request](https://help.github.com/articles/creating-a-pull-request).

1. Fork this repository
2. Clone the fork via
  * SSH `git clone git@github.com:<your username>/IntelliE-Scala.git` or 
  * HTTPS `git clone https://github.com/<your username>/IntelliE-Scala.git`
3. Change code base
4. Add changes to git `git add -A`
5. Commit changes to your clone `git commit -m "<made changes>"`
6. Push to your fork `git push`
7. Create a Pull-Request on GitHub

If you are only doing single file pull requests, GitHub supports using a quick way without the need of cloning your fork.

## Credits

Thanks to
 
* IDEA making an awesome IDE
* Notch et al for Minecraft
* Lex et al for MinecraftForge
* AlgorithmnX2 for AppliedEnergistics2
* all [contributers](https://github.com/thatsIch/IntelliE-Scala/graphs/contributors) helping making this mod.