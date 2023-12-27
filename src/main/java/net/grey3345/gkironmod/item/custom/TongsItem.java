package net.grey3345.gkironmod.item.custom;

import net.grey3345.gkironmod.block.custom.HeatableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

/**
 * see {@link HeatableBlock#attack(BlockState, Level, BlockPos, Player)} for where this is used to insta break
 */
public class TongsItem extends Item {
    public TongsItem(Properties p_41383_) {
        super(p_41383_);
    }
}
