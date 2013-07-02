package jadedwolf.plugins.nofarm;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class NoFarmEntityListener implements Listener {

    public NoFarmEntityListener(NoFarm instance) {
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (event.getEntity() == null) {
            return;
        }
        if (event.getEntity() instanceof Player) {
            return;
        }
        if (event.getEntity().getLastDamageCause() == null) {
            return;
        }
        if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            return;
        }
        if (entity.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            return;
        }
        event.getDrops().clear();
    }
}
