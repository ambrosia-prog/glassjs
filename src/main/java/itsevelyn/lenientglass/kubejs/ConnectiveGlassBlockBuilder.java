package itsevelyn.lenientglass.kubejs;

import itsevelyn.lenientglass.glass.ConnectiveGlass;
import dev.latvian.mods.kubejs.block.BlockBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ConnectiveGlassBlockBuilder extends BlockBuilder {
    public ConnectiveGlassBlockBuilder(ResourceLocation loc){
        super(loc);
    }

    public Block createObject() {
        return new ConnectiveGlass(this);
    }
}
