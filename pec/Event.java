package pec;
 abstract class Event implements IEvent{
    int time;

     public double getTime(){
        return this.time;
     };


     public int compareTo(Event that) {
         return Double.compare(this.time,that.time);
     }
 }
