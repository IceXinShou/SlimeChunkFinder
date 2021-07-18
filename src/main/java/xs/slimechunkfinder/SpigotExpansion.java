package xs.slimechunkfinder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class SpigotExpansion extends PlaceholderExpansion {


    @Override
    public String getIdentifier() {
        return "SlimeChunkFinder";
    }

    @Override
    public String getAuthor() {
        return "IceXinShou";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        if (player == null) {
            return "";
        }
        if (params.equals("Boolean")){

            String Slime = String.valueOf(player.getLocation().getChunk().isSlimeChunk());

            if (Slime == "True"){
                return "True"; //Yes / True
            }else{
                return "False"; //No / False
            }
        }
        return null;
    }
}
