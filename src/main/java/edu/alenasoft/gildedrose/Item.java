package edu.alenasoft.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    private ItemType itemType;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
        classifyOldItems();
    }

    public Item(String name, int sellIn, int quality, ItemType itemType) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.itemType = itemType;
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public ItemType getItemType() {
        return itemType;
    }

    private void classifyOldItems() {
        switch (this.name) {
            case "Sulfuras, Hand of Ragnaros":
                this.itemType = ItemType.LEGENDARY;
                break;
            case "Aged Brie":
            case "Backstage passes to a TAFKAL80ETC concert":
                this.itemType = ItemType.VINTAGE;
                break;
            default:
                this.itemType = ItemType.NORMAL;
        }
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", sellIn=" + sellIn + ", quality=" + quality + '}';
    }
}
