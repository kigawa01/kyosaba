package net.kigawa.plugin.kyosaba.main.chiar;

import net.kigawa.plugin.kyosaba.Kyosaba;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.spigotmc.event.entity.EntityDismountEvent;

public class listner implements Listener {
    private final Kyosaba plugin;
    public listner(Kyosaba kyosaba){
        plugin=kyosaba;
    }

    @EventHandler
    public void clickevent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getClickedBlock() != null) {
            Block block = event.getClickedBlock();
            if (event.getPlayer().getInventory().getItemInMainHand().getAmount()==0) {
                String sblock = block.toString();
                Block upblock=block.getRelative(BlockFace.UP);
                String strupblock=upblock.toString();
                if (sblock.contains("STAIRS")&&sblock.contains("half=bottom")&&strupblock.contains("type=AIR")) {
                    event.setCancelled(true);
                    if (event.getPlayer().isGliding()) {
                        event.getPlayer().setGliding(false);
                    }
                    Arrow arrow = (Arrow) event.getPlayer().getWorld().spawnEntity(block.getLocation().add(new Vector(0.5, 0, 0.5)), EntityType.ARROW);
                    arrow.addScoreboardTag("toride");
                    arrow.setGravity(false);
                    arrow.setInvulnerable(true);
                    arrow.addPassenger(event.getPlayer());
                    timer(arrow);
                }
            }
        }
    }
    @EventHandler
    public void Getoffevent(EntityDismountEvent event){
        Entity mounted=event.getDismounted();
        if(mounted.removeScoreboardTag("toride")){
            mounted.remove();
        }
    }
    public void timer(Arrow arrow){
        new BukkitRunnable(){
            @Override
            public void run(){
                for(Entity entity:arrow.getPassengers()){
                    if(entity==null){
                    arrow.remove();
                    cancel();
                    }
                }
                if(!arrow.isDead()||!arrow.isEmpty()) {
                    arrow.setTicksLived(120);
                    timer(arrow);
                }

            }
        }.runTaskLater(plugin,100);
    }
}