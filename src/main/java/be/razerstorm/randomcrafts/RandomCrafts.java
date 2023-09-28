package be.razerstorm.randomcrafts;

import be.razerstorm.randomcrafts.listeners.CraftingListener;
import be.razerstorm.randomcrafts.listeners.CraftingPrepareListener;
import be.razerstorm.randomcrafts.utils.Metrics;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class RandomCrafts extends JavaPlugin implements Listener {

    private static @Getter RandomCrafts instance;

    private final @Getter HashMap<ItemStack, ItemStack> randomItems = new HashMap<>();
    private final @Getter HashMap<UUID, ItemStack> toReceive = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        new Metrics(this, 19918);

        getServer().getPluginManager().registerEvents(new CraftingListener(), this);
        getServer().getPluginManager().registerEvents(new CraftingPrepareListener(), this);
    }
}