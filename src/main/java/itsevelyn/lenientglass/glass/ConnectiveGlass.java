package itsevelyn.lenientglass.glass;

import dev.latvian.mods.kubejs.block.BlockBuilder;
import dev.latvian.mods.kubejs.block.custom.BasicBlockJS;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ConnectiveGlass extends BasicBlockJS {
    public ConnectiveGlass(BlockBuilder waow) {
        super(waow);
    }

    @Override
    public boolean skipRendering(@NotNull BlockState stateIs, BlockState stateNear, Direction dir) {
        if (stateNear.getBlock() instanceof itsevelyn.lenientglass.glass.ConnectiveGlass)
            return true;
        else
            return super.skipRendering(stateIs, stateNear, dir);
    }
}
