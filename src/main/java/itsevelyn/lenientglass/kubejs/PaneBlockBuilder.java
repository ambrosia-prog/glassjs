package itsevelyn.lenientglass.kubejs;

import dev.latvian.mods.kubejs.block.custom.MultipartShapedBlockBuilder;
import dev.latvian.mods.kubejs.client.ModelGenerator;
import dev.latvian.mods.kubejs.client.MultipartBlockStateGenerator;
import dev.latvian.mods.kubejs.generator.AssetJsonGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;

public class PaneBlockBuilder extends MultipartShapedBlockBuilder {
    public PaneBlockBuilder(ResourceLocation i, String... suffixes) {
        super(i, suffixes);
    }

    @Override
    public Block createObject() {
        return new IronBarsBlock(createProperties());
    }

    @Override
    protected void generateMultipartBlockStateJson(MultipartBlockStateGenerator bs) {
        var modPost = newID("block/", "_post").toString();
        var modSide = newID("block/", "_side").toString();
        var modSideAlt = newID("block/", "_side_alt").toString();
        var modNoSide = newID("block/", "_noside").toString();
        var modNoSideAlt = newID("block/", "_noside_alt").toString();

        bs.part("", modPost);
        bs.part("north=true", p -> p.model(modSide).uvlock());
        bs.part("east=true", p -> p.model(modSide).uvlock().y(90));
        bs.part("south=true", p -> p.model(modSideAlt).uvlock());
        bs.part("west=true", p -> p.model(modSideAlt).uvlock().y(90));
        bs.part("north=false", p -> p.model(modNoSide).uvlock());
        bs.part("east=false", p -> p.model(modNoSideAlt).uvlock());
        bs.part("south=false", p -> p.model(modNoSideAlt).uvlock().y(90));
        bs.part("west=false", p -> p.model(modNoSide).uvlock().y(270));
    }

    @Override
    protected void generateItemModelJson(ModelGenerator m) {
        m.parent("minecraft:item/generated");
        m.texture("texture", textures.get("texture").getAsString());
    }

    @Override
    protected void generateBlockModelJsons(AssetJsonGenerator generator) {
        var texture = textures.get("texture").getAsString();

        generator.blockModel(newID("", "_noside"), m -> {
            m.parent("minecraft:block/template_glass_pane_noside");
            m.texture("pane", texture);
            m.texture("edge", texture);
        });

        generator.blockModel(newID("", "_noside_alt"), m -> {
            m.parent("minecraft:block/template_glass_pane_noside_alt");
            m.texture("pane", texture);
            m.texture("edge", texture);
        });

        generator.blockModel(newID("", "_post"), m -> {
            m.parent("minecraft:block/template_glass_pane_post");
            m.texture("pane", texture);
            m.texture("edge", texture);
        });

        generator.blockModel(newID("", "_side"), m -> {
            m.parent("minecraft:block/template_glass_pane_side");
            m.texture("pane", texture);
            m.texture("edge", texture);
        });

        generator.blockModel(newID("", "_side_alt"), m -> {
            m.parent("minecraft:block/template_glass_pane_side_alt");
            m.texture("pane", texture);
            m.texture("edge", texture);
        });
    }
}
