package mods.railcraft_cos.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.core.ClientProxy;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.block.BlockRailBase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockRailcraftCosTrackCobweb extends BlockRailBase
{	
	public BlockRailcraftCosTrackCobweb(String unlocalizedName, boolean powered) 
	{
		super(powered);
		setBlockName(unlocalizedName);
		setBlockTextureName(Railcraft_Cos.MODID + ":" + unlocalizedName);
		setResistance(3.0F);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) 
	{
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType()
    {
        return ClientProxy.railcraftCosTrackRenderer;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float sideX, float sideY, float sideZ)
    {
		if(player.getCurrentEquippedItem() != null)
		{
			ItemStack item = player.getCurrentEquippedItem();			
			if(item.getItem() instanceof ItemShears)
			{				
				int oldmeta = world.getBlockMetadata(x, y, z);
				world.setBlock(x, y, z, Blocks.rail, oldmeta, 2);
				if (EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, item) > 0)
				{
					ItemStack itemstack = new ItemStack(Blocks.web, 1, 1);
					dropBlockAsItem(world, x, y, z, itemstack);
				}
				else
				{
					ItemStack itemstack = new ItemStack(Items.string, 1, 1);
					dropBlockAsItem(world, x, y, z, itemstack);
				}				
				item.damageItem(1, player);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		else
		{
			return false;
		}		
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        entity.setInWeb();
    }

}
