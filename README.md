# Haut Standing : The Game

## Features (TODO)

* Implements cards deck to some board components


* Roll dice is dependant of player characteristics


* Add healthcheck logic


* Secure ID Generation for rooms and players


* Add details to /update endpoint on case of room close 


* Design lobby or mechanic for waiting players

## Features (DONE)

### Controllers

* Implement game endpoints


  * /game
    * test endpoint


* /game/test
    * test endpoint

* /game/register
    * add player characteristic to server storage


  * /game/update?roomId={int}
    * update state 
    

  * /game/join?roomId={int}
    * join room / add player to room
    

  * /game/roll?roomId={int}&playerId={int}
    * roll dices

### Engine

* MoveCommand
  * Classic role dice

### State

* Keep track of board and players