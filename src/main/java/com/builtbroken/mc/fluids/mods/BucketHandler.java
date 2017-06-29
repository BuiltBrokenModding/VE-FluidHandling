package com.builtbroken.mc.fluids.mods;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/28/2016.
 */
public class BucketHandler
{
    public static final HashMap<Block, BucketHandler> blockToHandler = new HashMap();
    public static final HashMap<Fluid, BucketHandler> fluidToHandler = new HashMap();
    public static final HashMap<Class<? extends Entity>, BucketHandler> entityToHandler = new HashMap();
    public static final List<BucketHandler> bucketHandlers = new ArrayList();

    public static void addBucketHandler(BucketHandler handler)
    {
        if (!bucketHandlers.contains(handler))
        {
            bucketHandlers.add(handler);
        }
        //TODO add error checking
        //TODO add overriding checking
    }

    public static void addBucketHandler(Block block, BucketHandler handler)
    {
        addBucketHandler(handler);
        blockToHandler.put(block, handler);
        //TODO add error checking
        //TODO add overriding checking
    }

    public static void addBucketHandler(Fluid fluid, BucketHandler handler)
    {
        addBucketHandler(handler);
        fluidToHandler.put(fluid, handler);
        //TODO add error checking
        //TODO add overriding checking
    }

    /**
     * Called when the bucket is right clicked while empty
     *
     * @param itemstack
     * @param world
     * @param player
     * @return
     */
    public ItemStack emptyBucketClickBlock(EntityPlayer player, ItemStack itemstack, World world, BlockPos pos)
    {
        return itemstack;
    }

    /**
     * Called when the bucket contains fluid and is clicked
     *
     * @param player
     * @param itemstack
     * @param world
     * @return
     */
    public ItemStack filledBucketClickBlock(EntityPlayer player, ItemStack itemstack, World world, BlockPos pos)
    {
        return itemstack;
    }

    public ItemStack placeFluidClickBlock(EntityPlayer player, ItemStack itemstack, World world, BlockPos pos)
    {
        return itemstack;
    }

    /**
     * Called each tick from an entities inventory
     *
     * @param stack  - bucket
     * @param world  - world inside
     * @param entity - entity who has the item
     * @param slot   - slot the item is inside
     * @param held   - is the item currently held
     * @return true to cancel default functionality
     */
    public boolean onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
    {
        return false;
    }

    /**
     * Called in the same loop as {@link #onUpdate(ItemStack, World, Entity, int, boolean)} but
     * only when the bucket has leaked fluid
     *
     * @param stack  - bucket
     * @param world  - world inside
     * @param entity - entity who has the item
     * @param slot   - slot the item is inside
     * @param held   - is the item currently held
     * @return true to cancel default functionality
     */
    public boolean onBucketLeaked(ItemStack stack, World world, Entity entity, int slot, boolean held)
    {
        //If you still want the fluid to drain you need to do it yourself if you return true
        return false;
    }

    /**
     * Called each tick for the bucket when sitting on the ground
     *
     * @param entityItem - bucket entity
     * @return true to stop receiving updates
     */
    public boolean onEntityItemUpdate(EntityItem entityItem)
    {
        return false;
    }

    /**
     * Called when the player right clicks an entity
     *
     * @param stack  - bucket
     * @param player - player
     * @param entity - clicked entity
     * @return
     */
    public boolean rightClickEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity)
    {
        return false;
    }

    /**
     * Pass threw from bucket item to add sub types
     *
     * @param item - the bucket
     * @param list - the list of bucket items to be added to the creative tab
     */
    public void getSubItems(Item item, List list)
    {

    }
}
