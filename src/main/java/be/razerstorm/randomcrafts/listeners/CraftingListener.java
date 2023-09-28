package be.razerstorm.randomcrafts.listeners;

import be.razerstorm.randomcrafts.RandomCrafts;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftingListener implements Listener {
    @EventHandler
    public void onRandomCraft(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();

        RandomCrafts instance = RandomCrafts.getInstance();

        if (instance.getToReceive().containsKey(player.getUniqueId())) {
            event.setCurrentItem(instance.getToReceive().get(player.getUniqueId()));
            instance.getToReceive().remove(player.getUniqueId());
        }
    }
}
