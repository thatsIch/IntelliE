package de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.replicator

import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.replicator.recipe.{ExternalReplicatorCraftRecipePath, InternalReplicatorCraftRecipePath}

/**
  * Created by thatsIch on 04.08.2016.
  */
private[replicator] class ReplicatorCraftRecipe extends BaseRecipe(new InternalReplicatorCraftRecipePath, new ExternalReplicatorCraftRecipePath)
