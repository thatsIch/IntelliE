package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.intellie.common.util.IProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 31.03.2014.
 */
@Singleton
public class Registries implements IProxy {
	private final ArmorRenderingRegistry armorRenderers;
	private final BlockContainerRegistry blockContainers;
	private final BlockRegistry blocks;
	private final BlockRenderingRegistry blockRenderers;
	private final ConfigRegistry configs;
	private final EntityRenderingRegistry entityRenderers;
	private final GuiRegistry guis;
	private final ItemRegistry items;
	private final SoundRegistry sounds;
	private final TileEntityRegistry tileEntites;

	@Inject
	Registries(final ArmorRenderingRegistry armorRenderers, final BlockContainerRegistry blockContainers, final BlockRegistry blocks, final BlockRenderingRegistry blockRenderers, final ConfigRegistry configs, final EntityRenderingRegistry entityRenderers, final GuiRegistry guis, final ItemRegistry items, final SoundRegistry sounds, final TileEntityRegistry tileEntites) {
		this.armorRenderers = armorRenderers;
		this.blockContainers = blockContainers;
		this.blocks = blocks;
		this.blockRenderers = blockRenderers;
		this.configs = configs;
		this.entityRenderers = entityRenderers;
		this.guis = guis;
		this.items = items;
		this.sounds = sounds;
		this.tileEntites = tileEntites;
	}

	public ArmorRenderingRegistry getArmorRenderers() {
		return this.armorRenderers;
	}

	public BlockContainerRegistry getBlockContainers() {
		return this.blockContainers;
	}

	public BlockRegistry getBlocks() {
		return this.blocks;
	}

	public BlockRenderingRegistry getBlockRenderers() {
		return this.blockRenderers;
	}

	public ConfigRegistry getConfigs() {
		return this.configs;
	}

	public EntityRenderingRegistry getEntityRenderers() {
		return this.entityRenderers;
	}

	public GuiRegistry getGuis() {
		return this.guis;
	}

	public ItemRegistry getItems() {
		return this.items;
	}

	public SoundRegistry getSounds() {
		return this.sounds;
	}

	public TileEntityRegistry getTileEntites() {
		return this.tileEntites;
	}

	@Override
	public void preInit(final FMLPreInitializationEvent event) {

		//		this.items.loadConfig( config );
		//		this.tileEntites.loadConfig( config );
		this.blocks.register();
		this.items.register();
	}

	@Override
	public void init(final FMLInitializationEvent event) {
		this.tileEntites.register();

		// super.getItems().registerRecipes();

		// super.getTileEntities().init();
		// super.getGui().init( this );
		//		this.recipeRegistry.register();
	}

	@Override
	public void postInit(final FMLPostInitializationEvent event) {

	}
}
