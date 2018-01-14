/*
 * Copyright (c) 2017-2018 Me4502 (Matthew Miller)
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
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
     * @param plugin The plugin object.
     * @return The bypass ticket if provided.
     */
    Optional<BypassTicket> requestBypassTicket(Player player, List<DetectionType> detectionTypes, Object plugin);

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
     * @param plugin The plugin object.
     * @param delay The delay before closing.
     * @param timeUnit The {@link TimeUnit} of the delay.
     * @return The bypass ticket if provided.
     */
    default Optional<BypassTicket> requestTimedBypassTicket(Player player, List<DetectionType> detectionTypes,
            Object plugin, long delay, TimeUnit timeUnit) {
        Optional<BypassTicket> bypassTicket = requestBypassTicket(player, detectionTypes, plugin);
        bypassTicket.ifPresent(ticket -> Sponge.getScheduler().createTaskBuilder().delay(delay, timeUnit).execute(() -> {
            if (!ticket.isClosed()) {
                ticket.close();
            }
        }).submit(plugin));

        return bypassTicket;
    }

    /**
     * Gets the violation level of the {@link User} for the {@link DetectionType}
     * as a double.
     *
     * <p>
     *     Double precision is not guaranteed to be provided by the AntiCheat plugin.
     * </p>
     *
     * @param user The user.
     * @param detectionType The detection type.
     * @return The violation level
     */
    double getViolationLevel(User user, DetectionType detectionType);

    /**
     * Logs a violation on a {@link User} of a specific {@link DetectionType}.
     *
     * <p>
     *     Double precision is not guaranteed to be supported by the AntiCheat plugin.
     * </p>
     *
     * @param user The user.
     * @param detectionType The detection type.
     * @param violationLevel The violation level.
     */
    void logViolation(User user, DetectionType detectionType, double violationLevel);

    /**
     * Logs a violation on a {@link User} of a specific {@link DetectionType}.
     *
     * <p>
     *     Double precision is not guaranteed to be supported by the AntiCheat plugin.
     *
     *     Descriptions are also not guaranteed to be respected by the AntiCheat plugin.
     * </p>
     *
     * @param user The user.
     * @param detectionType The detection type.
     * @param violationLevel The violation level.
     * @param description The violation description.
     */
    void logViolation(User user, DetectionType detectionType, double violationLevel, String description);
}
