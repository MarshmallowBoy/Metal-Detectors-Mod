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
        boolean foundBlock = false;
        switch (ID1) {
            case 1:
                String IDs1[] = Config.Block1.get().split(", ");
                for (int i = 0; i < IDs1.length; i++) {
                    foundBlock = FindTheBlock(pContext, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(IDs1[i])));
                }
                break;
            case 2:
                String IDs2[] = Config.Block2.get().split(", ");
                for (int i = 0; i < IDs2.length; i++) {
                    foundBlock = FindTheBlock(pContext, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(IDs2[i])));
                }
                break;
            case 3:
                String IDs3[] = Config.Block3.get().split(", ");
                for (int i = 0; i < IDs3.length; i++) {
                    foundBlock = FindTheBlock(pContext, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(IDs3[i])));
                }
                break;
            case 4:
                String IDs4[] = Config.Block4.get().split(", ");
                for (int i = 0; i < IDs4.length; i++) {
                    foundBlock = FindTheBlock(pContext, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(IDs4[i])));
                }
                break;
            case 5:
                String IDs5[] = Config.Block5.get().split(", ");
                for (int i = 0; i < IDs5.length; i++) {
                    foundBlock = FindTheBlock(pContext, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(IDs5[i])));
                }
                break;
            case 6:
                String IDs6[] = Config.Block6.get().split(", ");
                for (int i = 0; i < IDs6.length; i++) {
                    foundBlock = FindTheBlock(pContext, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(IDs6[i])));
                }
                break;
        }

        if(!foundBlock && !pContext.getLevel().isClientSide()){
            pContext.getPlayer().sendSystemMessage(Component.literal("No Valuables Found"));
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    boolean FindTheBlock(UseOnContext pContext, Block BlockToDetect1){
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

            return foundBlock;
        }
        return false;
    }


    private void outputValueCoords(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    boolean isValuableBlock(BlockState blockState, Block OutputBlock){
        return blockState.is(OutputBlock);
    }
}
