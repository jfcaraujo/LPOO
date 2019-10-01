# LPOO_TG Random Adventure Roguelike

RAR is a text based roguelike rpg game in which you are the hero of your own story with randomly generated adventures.
The objective of the game is to reach the End, where you will fight a boss monster, and defeat it.

This Project was developed for LPOO 2018/2019 by:

Gonçalo Pereira - up201705971

João Araújo     - up201705577

## Implemented Features
Randomly generated map, each position content is unknown until the player goes over it, after which the content is added to the minimap

The Map has a End, cities, woods and walls(used to prevent the player from going out of bounds)

The Cities allow the player to heal(restores health and mana, won work if at full health and mana) and to buy equipment(improves stats)/food(reduces hunger). After opening a sub menu, press esc to return to the previous menu. When you buy a weapon/armor, it autoequips. You can only buy a weapon/armor whose minimum level <= your level, and that you haven't already equiped or that you haven't already equiped one better 

Monsters (will randomly spawn on woods, boss always spawns on end) fight the player, and upon defeat will drop gold and exp

The player can move using the arrow keys, the game closes with 'q' or by closing the window. When the hero moves, he gains hunger, if the hunger reaches the maximum, he starts to lose health

When fighting, the user can use the basic attack or skills which use mana, the hero unlocks new skills when he levels up. The hero can also run, sucess chance depends on agility. The attacks damage depends on defence and attack. The atacks of the hero (only the base attack) and the monster can fail, the probability depends on agility but is really low (2.5% per difference in agility points.

Game over message, displays progress

## Planned Features

Add gathering resources options (mining, forage, chop, fish) and a crafting system for creating armor and weapons using the ingredients gathered

Add Abstract Factory and Swing

## Design

We used the Model View Controler Architeture, which is separated by packages

Problem in context: Different processing of keys and draw depending on position/state

Pattern: State pattern

Implementation: Created several states which implement the abstract class hero state

Consequences: Localizes and partitions behavior for different states and makes state transitions explicit


Problem in context: Separate the views from Lanterna and Swing

Pattern: Abstract Factory

Implementation: We were unable to implement due to time constrains

Consequences: Would isolate concrete classes, current consequences are no swing

## Known Code Smells and Refactoring Suggestions

There was a lot of repeated code for the diferent types of places, which was solved by using an abstract class for Element

There was a lot of repeated code (in general), which was solved by using auxiliary functions.

Hero was using Element, which created unnecessary variables. Was fixed by using Position.

Made elements which were unnecessarially public private or package-private.

A lot of bloaters/duplicated code solved by auxiliary functions/classes (extract method)

## Testing Results

https://drive.google.com/open?id=1eajjdImj77Fk0CqJOy2MzBSM9begrWrI

https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_35/blob/master/docs/index.html

## Self-evaluation

The work was evenly split

Drive with the pictures: https://drive.google.com/open?id=1eajjdImj77Fk0CqJOy2MzBSM9begrWrI
