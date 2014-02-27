package com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence;

import com.akamon.tdd.gildedRoseRefactor.glidedRose.GildedRose;
import com.akamon.tdd.gildedRoseRefactor.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 22/02/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class ManipulateAndResetQualitySentence implements ISentence
{
	public void sentence(Item item)
	{
		final String itemName = item.name;
		final boolean isSellinLowerLimit = item.sellIn < GildedRose.QUALITY_LOWER_LIMIT;
		final boolean isQualityLowerLimit = item.quality > GildedRose.QUALITY_LOWER_LIMIT;
		final boolean isNotAgedBrie = !itemName.equals(GildedRose.AGED_BRIE);
		final boolean isNotBackStage = !itemName.equals(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT);
		final boolean isNotSulfuras = !itemName.equals(GildedRose.SULFURAS_HAND_OF_RAGNAROS);
		final boolean isQualityUpperLimit = item.quality < GildedRose.QUALITY_UPPER_LIMIT;

		if (isSellinLowerLimit && isNotAgedBrie)
		{
			if (isNotBackStage && isNotSulfuras && isQualityLowerLimit )
			{
				item.quality--;
			}
			else
			{
				item.quality = GildedRose.QUALITY_RESET_LIMIT;
			}
		}
		else if (isQualityUpperLimit)
		{
			item.quality++;
		}
	}
}
