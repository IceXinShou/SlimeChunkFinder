package xs.slimechunkfinder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;

public final class Main extends JavaPlugin {

    ArrayList<Player> test = new ArrayList<>();
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        new SpigotExpansion().register();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (sender.hasPermission("slimechunkfinder.command")) {
                    if (player.getLocation().getChunk().isSlimeChunk()){
                        player.sendMessage(ChatColor.GREEN + "Your chunk is a Slime Chunk");
                    } else {
                        player.sendMessage(ChatColor.RED + "Your chunk is NOT a Slime Chunk");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You have no permission!");
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You must be a PLAYER!");
            }
        }
        return true;
    }

    public static Main getInstance() {
        return instance;
    }
}