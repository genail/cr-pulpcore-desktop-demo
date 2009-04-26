/**
 * Copyright (c) 2009, Coral Reef Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  * Neither the name of the Coral Reef Project nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package pl.graniec.coralreef.pulpcore.desktop.demos.clock;

import static pulpcore.image.Colors.BLACK;

import java.util.Calendar;

import pulpcore.Input;
import pulpcore.scene.Scene2D;
import pulpcore.sprite.FilledSprite;
import pulpcore.sprite.ImageSprite;

public class Clock extends Scene2D {
    
    ImageSprite secondHand, minuteHand, hourHand;

    @Override
    public void load() {
        // Load clock hands
        secondHand = new ImageSprite("SecondHand.png", 320, 240);
        minuteHand = new ImageSprite("MinuteHand.png", 320, 240);
        hourHand = new ImageSprite("HourHand.png", 320, 240);
        
        // Add the sprites to the scene
        add(new FilledSprite(BLACK));
        add(new ImageSprite("face.png", 80, 0));
        add(hourHand);
        add(minuteHand);
        add(secondHand);
    }
    
    @Override
    public void update(int elapsedTime) {
        // Update clock hands with the current time
        Calendar time = Calendar.getInstance();
        double seconds = time.get(Calendar.SECOND) + time.get(Calendar.MILLISECOND) / 1000.0;
        double minutes = time.get(Calendar.MINUTE) + seconds / 60;
        double hours = time.get(Calendar.HOUR) + minutes / 60;
        secondHand.angle.set(seconds * 2*Math.PI / 60);
        minuteHand.angle.set(minutes * 2*Math.PI / 60);
        hourHand.angle.set(hours * 2*Math.PI / 12);
        
        if (Input.isPressed(Input.KEY_ESCAPE)) {
        	System.exit(0);
        }
    }
}
