package itsevelyn.lenientglass.kubejs;

import itsevelyn.lenientglass.glass.ConnectivePane;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ConnectivePaneBlockBuilder extends PaneBlockBuilder {
    public ConnectivePaneBlockBuilder(ResourceLocation i) {
        super(i);
    }

    @Override
    public Block createObject() {
        return new ConnectivePane(createProperties());
    }


}
