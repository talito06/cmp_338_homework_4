
public class RunTime implements RunTimeInterface {

    private double[] runTimes = new double[10];
    private double[] memoryUsages = new double[10];
    private int index = 0;

    private TimeUnits timeUnits;
    private MemoryUnits memoryUnits;

    @Override
    public TimeUnits getTimeUnits() {

        return timeUnits;
    }

    @Override
    public void setTimeUnits(TimeUnits timeUnits) {

    
        this.timeUnits = timeUnits;

    }

    @Override
    public MemoryUnits getMemoryUnits() {

        return memoryUnits;
    }

    @Override
    public void setMemoryUnits(MemoryUnits memoryUnits) {

        this.memoryUnits = memoryUnits;
    }

    @Override
    public double getLastRunTime() {

        if (index != 0) {
            if (timeUnits == TimeUnits.Seconds)
                return runTimes[index-1]/(1000*1000*1000);
            else if (timeUnits == TimeUnits.MilliSeconds)
                return runTimes[index-1]/(1000*1000);
            else if (timeUnits == TimeUnits.MicroSeconds)
                return runTimes[index-1]/(1000);
            else
                return runTimes[index-1];
        } else {
            return 0.0;
        }
    }

    @Override
    public double getLastMemoryUsage() {

        if (index != 0) {

            if (memoryUnits == MemoryUnits.KiloBytes)
                return memoryUsages[index-1]/1024;
            else if (memoryUnits == MemoryUnits.MegaBytes)
                return memoryUsages[index-1]/(1024*1024);
            else
                return memoryUsages[index-1];

        } else {
            return 0.0;
        }
    }

    @Override
    public double[] getRunTimes() {

        if (timeUnits == TimeUnits.Seconds) {
            double[] temp = new double[10];
            for (int i=0; i<10; i++) {
                temp[i] = runTimes[i]/(1000*1000*1000);
            }

            return temp;
        }
        else if (timeUnits == TimeUnits.MilliSeconds) {
            double[] temp = new double[10];
            for (int i=0; i<10; i++) {
                temp[i] = runTimes[i]/(1000*1000);
            }

            return temp;
        }
        else if (timeUnits == TimeUnits.MicroSeconds) {
            double[] temp = new double[10];
            for (int i=0; i<10; i++) {
                temp[i] = runTimes[i]/(1000);
            }

            return temp;
        }
        else
            return runTimes;
    }

    @Override
    public double[] getMemoryUsages() {

        if (memoryUnits == MemoryUnits.KiloBytes)
        {
            double[] temp = new double[10];
            for (int i=0; i<10; i++)
                temp[i] = memoryUsages[i]/1024;

            return temp;
        }
        else if (memoryUnits == MemoryUnits.MegaBytes)
        {
            double[] temp = new double[10];
            for (int i=0; i<10; i++)
                temp[i] = memoryUsages[i]/(1024*1024);

            return temp;
        }
        else
            return memoryUsages;
    }

    @Override
    public void resetRunTimes() {

        runTimes = new double[10];
        memoryUsages = new double[10];
        index = 0;
    }

    @Override
    public void addRuntime(long runTime) {

        if (index < runTimes.length) {
            runTimes[index] = runTime;
            memoryUsages[index] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            index++;
        } else {
            for ( int i = 0 ; i < (runTimes.length - 1) ; i++ ) {
                runTimes[i] = runTimes[i+1];
                memoryUsages[i] = memoryUsages[i+1];
            }
            memoryUsages[9] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            runTimes[9] = runTime;
        }
    }

    @Override
    public double getAverageRunTime() {

        double sum = 0;
        for ( int i = 0 ; i < index; i++) {
            sum = sum + runTimes[i];
        }

        double averageRunTime = (double) sum / index;

        if (timeUnits == TimeUnits.Seconds)
            return averageRunTime/(1000*1000*1000);
        else if (timeUnits == TimeUnits.MilliSeconds)
            return averageRunTime/(1000*1000);
        else if (timeUnits == TimeUnits.MicroSeconds)
            return averageRunTime/(1000);
        else
            return averageRunTime;
    }

    @Override
    public double getAverageMemoryUsage() {

        double sum = 0;
        for ( int i = 0 ; i < index; i++) {
            sum = sum + memoryUsages[i];
        }

        double averageMemoryUsage = (double) sum / index;
        if (memoryUnits == MemoryUnits.KiloBytes)
            return averageMemoryUsage/1024;
        else if (memoryUnits == MemoryUnits.MegaBytes)
            return averageMemoryUsage/(1024*1024);
        else
            return averageMemoryUsage;

    }

}