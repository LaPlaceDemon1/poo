package pec;

public interface IEvent
{
    public double getTime();

    public void setTime(double _time);

    public void execute();

    public int compareTo(IEvent other);
}