package com.gildedrose;

class GildedRose {
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (SULFURAS.equals(item.name))
                continue;

            decrementItemSellIn(item);

            switch (item.name) {
                case BACKSTAGE:
                    incrementItemQualityUpTo50(item);
                    incrementItemQualityIfSellInLessThan(item, 10);
                    incrementItemQualityIfSellInLessThan(item, 5);
                    nullifyQualityWhenNegativeSellIn(item);
                    break;
                case AGED_BRIE:
                    incrementItemQualityUpTo50(item);
                    incrementItemQualityIfSellInLessThan(item, 0);
                    break;
                default:
                    decrementQualityUpTo0(item);
                    if (item.sellIn < 0) {
                        decrementQualityUpTo0(item);
                    }
            }

        }
    }

    private void nullifyQualityWhenNegativeSellIn(Item item) {
        if (item.sellIn < 0) {
            zeroQuality(item);
        }
    }

    private void incrementItemQualityIfSellInLessThan(Item item, int maxSellIn) {
        if (item.sellIn < maxSellIn) {
            incrementItemQualityUpTo50(item);
        }
    }

    private void decrementItemSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void zeroQuality(Item item) {
        item.quality = 0;
    }

    private void decrementQualityUpTo0(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void incrementItemQualityUpTo50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
