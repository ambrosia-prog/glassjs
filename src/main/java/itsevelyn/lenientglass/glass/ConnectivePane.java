package itsevelyn.lenientglass.glass;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

public class ConnectivePane extends IronBarsBlock {
    public ConnectivePane(Properties arg) {
        super(arg);
    }

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
