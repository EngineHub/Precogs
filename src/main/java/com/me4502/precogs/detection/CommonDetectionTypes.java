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
package com.me4502.precogs.detection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

/**
 * A common class containing lists of very common categories of cheat detections
 * that will be accessed by plugins.
 */
public class CommonDetectionTypes {

    private static final Map<Category, ImmutableList<DetectionType>> DETECTION_TYPES_ARRAY = ImmutableMap.<Category, ImmutableList<DetectionType>>builder()
            .put(Category.MOVEMENT, ImmutableList.of())
            .put(Category.FLY, ImmutableList.of())
            .put(Category.COMBAT, ImmutableList.of())
            .put(Category.INVENTORY, ImmutableList.of())
            .put(Category.INTERACTION, ImmutableList.of())
            .put(Category.CHAT, ImmutableList.of())
            .put(Category.BREAK, ImmutableList.of())
            .put(Category.PLACE, ImmutableList.of())
            .build();

    /**
     * Gets all {@link DetectionType}s for the given {@link Category}.
     *
     * @param category The category.
     * @return The list of detections.
     */
    public static ImmutableList<DetectionType> getDetectionTypesFor(Category category) {
        return DETECTION_TYPES_ARRAY.get(category);
    }

    /**
     * Provides a list of {@link DetectionType}s for the {@link Category}.
     *
     * <p>
     *     This is built for AntiCheat plugins to provide via. If you are not
     *     an anticheat plugin please do not call this method.
     * </p>
     *
     * @param category The category.
     * @param detectionTypes The detection type list.
     */
    public static void provideDetectionTypesFor(Category category, List<DetectionType> detectionTypes) {
        DETECTION_TYPES_ARRAY.put(category, ImmutableList.copyOf(detectionTypes));
    }

    /**
     * Common lists of categories.
     */
    public enum Category {
        MOVEMENT,
        FLY,
        COMBAT,
        INVENTORY,
        INTERACTION,
        CHAT,
        BREAK,
        PLACE
    }
}
