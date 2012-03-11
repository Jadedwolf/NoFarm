package jadedwolf.plugins.nofarm;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;



public class NoFarmEntityListener implements Listener {
	
	public NoFarmEntityListener(NoFarm instance) {
	}

  @EventHandler
  public void onEntityDeath(EntityDeathEvent event) {
    if(!(event.getEntity() instanceof Player) && !(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
            event.getDrops().clear();
        }
  }
  
}
