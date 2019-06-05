/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AudioPlayer;

import java.applet.AudioClip;

/**
 *
 * @author maria
 */
public class MusicPlayer {
    
     private AudioClip antibioticAudio;
     private AudioClip blockerBacteriumAudio;
     private AudioClip bombExplosionAudio;
     private AudioClip introAudio;
     private AudioClip introEndAudio; 
     private AudioClip throwBombAudio;
     private AudioClip walkAudio;
     public AudioClip heartAudio1;

    public MusicPlayer() {
        this.antibioticAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/AntibioticAudio.wav"));
        this.blockerBacteriumAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/BlockerBacteriumAudio.wav"));
        this.bombExplosionAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/BombAudio.wav"));
        this.introAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/IntroAudio.wav"));;
        this.introEndAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/IntroEndAudio.wav"));
        this.throwBombAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/ThrowBombAudio.wav"));
        this.walkAudio = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/WalkAudio.wav"));
        this.heartAudio1=java.applet.Applet.newAudioClip(getClass().getResource("/Audios/HeartAudio1.wav"));
    }
    
    public void playAntibioticAudio(){
    antibioticAudio.play();
    }
    
    public void playBlockerBacteriumAudio(){
        blockerBacteriumAudio.play();
    }
    public void playBombExplosionAudio(){
        bombExplosionAudio.play();
    }
    public void playThrowBombAudio(){
        throwBombAudio.play();
    }
    public void playWalkAudio(){
        walkAudio.play();
    }
     public void playIntroAudio(){
         introAudio.loop();
     }
     public void playIntroEndAudio()
     {
         introAudio.stop();
         introEndAudio.play();
     }
     
     public void playHeartAudio1(){
         heartAudio1.loop();
     }
     public void stopHeartAudio1(){
         heartAudio1.stop();
     }
}
