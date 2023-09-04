package it.mauluk92.config.global;

import it.mauluk92.config.channel.first.FirstWheelChannelConfig;
import it.mauluk92.config.channel.master.MasterWheelChannelConfig;
import it.mauluk92.config.channel.second.SecondWheelChannelConfig;
import it.mauluk92.config.clockmaker.ClockmakerConfig;
import it.mauluk92.config.net.NetOfWheelsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({NetOfWheelsConfig.class,
        MasterWheelChannelConfig.class,
        ClockmakerConfig.class})
public class HeartOfFabularia {

}
