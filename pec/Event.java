package pec;
 abstract class Event implements IEvent{
    double time;

     public double getTime(){
        return this.time;
     };

     public void setTime(double _time){
         this.time=_time;
     }

     public void execute(){
         return ;
     }

     public int compareTo(Event that) {
         return Double.compare(this.time,that.time);
     }
 }
