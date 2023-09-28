package be.razerstorm.randomcrafts.listeners;

import be.razerstorm.randomcrafts.RandomCrafts;
import be.razerstorm.randomcrafts.utils.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class CraftingPrepareListener implements Listener {
    @EventHandler
    public void onCraftPrepare(PrepareItemCraftEvent event) {
        if (event.getRecipe() == null) return;

        Player player = (Player) event.getView().getPlayer();
        Recipe recipe = event.getRecipe();

        RandomCrafts instance = RandomCrafts.getInstance();

        if (instance.getConfig().getBoolean("always-random")) {
            ItemStack randomItem = Util.getRandomItem();
            instance.getToReceive().put(player.getUniqueId(), randomItem);
            event.getInventory().setItem(0, randomItem);
            return;
        }

        ItemStack originalItem = recipe.getResult();

        try {
            if (!instance.getRandomItems().containsKey(originalItem)) instance.getRandomItems().put(originalItem, Util.getRandomItem());
        } finally {
            instance.getToReceive().put(player.getUniqueId(), instance.getRandomItems().get(originalItem));
            event.getInventory().setItem(0, instance.getRandomItems().get(originalItem));
        }
    }
}