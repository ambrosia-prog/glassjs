package itsevelyn.lenientglass.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

public class ConnectiveBars extends IronBarsBlock {
    public ConnectiveBars(Properties arg) {
        super(arg);
    }
//why yes, this is an exact copy of ConnectivePane, I figured bars shouldn't connect to panes seamlessly. I'll make it tag-based or something, at some point...
    @Override
    public boolean skipRendering(@NotNull BlockState stateIs, BlockState stateNear, Direction dir) {
        if (stateNear.is(this)) {
            if (!dir.getAxis().isHorizontal()) {
                return true;
            }

            if ((Boolean)stateIs.getValue((Property)PROPERTY_BY_DIRECTION.get(dir)) && (Boolean)stateNear.getValue((Property)PROPERTY_BY_DIRECTION.get(dir.getOpposite()))) {
                return true;
            }
        }

        if (stateNear.getBlock() instanceof ConnectiveGlass)
            return true;
        else
            return super.skipRendering(stateIs, stateNear, dir);
    }
}
