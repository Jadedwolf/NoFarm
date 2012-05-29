package jadedwolf.plugins.nofarm;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;



public class NoFarmEntityListener implements Listener {
	
	public NoFarmEntityListener(NoFarm instance) {
	}

  @EventHandler
  public void onEntityDeath(EntityDeathEvent event) {
    if(!(event.getEntity() instanceof Player) && !(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
        event.setDroppedExp(0);
        event.getDrops().clear();
        }
  }
    // Stop mobs from taking fall damge
  @EventHandler
  public void onEntityDamageMob(EntityDamageEvent event)
  {
		Entity e = event.getEntity();
    if ((!(e instanceof Player)) && 
		    (e.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL)) {
			event.setDamage(0);
		}
  }
}
