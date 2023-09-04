package it.mauluk92;

import it.mauluk92.clockmaker.ClockMaker;
import it.mauluk92.config.global.HeartOfFabularia;
import it.mauluk92.net.MasterWheel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext heart = new AnnotationConfigApplicationContext(HeartOfFabularia.class);
        ClockMaker clockMaker = heart.getBean(ClockMaker.class);
        MasterWheel masterWheel = heart.getBean("masterWheel", MasterWheel.class);
        clockMaker.weave(masterWheel);
    }
}