package com.MetalDetectors;

import net.minecraft.client.main.GameConfig;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class MetalDetectorItem extends Item{

    public Block BlockToDetect1;
    public int ID1;
    public MetalDetectorItem(Properties pProperties, int ID) {
        super(pProperties);
        ID1 = ID;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
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

        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if(isValuableBlock(state, BlockToDetect1)){
                    if(Config.UsesCoords.get()){
                        outputValueCoords(positionClicked.below(i), player, state.getBlock());
                    }else{
                        player.sendSystemMessage(Component.literal("Found " + I18n.get(state.getBlock().getDescriptionId())));
                    }
                    foundBlock = true;

                    break;
                }

            }

            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No Valuables Found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValueCoords(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    boolean isValuableBlock(BlockState blockState, Block OutputBlock){
        return blockState.is(OutputBlock);
    }
}
