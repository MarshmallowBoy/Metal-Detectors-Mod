package com.MetalDetectors;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;


    public static final ForgeConfigSpec.ConfigValue<String> Block1;
    public static final ForgeConfigSpec.ConfigValue<String> Block2;
    public static final ForgeConfigSpec.ConfigValue<String> Block3;
    public static final ForgeConfigSpec.ConfigValue<String> Block4;
    public static final ForgeConfigSpec.ConfigValue<String> Block5;
    public static final ForgeConfigSpec.ConfigValue<String> Block6;
    public static final ForgeConfigSpec.BooleanValue UsesCoords;


    static{
        BUILDER.push("Configs For Metal Detector Mod");

        UsesCoords = BUILDER.comment("Uses Coords?").define("Coords:", true);
        Block1 = BUILDER.comment("Blocks For Coal Detector").define("Blocks ID 1", "coal_ore, deepslate_coal_ore");
        Block2 = BUILDER.comment("Blocks For Iron Detector").define("Blocks ID 2", "iron_ore, deepslate_iron_ore");
        Block3 = BUILDER.comment("Blocks For Redstone Detector").define("Blocks ID 3", "redstone_ore, deepslate_redstone_ore");
        Block4 = BUILDER.comment("Blocks For Gold Detector").define("Blocks ID 4", "gold_ore, deepslate_gold_ore");
        Block5 = BUILDER.comment("Blocks For Lapis Detector").define("Blocks ID 5", "lapis_ore, deepslate_lapis_ore");
        Block6 = BUILDER.comment("Blocks For Diamond Detector").define("Blocks ID 6", "diamond_ore, deepslate_diamond_ore");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
