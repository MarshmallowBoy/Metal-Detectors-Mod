# Metal-Detectors-Mod
Source Code For The Metal Detectors Mod On Modrinth
In order to add your mod's blocks to be able to be scanned by the detectors,
you may go to the config file "metal_detector_mod-common.toml" and from there
you can change what block the detectors use, for example, you have a mod called
"aether" and a block named "zanite_ore", you can change, for example "coal_ore"
to "aether:zanite_ore". 

  If you want to create more detectors, you can also create more detectors by going to
MetalDetectors/src/main/java/com/MetalDetectors/ModItems.java and adding more
metal detectors, just click on the line that says for example:
```public static final RegistryObject<Item> MetalDetector6 = ITEMS.register("metal_detector_6", () -> new MetalDetectorItem(new Item.Properties().durability(600), 6));```
and then copy and paste it onto a new line, and then edit it. (you can also just press ctrl+d)
From there you can take it where it says "```MetalDetector6```", and change it to "```MetalDetector7```",
Then you want to go to where it says "```ITEMS.register("metal_detector_6"```"
and you guessed it, change the 6 to a 7.

From there, you technically have created more Metal Detectors, but in order to finalize it, more must be done.
