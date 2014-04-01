package de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest;

import appeng.api.config.AccessRestriction;
import appeng.api.implementations.items.IAEItemPowerStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

/**
 * @author thatsIch
 * @since 26.03.2014.
 */
public class ItemGraviChestPlate extends ItemArmor implements ISpecialArmor, IAEItemPowerStorage {
	private static final int ENERGY_MAX = 30000000;

	private static final double DOUBLE = 20.0D;
	public static int maxCharge = 30000000;
	public static int minCharge = 80000;
	public static int transferLimit = 60000;
	public static int tier = 4;
	public static int dischargeOnTick = 278;
	public static float boostSpeed = 0.11F;
	public static int boostMultiplier = 2;

	public ItemGraviChestPlate(final ItemArmor.ArmorMaterial material, final int renderIndex, final int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName("GraviChestPlate");
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public ISpecialArmor.ArmorProperties getProperties(final EntityLivingBase player, final ItemStack armor, final DamageSource source, final double damage, final int slot) {
		double absorptionRatio = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
		int energyPerDamage = this.getEnergyPerDamage();
		int damageLimit = energyPerDamage > 0 ? 25 * 100 / energyPerDamage : 0;

		return new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit);
	}

	@Override
	public int getArmorDisplay(final EntityPlayer player, final ItemStack armor, final int slot) {
		final double baseAbsorptionRatio = this.getBaseAbsorptionRatio();
		final double damageAbsorptionRatio = this.getDamageAbsorptionRatio();
		return (int) Math.round(ItemGraviChestPlate.DOUBLE * baseAbsorptionRatio * damageAbsorptionRatio);
	}

	@Override
	public void damageArmor(final EntityLivingBase entity, final ItemStack stack, final DamageSource source, final int damage, final int slot) {
		// discharge
	}

	private double getBaseAbsorptionRatio() {
		return 0.4D;
	}

	public double getDamageAbsorptionRatio() {
		return 1.1D;
	}

	public int getEnergyPerDamage() {
		return 900;
	}

	@Override
	public boolean isRepairable() {
		return false;
	}

	@Override
	public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
		final Class<? extends ItemGraviChestPlate> clazz = this.getClass();
		final boolean wearsSuite = player.inventory.armorItemInSlot(2).getItem().getClass().equals(clazz);
		final boolean isInCreative = player.capabilities.isCreativeMode;
		final boolean isInSurvival = !isInCreative;

		player.capabilities.allowFlying = wearsSuite || isInCreative;

		if (player.capabilities.isFlying) {
			System.out.println(itemStack);
			// drain energy
			//			System.out.println("Flying \\o/");
		}
	}

	@Override
	public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
		return "gravisuite:textures/armor/armor_graviChestPlate.png";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(final IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("appaero:itemGraviChestPlate");
	}

	@Override
	public double injectAEPower(final ItemStack is, final double amt) {
		return 0;
	}

	@Override
	public double extractAEPower(final ItemStack is, final double amt) {
		return 0;
	}

	@Override
	public double getAEMaxPower(final ItemStack is) {
		return 0;
	}

	@Override
	public double getAECurrentPower(final ItemStack is) {
		return 0;
	}

	@Override
	public AccessRestriction getPowerFlow(final ItemStack is) {
		return null;
	}
}
