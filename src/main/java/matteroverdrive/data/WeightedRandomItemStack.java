/*
 * This file is part of Matter Overdrive
 * Copyright (C) 2018, Horizon Studio <contact@hrznstudio.com>, All rights reserved.
 *
 * Matter Overdrive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Matter Overdrive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Matter Overdrive.  If not, see <http://www.gnu.org/licenses>.
 */
package matteroverdrive.data;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

import javax.annotation.Nonnull;

/**
 * Created by Simeon on 12/23/2015.
 */
public class WeightedRandomItemStack extends WeightedRandom.Item {
    private final ItemStack stack;

    public WeightedRandomItemStack(@Nonnull ItemStack stack) {

        this(stack, 100);
    }

    public WeightedRandomItemStack(@Nonnull ItemStack stack, int weight) {

        super(weight);
        this.stack = stack;
    }

    public ItemStack getStack() {

        if (stack.isEmpty()) {
            return null;
        }
        return stack.copy();
    }
}
