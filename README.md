# GlassJS
Kubes Forge addon that adds panes, and variants that are more compatible with CTM.
Specifically, it was built for "kubejs-forge:2001.6.5-build.16", it probably works on basically any build past that but that's the one I'm working off of.

This addon adds five block builders:
Panes/Connective Panes,
Bars/Connective Bars, and
Connective Glass

Connective variants cull inside faces between other blocks of the same parent builder, so mixing glass will make one seamless whole without visible geometry on the inside.

There are differences between how vanilla handles these and how this addon handles them, in that both panes and bars now require a cross-shaped "top" texture, as opposed to only panes needing a top texture, and a line at that. This is due to me being lazy and not wanting to figure out how to rotate assets. Additionally, Bar-type blocks need extra resources as a resource pack, or just stuck into the KubeJS asset folders, wherever you like really. Minecraft has no template bar models to work off of so I had to make them myself.

 - Variant Tags - 
pane
c_pane
bars
c_bars
c_glass

# IMPORTANT
To make textures work properly on panes/bars, you HAVE to use .textureAll("id:path/to/texture"), kubeJS handles textures in a weird way and this is the first fix I found. Additionally, your top texture must have the suffix "_top" (ex. glasspane_top.png), as the builder only looks for that specific one. If I feel like it, I'll make it fall back to the main texture at some point later.
