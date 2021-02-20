# Fabric Example Mod with BIN Mappings for beta 1.7.3 server + client

## Setup

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

NOTE: There is no Fabric-API for beta 1.7.3!  
There is [StationLoader](https://github.com/modificationstation/StationLoader).  
There is also [Cursed-Legacy-API](https://github.com/minecraft-cursed-legacy/Cursed-Legacy-API), but that requires you to use [Plasma's mappings and workspace](https://github.com/minecraft-cursed-legacy/Example-Mod) instead of this.

Extra steps for better Mixin making and Fabric configuring in IntelliJ IDEA:

1. Go to `File > Settings...`
2. Go to `Plugins` and install the `Minecraft Development` plugin.
3. Restart IntelliJ IDEA.
4. Profit!

## Using a Mod

You will want to use the [Cursed Fabric MultiMC Instance](https://github.com/calmilamsy/Cursed-Fabric-MultiMC)

## Common Issues

**maven.glass-launcher.net timed out or returned an error!**
Contact calmilamsy in the ModStation discord about it.

**I cant import anything from Minecraft/One of my dependencies arent able to be imported!**
Go into `File > Project Structure...` and go into the `Project` tab and make sure you have got JDK 8 selected.  
If you dont have JDK 8, then [download it here](https://www.oracle.com/uk/java/technologies/javase/javase-jdk8-downloads.html) (Requires an Oracle account).

**Gradle says something about not being able to resolve Minecraft or another dependency!**  
Just go into `C:\users\<username>\.gradle\caches` (`~/.gradle/caches` on other OSes), delete `fabric-loom` and refresh Gradle.

**My Minecraft run profile is missing from the top right!**  
Go into `Run Configurations > Edit...` and click the dropdown for applications. Click on minecraft and press OK. Both client and server run profiles should both in the rop right now.

**I moved my project and everything broke!**  
Go into run configurations and double check your `VM Options` and `Working Directory` parameters.

**X mixin isnt working!**  
Double check your target and method parameters and make sure you have filled out your `@At` parameter if required.  
If you are still having issues, join the [ModStation Discord](https://discord.gg/8Qky5XY) and contact someone there.

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
