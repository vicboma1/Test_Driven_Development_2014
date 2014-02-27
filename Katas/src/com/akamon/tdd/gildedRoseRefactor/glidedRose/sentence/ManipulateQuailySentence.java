package com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence;

import com.akamon.tdd.gildedRoseRefactor.glidedRose.GildedRose;
import com.akamon.tdd.gildedRoseRefactor.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 22/02/14
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
public class ManipulateQuailySentence implements ISentence
{
	@Override
	public void sentence(Item item)
	{
		final String itemName = item.name;
		final int totalSelling = 11;
		final boolean isNotAgedBrie = !itemName.equals(GildedRose.AGED_BRIE);
		final boolean isNotBackStage = !itemName.equals(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT);
		final boolean isBackStage = !isNotBackStage;
		final boolean isQualityLowerLimit = item.quality > GildedRose.QUALITY_LOWER_LIMIT;
		final boolean isNotSulfuras = !itemName.equals(GildedRose.SULFURAS_HAND_OF_RAGNAROS);
		final boolean isQualityUpperLimit = item.quality < GildedRose.QUALITY_UPPER_LIMIT;

		if (isNotAgedBrie && isNotBackStage && isNotSulfuras && isQualityLowerLimit)
		{
			item.quality--;
		}
		else if (isQualityUpperLimit)
		{
			item.quality++;

			if (isBackStage && item.sellIn < totalSelling && isQualityUpperLimit)
			{
				item.quality++;
			}
		}
	}
}
