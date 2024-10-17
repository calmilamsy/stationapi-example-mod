# Fabric Example Mod with StationAPI and BIN Mappings for beta 1.7.3 server + client

## Setup

Run the `_setup/setupMod` task and give it the inputs it needs. **This is a required step.**

[See the StationAPI wiki.](https://github.com/ModificationStation/StationAPI/wiki)

## Common Issues

**My project isn't building after updating babric loom/stationapi!**  
Run a gradle task with `--refresh-dependencies` as an argument, and this should be fixed. If not, try deleting your project's `.gradle` folder, and try again.

**I get "Invalid source release: 17" as an error!**  
Use Java 17. Open up `File > Project Structure` and change your SDK to Java 17.  
If you still get the issue, you may need to go into `File > Settings > Build, Execution, Deployment > Build Tools > Gradle` and change the Java that Gradle uses too.

**How do I stop server.properties from constantly changing?**  
Remove the last line in the `gitignore` file.

**My client hangs on a blank screen on trying to my test server!**  
Open your `server.properties` and set `online-mode` to `false`.

[Here for more issues.](https://github.com/calmilamsy/BIN-fabric-example-mod#common-issues)

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
