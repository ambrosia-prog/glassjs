# glassjs
Kubes Forge addon that adds panes, and variants that are more compatible with CTM.
Specifically, it was built for "kubejs-forge:2001.6.5-build.16", it probably works on basically any build past that but that's the one I'm working off of.

It adds three more builders. The biggest (and most irritating) of the three is PaneBlockBuilder, which allows KubeJS to generate pane/bar-type blocks with the standard .create('id', 'variant') rather than anything more complex. It unfortunately falls to the same issue that other multiparts such as stairs experience with KubeJS, in that it is seemingly incredibly difficult to specify textures for them beyond the shotgun approach of .textureAll('id:texture'). This leaves the pane looking alright, but the edges are very obviously improperly textured. Also, the item is invisible, but that one's because I have no idea what I'm doing since panes don't just have an inventory model I can work off of. Please, if you know fixes, let me know, or just make pull requests, I honestly don't know how github works I just wanted my source visible.

Other than that, there's a builder that allows for blocks built from it to cull inside faces if they're touching another block made by the same builder. This is intended for use with CTM-type things, where you can have multiple different glass blocks merge without obvious borders inside of the block. Panes also have one, but it honestly hasn't been tested, since I've been focusing on trying to get textures to behave normally before moving on to merging them.

Their variants are "pane", "c_pane", and "c_glass".
