package fr.nodropingitems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	@EventHandler
	public void onPlayerDropEvent(PlayerDropItemEvent event) {
		
		Player player = event.getPlayer();
		
		if(!player.hasPermission("nodropingitems.bypass")) {
			
			event.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onPlayerLaunchSlapshPotion(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Material material = event.getMaterial();
		
		if(material == null)
			return;
		
		if(material.equals(Material.SPLASH_POTION) && !player.hasPermission("nodropingitems.bypass")) {
			
			event.setCancelled(true);
			
		}
		
	}
	
	
	
}
