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
package com.me4502.precogs;

import com.google.inject.Inject;
import com.me4502.precogs.detection.DetectionType;
import com.me4502.precogs.detection.DetectionTypeRegistryModule;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "precogs",
        name = "Precogs",
        version = "1.2-SNAPSHOT",
        description = "Service-based API for AntiCheat plugins.",
        authors = {
                "Me4502"
        }
)
public class Precogs {

    @Inject private Logger logger;

    @Listener
    public void onServerPreInitialize(GamePreInitializationEvent event) {
        Sponge.getRegistry().registerModule(DetectionType.class, new DetectionTypeRegistryModule());
    }
}
