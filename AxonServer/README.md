## Running Axon Server Standard Edition (SE) in Docker

### Requirements
 - Docker (& Docker daemon started on mac)
 - bash /zsh 

### Start server
This script is based on Axon Server Standard Edition Docker container
- run `./start.sh`
  
It will run it and map the "`data`", "`events`", and "`config`" directories in the current directory as volumes.
### Stop server
- run `./stop.sh`

It will stop the container and remove it. 
Note that this will _not_ actually remove the Event Store and ControlDB, as they are persisted in the volumes' directories. 

### Cleanup volumes 
- run `cleanup.sh` will clean the volumes directories*.

*Notice (in the Unix/WSL2 environments) that the contents are owned by the "root" user, so you should use "`sudo`".