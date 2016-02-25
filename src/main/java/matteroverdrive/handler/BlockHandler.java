package matteroverdrive.handler;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.Reference;
import matteroverdrive.entity.player.MOExtendedProperties;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Simeon on 12/24/2015.
 */
public class BlockHandler
{
    @SubscribeEvent
    public void onHarvestDropsEvent(BlockEvent.HarvestDropsEvent event)
    {
        if (event.harvester != null)
        {
            MOExtendedProperties extendedProperties = MOExtendedProperties.get(event.harvester);
            if (extendedProperties != null)
            {
                extendedProperties.onEvent(event);
            }
        }
    }

    @SubscribeEvent
    public void onBlockPlaceEvent(BlockEvent.PlaceEvent event)
    {
        if (event.player != null)
        {
            String blockName = event.state.getBlock().getRegistryName();
            String modID = blockName.substring(0,blockName.indexOf(':'));
            if (modID.equals(Reference.MOD_ID))
            {
                MatterOverdrive.proxy.getGoogleAnalytics().sendEventHit(GoogleAnalyticsCommon.EVENT_CATEGORY_BLOCK_PLACEING, modID, blockName, event.player);
            }
            MOExtendedProperties extendedProperties = MOExtendedProperties.get(event.player);
            if (extendedProperties != null)
            {
                extendedProperties.onEvent(event);
            }
        }
    }
}