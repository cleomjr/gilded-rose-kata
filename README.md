# Gilded Rose Kata (Java version)

## Table of contents
* [General info](#general-info)
* [Requirements](#requirements)
* [Proposed Solution](#proposed-solution)
* [Technologies](#technologies)
* [Setup](#setup)
* [Running JUnit Tests](#running-junit-tests)

## General info
Quoting the requirements document:
_Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures._

## Requirements
These are the general requirements:

	- All items have a SellIn value which denotes the number of days we have to sell the item
	- All items have a Quality value which denotes how valuable the item is
	- At the end of each day our system lowers both values for every item

And these are the specific ones:

	- Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert
	- "Conjured" items degrade in Quality twice as fast as normal items
    - An item can never have its Quality increase above 50, however "Sulfuras" is a
    legendary item and as such its Quality is 80 and it never alters

## Proposed Solution
Following the guidelines, I made changes on UpdateQuality method, without altering the Item class or
Items property, as those belong to the goblin in the corner who will insta-rage and one-shot me
as he doesn't believe in shared code ownership.

The approach aimed to write a maintainable and testable code that could easily expand
for future special items without compromising simplicity.
For that, I used the Strategy pattern to cover all quality update situations.
This considerably reduced the condition complexity of the previous version.

My personal challenge was to have a solution without a single usage of `if` or `switch`.
This could be achieved using Java 8 `Supplier` for the choice of what strategy to use based on the item name.
For the simple cases, I opted to use the ternary operator though.

## Technologies
The `gilded-rose-kata` project is created with:
* Java 8
* JUnit 5.6
* Gradle 6+

## Setup
To run this project, do it locally using gradle:

    $ cd /path/to/gilded-rose-kata
    $ gradle run --args=30

The non-required `args` option represents the amount of days to run.
So, in the example above, the application will simulate 30 days.

## Running JUnit Tests
Under the project root, run

    gradle test

once the task finishes, a report will be available for evaluation at
`gilded-rose-kata/build/reports/tests/test/classes/com.gildedrose.GildedRoseTest.html`
