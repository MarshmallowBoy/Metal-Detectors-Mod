# Metal-Detectors-Mod
# How To Alter Detectors To Fit With Other Mods.
In order to add your mod's blocks to be able to be scanned by the detectors,
you may go to the config file "metal_detector_mod-common.toml" and from there
you can change what block the detectors use, for example, you have a mod called
"aether" and a block named "zanite_ore", you can change, for example "coal_ore"
to "aether:zanite_ore". For this method you don't need to change source code.
# How to add more than one block a detector can detect
This one comes with an example, because in the config you will find the ore, and then
the deepslate variant, you can add more blocks with this format ```"(BlockID), (BlockID)"```
Example; ```"Blocks ID 1" = "coal_ore, deepslate_coal_ore, coal_block"``` etc.

# How To Make More Detectors For Your Mod.
  If you want to create more detectors, you can also create more detectors by going to
  [ModItems.java](MetalDetectors/src/main/java/com/MetalDetectors/ModItems.java)
and adding more
metal detectors, just click on the line that says for example: 
```public static final RegistryObject<Item> MetalDetector6 = ITEMS.register("metal_detector_6", () -> new MetalDetectorItem(new Item.Properties().durability(600), 6));```

and then copy and paste it onto a new line, and then edit it. (you can also just press ctrl+d)
From there you can take it where it says "```MetalDetector6```", and change it to "```MetalDetector7```",
Then you want to go to where it says "```ITEMS.register("metal_detector_6"```"
and you guessed it, change the 6 to a 7. (You can also adjust the durability if you want, I would recommend
the harder it is to obtain the more it has.)

From there, you technically have created more Metal Detectors, but in order to finalize it, more must be done.
It is unfortunately to complicated to tell you this to an unexperienced user in modding, but for those who have experience, 
just create more items like how one normally would. Then go to [MetalDetectorItem](MetalDetectors/src/main/java/com/MetalDetectors/MetalDetectorItem.java) class.
when you are there, you will find an area that says:
```
switch (ID1){
    case 1:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block1.get()));
        break;
    case 2:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block2.get()));
        break;
    case 3:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block3.get()));
        break;
    case 4:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block4.get()));
        break;
    case 5:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block5.get()));
        break;
    case 6:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block6.get()));
        break;
}
```
You need to copy from ```case #:``` to ```break;``` Example:
```
case 6:
        BlockToDetect1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.Block6.get()));
        break;
```
Then you want to turn all the number into a 7 (it can be a different number, it just needs to match everything else)

And last bit of **CODE** you need to do (you still need to add the .json files to the items we made, which you are a big boy I am sure you can figure that out on your own)
we need to go to [Config.java](MetalDetectors/src/main/java/com/MetalDetectors/Config.java). From here we want to go to:
```
public static final ForgeConfigSpec.ConfigValue<String> Block1;
    public static final ForgeConfigSpec.ConfigValue<String> Block2;
    public static final ForgeConfigSpec.ConfigValue<String> Block3;
    public static final ForgeConfigSpec.ConfigValue<String> Block4;
    public static final ForgeConfigSpec.ConfigValue<String> Block5;
    public static final ForgeConfigSpec.ConfigValue<String> Block6;
    public static final ForgeConfigSpec.BooleanValue UsesCoords;
```
And then we take ```public static final ForgeConfigSpec.ConfigValue<String> Block6;``` Copy and paste it right below it, (between that line and the UseseCoords line)
and then of coarse change Block6 to block 7.
From there go to:
```
UsesCoords = BUILDER.comment("Uses Coords?").define("Coords:", true);
        Block1 = BUILDER.comment("Blocks For Coal Detector").define("Blocks ID 1", "coal_ore");
        Block2 = BUILDER.comment("Blocks For Iron Detector").define("Blocks ID 2", "iron_ore");
        Block3 = BUILDER.comment("Blocks For Redstone Detector").define("Blocks ID 3", "redstone_ore");
        Block4 = BUILDER.comment("Blocks For Gold Detector").define("Blocks ID 4", "gold_ore");
        Block5 = BUILDER.comment("Blocks For Lapis Detector").define("Blocks ID 5", "lapis_ore");
        Block6 = BUILDER.comment("Blocks For Diamond Detector").define("Blocks ID 6", "diamond_ore");
```
Then copy ```Block6 = BUILDER.comment("Blocks For Diamond Detector").define("Blocks ID 6", "diamond_ore");```
and paste it below it, change the 6 to a 7, then in the BUILDER.comment, instead of "Blocks For Diamond Detector", write
"Blocks for (You detectors name)" or really whatever you want it to say in the config file, then change ```.define("Blocks ID 6", "diamond_ore")```
to ```.define("Blocks ID 7", "(the name of the block id you want)")```
And from there, minus the json files you still need to make, (for the model, just take [This json](MetalDetectors/src/main/resources/assets/metal_detectors_mod/models/item/metal_detector_1.json) and then
copy it, change all the 6's to 7's, and add a custom texture you made by altering the ones already in [The texture folder](MetalDetectors/src/main/resources/assets/metal_detectors_mod/textures/item).
I would highly recommend using BlockBench to alter the textures.) You are finally done!

If you need any help just contact me at TraysonCazier719@gmail.com
