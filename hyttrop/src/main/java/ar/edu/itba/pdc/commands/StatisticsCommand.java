package ar.edu.itba.pdc.commands;

import ar.edu.itba.pdc.administration.AdminProtocol;
import ar.edu.itba.pdc.statistics.StatisticsWatcher;

public class StatisticsCommand implements Command{

    @Override
    public String getName() {
        return "statistics";
    }

    @Override
    public String execute(String[] args) {

        StatisticsWatcher w = StatisticsWatcher.getInstance();
        if(args[0].equals("set")){
            if(args.length > 2){

                if(args[2].equals("on")){
                    w.start();
                    return "Calculo de estadisticas encendido.\n";
                }
                else if(args[2].equals("off")){
                    w.stop();
                    return "Calculo de estadisticas apagado.\n";
                }else if(args[2].equals("reset")){
                    boolean wasRunning = w.isRunning();
                    w.stop();
                    w.resetStatistics();
                    if(wasRunning){
                        w.start();
                        return "El calculo de estadisticas se ha reiniciado.\n";
                    }else{
                        return "El calculo de estadisticas se ha reiniciado y continua detenido.\n";
                    }
                }else{
                    return this.shortHelp();
                }
            }else{
                return this.shortHelp();
            }
        }else if(args[0].equals("get")){
            if(w.isRunning()){
                return "Las estadisticas son:\n" + w.getStatistics();
            }else{
                return "El calculo de estadisticas se encuentra apagado. Enciendalo para obtener datos.\n";
            }
        }

        return shortHelp();
    }

    @Override
    public String shortHelp() {
        return "[set|get|help] statistics [on|off|reset]\n";
    }

    @Override
    public String descriptiveHelp() {
        return "Con este comando se podra activar, desactivar u obtener el calculo de estadisticas.\n[set|help] statistics [on|off|reset]\n";
    }

    @Override
    public boolean acceptsAction(AdminProtocol.AdminProtocolActions action) {
        return true;
    }
}
