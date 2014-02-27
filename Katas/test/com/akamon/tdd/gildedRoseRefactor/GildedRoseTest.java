package com.akamon.tdd.gildedRoseRefactor;

import com.akamon.tdd.gildedRoseRefactor.glidedRose.GildedRose;
import com.akamon.tdd.gildedRoseRefactor.glidedRose.IGildedRose;
import com.akamon.tdd.gildedRoseRefactor.item.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GildedRoseTest {

	private static final int QUALITY_UPPER_LIMIT = 50;
	private static final int QUALITY_LOWER_LIMIT = 0;

	private IGildedRose gildedRose;
	private Item name;

	@Before
	public void setUp() throws Exception
	{
		gildedRose = GildedRose.create();
	}


	@Test
	public void sellInValue() throws Exception
	{
		final String anyName = "name";
		final int sellInValue = 3;
		final int anyQuality = 4;
		name = new Item(anyName, sellInValue, anyQuality);

		final int result = name.sellIn;
		assertEquals("Not Sell in value", result, sellInValue);
	}

	@Test
	public void qualityDegradeFast() throws Exception
	{
		final int expired = 0;
		final int baseQuality = 10;
		final int normalRate = 1;
		final int expectedQuality = baseQuality - ( normalRate * 2);
		name = new Item("anyName", expired, baseQuality);
		gildedRose.updateQuality(name);

		assertEquals("Quality not degrading twice fast", name.quality, expectedQuality);
	}

	@Test
	public void qualityNeverNegative() throws Exception
	{
		final int baseQuality = 0;
		final int anySellIn = 1;
		name = new Item("anyName", anySellIn, baseQuality);

		gildedRose.updateQuality(name);

		final boolean notNegative = name.quality >= QUALITY_LOWER_LIMIT;
		assertTrue("Quality is negative", notNegative);
	}

	@Test
	public void brieIncreasesInQuality() throws Exception
	{
		final int anyQualityUnderLimit = QUALITY_UPPER_LIMIT - 10;
		final int anySellIn = 15;
		final String theName = "Aged Brie";
		name = new Item(theName, anySellIn, anyQualityUnderLimit);

		gildedRose.updateQuality(name);

		final boolean isIncreased = name.quality > anyQualityUnderLimit;
		assertTrue("Brie doesn't increases in quality", isIncreased);
	}

	@Test
	public void qualityHasAnUpperLimit() throws Exception
	{
		final int anySellIn = 1;
		final String theName = "Aged Brie";
		name= new Item(theName, anySellIn, QUALITY_UPPER_LIMIT);

		gildedRose.updateQuality(name);

		final boolean limitNotBroken = name.quality <= QUALITY_UPPER_LIMIT;
		assertTrue("Quality not upper limit", limitNotBroken);
	}


	@Test
	public void sulfurasIsLengendary() throws Exception
	{
		final int sellIn = 1;
		final String theName = "Sulfuras, Hand of Ragnaros";
		name = new Item(theName, sellIn, QUALITY_UPPER_LIMIT);

		gildedRose.updateQuality(name);

		assertEquals("sellIn not same", name.sellIn, sellIn);
		assertEquals("Quality has decrease", name.quality, QUALITY_UPPER_LIMIT);
	}

}
