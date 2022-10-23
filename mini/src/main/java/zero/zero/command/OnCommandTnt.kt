
package zero.zero.command

import org.bukkit.Bukkit.getServer
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.io.File
import java.io.FileWriter
import java.io.IOException

//the package for this project



class OnCommandTnt : CommandExecutor {// creating the class death and implementing the listener






    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        val x = 247.0
        val y = -58.0
        val z = 250.0
        val fileName = "game.txt"
        val actualFile = File(fileName)
        val toWrite = "1"



        for (p in getServer().onlinePlayers) {
            if(p.location.world.name.endsWith("lobby_server")){

                p.health = 20.0
                val w: World = p.world
                val to = Location(w, x, y, z)//move before for
                p.teleport(to)
                p.inventory.clear()
            }
            try{
                val myWriter = FileWriter(actualFile)//pointing the writer to the actual file
                myWriter.write(toWrite)//writing the data to the file
                myWriter.close()//closing the writer
            }
            catch(e: IOException){
                throw RuntimeException(e)
            }
        }




        return true

    }
}