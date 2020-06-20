package massay;


import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class MainClass extends PluginBase implements Listener {
    public void onEnable() {
        getLogger().info(TextFormat.GREEN + "has been enabled.");
        getServer().getPluginManager().registerEvents(this, (Plugin)this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if (commandLabel.equalsIgnoreCase("masssay")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("permission.masssay")) if (args.length == 0) {
                    sender.sendMessage("Type /" + cmd.getName() + "<Message>");
                } else {
                    String message = "";
                    for (int a = 0; a < args.length; a++) {
                        message += args[a] + " ";
                    }
                    for (Player playerall : this.getServer().getOnlinePlayers().values()) {
                        playerall.chat(message);
                        return false;
                    }
                }
                else {
                    sender.sendMessage("You don't have permission : permission.masssay");
                }
            } else {
                getLogger().info("You cannot use this in the console");

            }
        }
        return false;
    }
}
