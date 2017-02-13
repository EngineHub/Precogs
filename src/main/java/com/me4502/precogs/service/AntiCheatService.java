/*
 * Copyright (c) 2017-2017 Me4502 (Matthew Miller)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.me4502.precogs.service;

import com.me4502.precogs.detection.DetectionType;
import org.spongepowered.api.entity.living.player.Player;

import java.util.List;
import java.util.Optional;

/**
 * A base AntiCheat service for plugins to implement.
 *
 * All implementing plugins should provide this to the Sponge Services API.
 */
public interface AntiCheatService {

    /**
     * Requests a {@link BypassTicket}.
     *
     * <p>
     *     If the bypass ticket is provided, this will disable the given
     *     {@link DetectionType}s for the given player.
     * </p>
     *
     * @param player The player.
     * @param detectionTypes The detection types list.
     * @return The bypass ticket if provided.
     */
    Optional<BypassTicket> requestBypassTicket(Player player, List<DetectionType> detectionTypes);
}
