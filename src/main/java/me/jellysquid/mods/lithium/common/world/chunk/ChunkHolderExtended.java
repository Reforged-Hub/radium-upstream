package me.jellysquid.mods.lithium.common.world.chunk;

import net.minecraft.server.world.OptionalChunk;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;

import java.util.concurrent.CompletableFuture;

public interface ChunkHolderExtended {
    /**
     * @return The existing future for the status at ordinal {@param index} or null if none exists
     */
    CompletableFuture<OptionalChunk<Chunk>> lithium$getFutureByStatus(int index);

    /**
     * Updates the future for the status at ordinal {@param index}.
     */
    void lithium$setFutureForStatus(int index, CompletableFuture<OptionalChunk<Chunk>> future);

    /**
     * Updates the last accessed timestamp for this chunk. This is used to determine if a ticket was recently
     * created for it.
     *
     * @param time The current time
     * @return True if the chunk needs a new ticket to be created in order to retain it, otherwise false
     */
    boolean lithium$updateLastAccessTime(long time);

    WorldChunk getCurrentlyLoading();
}
