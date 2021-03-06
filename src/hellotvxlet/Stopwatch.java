package hellotvxlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Timer;
import java.util.TimerTask;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;

/**
 *
 * @author student
 */
public class Stopwatch extends TimerTask{
    public static boolean gameEnds = false;
    int ms;
    int seconds;
    int minutes;
    boolean hasEnded = false;
    //int milliseconds;
    HStaticText secondsText;
    HStaticText minutesText;
    HStaticText msText;
    HStaticText gameOverText;
    HStaticText restartText;
    String secondsString = "00";
    String minutesString = "00";
    String msString = "00";
    
    HStaticText endMin;
    HStaticText endSec;
    HStaticText endMs;
    
    Timer timerSw;
    Timer timerRoad;

    
    public void setStopwatchText(HStaticText minutesText, HStaticText secondsText, HStaticText msText, HStaticText gameOverText, HStaticText restartText){
        this.secondsText = secondsText;
        this.minutesText = minutesText;
        this.msText = msText;
        this.gameOverText = gameOverText;
        this.restartText = restartText;
    }
    
    public void run(){
        if(!gameEnds)
        {
            ms++;
        }
        if(ms < 10)
        {
            msString = "0" + ms;
        }
        else if(ms >= 10)
        {
            msString = Integer.toString(ms);
        }
        
        if(ms >= 99)
        {
           ms = 0;
           seconds++;
           
        }
        
        if(seconds < 10){
            secondsString = "0" + seconds;
        }
        else if(seconds >= 10)
        {
            secondsString = Integer.toString(seconds);
        }
        
        if(seconds > 60)
        {
            minutes++;
            seconds = 0;
        }
        
        minutesString = Integer.toString(minutes);
        
        minutesText.setTextContent(minutesString + "'", HState.NORMAL_STATE);
        secondsText.setTextContent(secondsString + "\"", HState.NORMAL_STATE);
        msText.setTextContent(msString, HState.NORMAL_STATE);

        if(gameEnds)
        {
            //timerSw.cancel();
            hasEnded = true;
            gameOverText.setVisible(true);
            endMin.setTextContent(minutesString + "'", HState.NORMAL_STATE);
            endSec.setTextContent(secondsString + "\"", HState.NORMAL_STATE);
            endMs.setTextContent(msString, HState.NORMAL_STATE);
            endMin.setVisible(true);
            endSec.setVisible(true);
            endMs.setVisible(true);
            restartText.setVisible(true);          
        }
        else
        {
            if (hasEnded)
            {
                hasEnded = false;
                gameOverText.setVisible(false);
                endMin.setVisible(false);
                endSec.setVisible(false);
                endMs.setVisible(false);
                restartText.setVisible(false);
                ms = 0;
                seconds = 0;
                minutes = 0;
            }
        }
    }
    public void SetEndTime(HStaticText minText, HStaticText secText, HStaticText msText)
    {
        endMin = minText;
        endSec = secText;
        endMs = msText;
    }
    
    public void SetTimerStopwatch(Timer sw){
        timerSw = sw;
    }
    
    public void SetTimerRoad(Timer road)
    {
        timerRoad = road;
    }
}
