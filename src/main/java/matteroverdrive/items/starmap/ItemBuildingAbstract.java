package matteroverdrive.items.starmap;

import matteroverdrive.api.inventory.starmap.IBuilding;
import matteroverdrive.items.includes.MOBaseItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

/**
 * Created by Simeon on 6/23/2015.
 */
public abstract class ItemBuildingAbstract extends MOBaseItem implements IBuilding {

    public ItemBuildingAbstract(String name)
    {
        super(name);
    }

    public void addDetails(ItemStack itemstack, EntityPlayer player, List infos)
    {
        super.addDetails(itemstack,player,infos);
        infos.add("Build Time: " + getBuildTime(itemstack));
    }

    public boolean hasDetails(ItemStack stack){return true;}

    public int getBuildTime(ItemStack building)
    {
        if (building.hasTagCompound())
        {
            return building.getTagCompound().getInteger("BuildTime");
        }
        else
        {
            return 0;
        }
    }

    public void setBuildTime(ItemStack building,int buildTime)
    {
        if (!building.hasTagCompound())
        {
            building.setTagCompound(new NBTTagCompound());
        }

        building.getTagCompound().setInteger("BuildTime",buildTime);
    }
}