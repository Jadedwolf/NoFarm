package jadedwolf.plugins.nofarm;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoFarmMobListener implements Listener {

    public NoFarmMobListener(NoFarm instance) {
    }

    // Stop mobs from taking fall damge
    @EventHandler
    public void onEntityDamageMob(EntityDamageEvent event) {
        Entity e = event.getEntity();
        if ((!(e instanceof Player))
                && e.getLastDamageCause() != null
                && (e.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL)) {
            event.setDamage(0);

        }
    }
}
