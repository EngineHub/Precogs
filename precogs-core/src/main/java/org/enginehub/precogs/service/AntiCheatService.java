/*
 * Copyright (c) Me4502
 * Copyright (c) EngineHub Team and Contributors
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

package org.enginehub.precogs.service;

import org.enginehub.precogs.detection.DetectionType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * A base AntiCheat service for plugins to implement.
 *
 * <p>
 *  All implementing plugins should provide this to the platform's Services API.
 * </p>
 */
public interface AntiCheatService {

    /**
     * Requests a {@link BypassTicket}.
     *
     * <p>
     * If the bypass ticket is provided, this will disable the given
     * {@link DetectionType}s for the given player.
     * </p>
     *
     * @param uuid The UUID of the player.
     * @param detectionTypes The detection types list.
     * @param plugin The plugin object.
     * @return The bypass ticket if provided.
     */
    Optional<BypassTicket> requestBypassTicket(UUID uuid, List<DetectionType> detectionTypes, Object plugin);

    /**
     * Gets the violation level of the Player for the {@link DetectionType}
     * as a double.
     *
     * <p>
     * Double precision is not guaranteed to be provided by the AntiCheat plugin.
     * </p>
     *
     * @param uuid The UUID of the player.
     * @param detectionType The detection type.
     * @return The violation level
     */
    double getViolationLevel(UUID uuid, DetectionType detectionType);

    /**
     * Logs a violation on a Player of a specific {@link DetectionType}.
     *
     * <p>
     * Double precision is not guaranteed to be supported by the AntiCheat plugin.
     * </p>
     *
     * @param uuid The UUID of the player.
     * @param detectionType The detection type.
     * @param violationLevel The violation level.
     */
    void logViolation(UUID uuid, DetectionType detectionType, double violationLevel);

    /**
     * Logs a violation on a Player of a specific {@link DetectionType}.
     *
     * <p>
     * Double precision is not guaranteed to be supported by the AntiCheat plugin.
     *
     * Descriptions are also not guaranteed to be respected by the AntiCheat plugin.
     * </p>
     *
     * @param uuid The UUID of the player.
     * @param detectionType The detection type.
     * @param violationLevel The violation level.
     * @param description The violation description.
     */
    void logViolation(UUID uuid, DetectionType detectionType, double violationLevel, String description);
}
