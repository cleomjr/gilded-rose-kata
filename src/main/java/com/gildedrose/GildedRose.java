package com.gildedrose;

class GildedRose {

    private final QualityUpdater qualityUpdater;

    /**
     * Don't ever touch items property and Item class!
     */
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        this.qualityUpdater = new QualityUpdater();
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityUpdater.chooseStrategy(item.name).update(item);
        }
    }
}
