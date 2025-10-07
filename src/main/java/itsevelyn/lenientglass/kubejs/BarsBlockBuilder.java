package itsevelyn.lenientglass.kubejs;

import dev.latvian.mods.kubejs.block.custom.MultipartShapedBlockBuilder;
import dev.latvian.mods.kubejs.client.ModelGenerator;
import dev.latvian.mods.kubejs.client.MultipartBlockStateGenerator;
import dev.latvian.mods.kubejs.generator.AssetJsonGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;

public class BarsBlockBuilder extends MultipartShapedBlockBuilder {
    public BarsBlockBuilder(ResourceLocation i) {
        super(i, "_bars","_bar");
    }

    @Override
    public Block createObject() {
        return new IronBarsBlock(createProperties());
    }

    protected void generateMultipartBlockStateJson(MultipartBlockStateGenerator bs) {
        var modCap = newID("block/", "_cap").toString();
        var modCapAlt = newID("block/", "_cap_alt").toString();
        var modPost = newID("block/", "_post").toString();
        var modPostEnds = newID("block/", "_post_ends").toString();
        var modSide = newID("block/", "_side").toString();
        var modSideAlt = newID("block/", "_side_alt").toString();

        bs.part("", modPostEnds);
        bs.part("east=false,north=false,south=false,west=false", p -> p.model(modPost).uvlock());
        bs.part("east=false,north=true,south=false,west=false", p -> p.model(modCap).uvlock());
        bs.part("east=true,north=false,south=false,west=false", p -> p.model(modCap).uvlock().y(90));
        bs.part("east=false,north=false,south=true,west=false", p -> p.model(modCapAlt).uvlock());
        bs.part("east=false,north=false,south=false,west=true", p -> p.model(modCapAlt).uvlock().y(90));
        bs.part("north=true", p -> p.model(modSide).uvlock());
        bs.part("east=true", p -> p.model(modSide).uvlock().y(90));
        bs.part("south=true", p -> p.model(modSideAlt).uvlock());
        bs.part("west=true", p -> p.model(modSideAlt).uvlock().y(90));

    }

    @Override
    protected void generateItemModelJson(ModelGenerator m) {
        m.parent("minecraft:item/generated");
        m.texture("layer0", textures.get("texture").getAsString());
    }

    @Override
    protected void generateBlockModelJsons(AssetJsonGenerator generator) {
        var texture = textures.get("texture").getAsString();
        var textureEdge = textures.get("texture").getAsString()+"_top";

        generator.blockModel(newID("", "_cap"), m -> {
            m.parent("glassjs:block/template_bars_cap");
            m.texture("bars", texture);
            m.texture("edge", textureEdge);
        });

        generator.blockModel(newID("", "_cap_alt"), m -> {
            m.parent("glassjs:block/template_bars_cap_alt");
            m.texture("bars", texture);
            m.texture("edge", textureEdge);
        });

        generator.blockModel(newID("", "_post"), m -> {
            m.parent("glassjs:block/template_bars_post");
            m.texture("bars", texture);
            m.texture("edge", textureEdge);
        });

        generator.blockModel(newID("", "_post_ends"), m -> {
            m.parent("glassjs:block/template_bars_post_ends");
            m.texture("bars", texture);
            m.texture("edge", textureEdge);
        });

        generator.blockModel(newID("", "_side"), m -> {
            m.parent("glassjs:block/template_bars_side");
            m.texture("bars", texture);
            m.texture("edge", textureEdge);
        });

        generator.blockModel(newID("", "_side_alt"), m -> {
            m.parent("glassjs:block/template_bars_side_alt");
            m.texture("bars", texture);
            m.texture("edge", textureEdge);
        });
    }
}
