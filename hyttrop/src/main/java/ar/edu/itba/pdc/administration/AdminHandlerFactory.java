package ar.edu.itba.pdc.administration;

import ar.edu.itba.pdc.commands.SetL33tCommand;
import ar.edu.itba.pdc.commands.StatisticsCommand;
import ar.thorium.handler.EventHandlerFactory;

import org.apache.log4j.Logger;

public class AdminHandlerFactory implements EventHandlerFactory<AdminHandler> {

    private AdminProtocol protocol;
    private static final Logger logger = Logger.getLogger(AdminHandlerFactory.class);

    public AdminHandlerFactory() {
        this.protocol = new AdminProtocol();
        try{
            protocol.addCommand(new SetL33tCommand());
            protocol.addCommand(new StatisticsCommand());
        }catch (UncompliantAdministrativeCommandException e){
            logger.error("Command is not compliant.");
        }
    }

    @Override
    public AdminHandler newHandler() throws IllegalAccessException,
            InstantiationException {
        return new AdminHandler(protocol);
    }

}
