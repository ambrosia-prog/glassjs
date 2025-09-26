package itsevelyn.lenientglass.kubejs;

import itsevelyn.lenientglass.blocks.ConnectiveBars;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ConnectiveBarsBlockBuilder extends PaneBlockBuilder {
    public ConnectiveBarsBlockBuilder(ResourceLocation i) {
        super(i);
    }

    @Override
    public Block createObject() {
        return new ConnectiveBars(createProperties());
    }


}
