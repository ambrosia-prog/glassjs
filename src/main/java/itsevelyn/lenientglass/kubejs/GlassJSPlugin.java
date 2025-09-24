package itsevelyn.lenientglass.kubejs;

import itsevelyn.lenientglass.GlassJS;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.registry.RegistryInfo;

public class GlassJSPlugin extends KubeJSPlugin {

    @Override
    public void init() {
        GlassJS.LOGGER.info("GlassJS: straight glassin it");

        RegistryInfo.BLOCK.addType("c_glass", ConnectiveGlassBlockBuilder.class, ConnectiveGlassBlockBuilder::new);
        RegistryInfo.BLOCK.addType("c_pane", ConnectivePaneBlockBuilder.class, ConnectivePaneBlockBuilder::new);
        RegistryInfo.BLOCK.addType("pane", PaneBlockBuilder.class, PaneBlockBuilder::new);
    }
}

